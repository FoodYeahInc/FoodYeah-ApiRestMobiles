package com.example.service;

import com.example.entity.CustomerCategory;

import java.util.List;

public interface CustomerCategoryService {
    List<CustomerCategory> findCustomerCategoryAll();

    CustomerCategory createCustomerCategory();
    CustomerCategory updateCustomerCategory();
    CustomerCategory deleteCustomerCategory();

    CustomerCategory getCustomerCategory(Long id);
}
