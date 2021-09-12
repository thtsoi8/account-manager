package com.acmebank.accountmanager.controller;

import com.acmebank.accountmanager.dto.AccountDto;
import com.acmebank.accountmanager.dto.BaseDto;
import com.acmebank.accountmanager.dto.TransactionDto;
import com.acmebank.accountmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class AccountManagerController {

    @Autowired
    private AccountService service;

    @GetMapping("/accounts/{acNo}/balance")
    public ResponseEntity<AccountDto> getLatestBalance(
            @Valid
            @PathVariable("acNo")
            @NotBlank @Size( max = 8)
            @Pattern(regexp = "^[0-9]{8}$") String acNo
    ) {
        AccountDto result = service.getAccountInfo(acNo);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/transaction")
    public ResponseEntity<AccountDto> transferMoney(
            @Valid @RequestBody TransactionDto transactionDto
    ) {
        return ResponseEntity.ok(service.transferMoney(transactionDto));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseDto> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        BaseDto result = new BaseDto();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        result.setErrors(errors);
        return ResponseEntity.badRequest().body(result);
    }
}
