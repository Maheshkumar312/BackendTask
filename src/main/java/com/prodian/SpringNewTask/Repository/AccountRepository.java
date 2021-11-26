package com.prodian.SpringNewTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.SpringNewTask.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
