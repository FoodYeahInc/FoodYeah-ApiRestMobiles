package com.example.repository;

import com.example.entity.Customer;
import com.example.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByNumberId(String numberId);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByRegion(Region region);
    List<Customer> findby
}
