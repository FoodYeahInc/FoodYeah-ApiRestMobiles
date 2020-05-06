package com.example.service;

import com.example.entity.Product;
import com.example.entity.ProductCategory;

import java.util.List;

public interface ProductService {
    List<Product> findProductAll();
    Product getProduct(Long id);
    List<Product> findByCategory(ProductCategory category);

    List<Product> findBySellday(int Sellday);

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);
}
