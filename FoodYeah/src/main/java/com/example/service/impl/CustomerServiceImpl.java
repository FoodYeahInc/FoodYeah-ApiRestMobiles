package com.example.service.impl;

import com.example.entity.Customer;
import com.example.entity.CustomerCategory;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findByCustomerCategory(CustomerCategory category) {
        return customerRepository.findByCustomerCategory(category);
    }

    @Override
    public Customer createCustomer(Customer customer) {

        customer.setState("CREATED");
        return customerRepository.save(customer);

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB=this.getCustomer(customer.getId());
        if(customerDB==null){
            return null;
        }
        customerDB.setCustomerAge(customer.getCustomerAge());
        customerDB.setCustomerName(customer.getCustomerName());
        customerDB.setState("UPDATED");
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB=this.getCustomer(id);
        if(customerDB==null){
            return null;
        }
        customerDB.setState("DELETED");
        return customerRepository.save(customerDB);
    }
}
