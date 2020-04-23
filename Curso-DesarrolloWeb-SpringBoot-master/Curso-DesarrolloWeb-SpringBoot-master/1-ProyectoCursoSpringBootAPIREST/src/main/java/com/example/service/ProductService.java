package com.example.service;

import com.example.entity.Category;
import com.example.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);

    List<Product> findByCategory(Category category);
    Product updateStock(Long id,Double quantity);


}
