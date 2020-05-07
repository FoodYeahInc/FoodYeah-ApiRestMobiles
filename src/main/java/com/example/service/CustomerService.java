package com.example.service;

import com.example.entity.Customer;
import com.example.entity.CustomerCategory;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    Customer getCustomer(Long id);

    List<Customer> findByCustomerCategory(CustomerCategory category);

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Long id);

}
