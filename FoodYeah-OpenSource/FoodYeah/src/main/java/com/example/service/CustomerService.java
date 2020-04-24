package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Region;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    List<Customer> findCustomersByRegion(Region region);

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);

    Customer getCustomer(Long id);
    /*
        DataCollection<CostumerDto> GetAll(int page, int take);
        CostumerDto GetById(int id);
        CostumerDto Create(CostumerCreateDto model);
        void Update(int id, CostumerUpdateDto model);
        void Remove(int id);
     */
}
