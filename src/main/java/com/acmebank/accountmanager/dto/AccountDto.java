package com.acmebank.accountmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto extends BaseDto implements Serializable {

    private String accountNumber;

    private String currency;

    private BigDecimal balance;

    private Date lastUpdateTimestamp;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountDto{");
        sb.append("accountNumber='").append(accountNumber).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", lastUpdateTimestamp=").append(lastUpdateTimestamp);
        sb.append('}');
        return sb.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }
}
