package com.example.repository;

import com.example.entity.Customer;
import com.example.entity.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer>  findByCustomerCategory(CustomerCategory customerCategory);

}
