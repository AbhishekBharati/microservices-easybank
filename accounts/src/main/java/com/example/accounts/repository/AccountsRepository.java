package com.example.accounts.repository;

import com.example.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional // If the query fails then because it is transaction any change in DBMS will be rolled back.
    @Modifying  // This tells the Spring that this query modifies the DBMS so it's of type transaction.
    void deleteByCustomerId(Long customerId);
}
