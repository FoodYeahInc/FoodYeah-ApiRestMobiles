package com.example.repository;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory(ProductCategory category);
    @Query(value = "SELECT * FROM Product WHERE SellDay =?1",nativeQuery = true)
    List<Product> findBySellDay(int sellday);
}
