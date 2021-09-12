package com.acmebank.accountmanager.repository;

import com.acmebank.accountmanager.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
