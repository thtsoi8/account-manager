package com.acmebank.accountmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto extends BaseDto implements Serializable {

    @NotNull(message = "fromAcNo cannot be null")
    @Pattern(regexp = "^[0-9]{8}$", message = "format is invalid")
    private String fromAcNo;

    @NotNull(message = "toAcNo cannot be null")
    @Pattern(regexp = "^[0-9]{8}$", message = "format is invalid")
    private String toAcNo;

    @NotNull(message = "currency cannot be null")
    private String currency;

    @NotNull(message = "amount cannot be null")
    @Positive(message = "amount must be greater than 0 ")
    private BigDecimal amount;

    public String getFromAcNo() {
        return fromAcNo;
    }

    public void setFromAcNo(String fromAcNo) {
        this.fromAcNo = fromAcNo;
    }

    public String getToAcNo() {
        return toAcNo;
    }

    public void setToAcNo(String toAcNo) {
        this.toAcNo = toAcNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("fromAcNo='").append(fromAcNo).append('\'');
        sb.append(", toAcNo='").append(toAcNo).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
