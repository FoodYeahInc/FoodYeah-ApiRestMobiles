package com.example.repository;

import com.example.entity.Customer_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_CategoryRepository extends JpaRepository<Customer_Category, Long> {
}
