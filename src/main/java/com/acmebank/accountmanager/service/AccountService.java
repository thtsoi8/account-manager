package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.dto.AccountDto;
import com.acmebank.accountmanager.dto.TransactionDto;
import com.acmebank.accountmanager.entity.Account;
import com.acmebank.accountmanager.repository.AccountRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository acRepo;

    public AccountDto getAccountInfo(String acNo) {
        AccountDto result = null;
        if (StringUtils.isNotBlank(acNo)) {
            Optional<Account> rec = acRepo.findById(acNo);
            if (rec.isPresent()) {
                result = convertToDto(rec.get());
            } else {
                result = new AccountDto();
                result.addError("db","Account does not exist");
            }
        }
        return result;
    }

    public AccountDto transferMoney(TransactionDto transactionDto) {
        AccountDto result;
        Optional<Account> fromAc =  acRepo.findById(transactionDto.getFromAcNo());
        Optional<Account> toAc = acRepo.findById(transactionDto.getToAcNo());

        if (fromAc.isPresent() && toAc.isPresent()) {
            Account fromRec = fromAc.get();
            Account toRec = toAc.get();
            if (fromRec.getBalance().compareTo(transactionDto.getAmount()) >= 0) {
                BigDecimal currentFromBal = fromRec.getBalance();
                fromRec.setBalance(currentFromBal.subtract(transactionDto.getAmount()));
                BigDecimal currentToBal = toRec.getBalance();
                toRec.setBalance(currentToBal.add(transactionDto.getAmount()));
                List<Account> transactions = new ArrayList<>();
                transactions.add(fromRec);
                transactions.add(toRec);
                acRepo.saveAll(transactions);
                System.out.println(fromRec.toString());
                result = convertToDto(fromRec);
            } else {
                result = convertToDto(fromRec);
                result.addError("db","Balance is not sufficient");
            }
        } else {
            result = new AccountDto();
            result.addError("db","Account does not exists");
        }
        return result;
    }

    public AccountDto convertToDto(Account account) {
        AccountDto result = new AccountDto();
        result.setAccountNumber(account.getAcNo());
        result.setCurrency(account.getCurrency());
        result.setBalance(account.getBalance());
        result.setLastUpdateTimestamp(account.getLastUpdateTimestamp());
        return result;
    }
}
