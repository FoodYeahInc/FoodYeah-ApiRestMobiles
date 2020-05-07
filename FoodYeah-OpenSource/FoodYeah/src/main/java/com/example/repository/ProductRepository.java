package com.example.repository;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM PRODUCTS u WHERE u.product_sellday =?1",nativeQuery = true)
    List<Product> findBySellDay(int SellDay);
    @Query(value = "SELECT * FROM  PRODUCTS,PRODUCT_CATEGORIES where PRODUCTS.ID = PRODUCT_CATEGORIES.CATEGORY_ID and PRODUCT_CATEGORIES.CATEGORY_ID = ?1  ",nativeQuery = true)
    List<Product> findByCategoryId(long categoryId);
}
