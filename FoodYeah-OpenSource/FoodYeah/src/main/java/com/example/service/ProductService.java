package com.example.service;

import com.example.entity.Product;
import com.example.entity.Product_Category;

import java.util.List;

public interface ProductService {
    List<Product> findProductAll();
    Product getProduct(Long id);
    List<Product> findByCategory(Product_Category category);
    /*
    TODO: Implementar Sellday:
    List<Product> findBySellday(string Sellday);
    */
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);
}
