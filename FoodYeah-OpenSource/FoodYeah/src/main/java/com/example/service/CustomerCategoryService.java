package com.example.service;

import com.example.entity.Customer_Category;

import java.util.List;

public interface CustomerCategoryService {
    //Completed
    List<Customer_Category> findCustomerCategoryAll();
    Customer_Category getCustomerCategory(Long id);

    Customer_Category createCustomerCategory(Customer_Category customer_category);
    Customer_Category updateCustomerCategory(Customer_Category customer_category);
    Customer_Category deleteCustomerCategory(Long id);

}
