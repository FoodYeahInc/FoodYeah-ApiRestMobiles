package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    Customer getCustomer(Long id);

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Long id);

}
