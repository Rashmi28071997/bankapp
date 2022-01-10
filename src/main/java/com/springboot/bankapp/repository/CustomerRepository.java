package com.springboot.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bankapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
