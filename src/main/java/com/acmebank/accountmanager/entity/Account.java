package com.acmebank.accountmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "ACNO")
    private String acNo;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "LASTUPDATETIMESTAMP")
    private Date lastUpdateTimestamp;

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("acNo='").append(acNo).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", lastUpdateTimestamp=").append(lastUpdateTimestamp);
        sb.append('}');
        return sb.toString();
    }
}
