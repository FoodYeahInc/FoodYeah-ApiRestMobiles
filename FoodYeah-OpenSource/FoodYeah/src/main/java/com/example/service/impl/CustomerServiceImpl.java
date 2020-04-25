package com.example.service.impl;

import com.example.entity.Card;
import com.example.entity.Customer;
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
    public Customer createCustomer(Customer customer) {
        Customer customerDB = this.getCustomer(customer.getId())
        if(customerDB!=null){
            return customerDB;
        }
        customerDB.setState("CREATED");
        customerDB=customerRepository.save(customer);
        return customerDB;
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
    public Customer deleteCustomer(Customer customer) {
        Customer customerDB=this.getCustomer(customer.getId());
        if(customerDB==null){
            return null;
        }
        customer.setState("DELETED");
        return customerRepository.save(customer);
    }
}
