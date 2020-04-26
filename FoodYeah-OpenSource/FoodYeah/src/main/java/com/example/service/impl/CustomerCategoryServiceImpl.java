package com.example.service.impl;

import com.example.entity.Customer_Category;
import com.example.repository.Customer_CategoryRepository;
import com.example.service.CustomerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCategoryServiceImpl implements CustomerCategoryService {
    @Autowired
    private Customer_CategoryRepository customerCategoryRepository;

    @Override
    public List<Customer_Category> findCustomerCategoryAll() {
        return customerCategoryRepository.findAll();
    }

    @Override
    public Customer_Category getCustomerCategory(Long id) {
        return customerCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public Customer_Category createCustomerCategory(Customer_Category customer_category) {
        Customer_Category CustomerCategoryDB=this.getCustomerCategory(customer_category.getId());
        if(CustomerCategoryDB!=null){
            return CustomerCategoryDB;
        }
        CustomerCategoryDB.setState("CREATED");
        CustomerCategoryDB=customerCategoryRepository.save(customer_category);
        return CustomerCategoryDB;
    }

    @Override
    public Customer_Category updateCustomerCategory(Customer_Category customer_category) {
        Customer_Category customerCategoryDB=this.getCustomerCategory(customer_category.getId());
        if(customerCategoryDB==null){
            return null;
        }
        customerCategoryDB.setCustomerCategoryName(customer_category.getCustomerCategoryName());
        customerCategoryDB.setCustomerCategoryDescription(customer_category.getCustomerCategoryDescription());
        customerCategoryDB.setState("UPDATED");
        return customerCategoryRepository.save(customerCategoryDB);
    }

    @Override
    public Customer_Category deleteCustomerCategory(Long id) {
        Customer_Category customerCategoryDB=this.getCustomerCategory(id);
        if(customerCategoryDB==null){
            return null;
        }
        customerCategoryDB.setState("DELETED");
        return customerCategoryRepository.save(customerCategoryDB);
    }
}
