package com.example.service;

import com.example.entity.Product_Category;

import java.util.List;

public interface ProductCategoryService {
    List<Product_Category> findProduct_CategoryAll();
    Product_Category getProduct_Category(Long id);

    Product_Category createProduct_Category(Product_Category product_category);
    Product_Category updateProduct_Category(Product_Category product_category);
    Product_Category deleteProduct_Category(Long id);

}
