package com.example.service;

import com.example.entity.Product;
import com.example.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);

    List<Product> findByCategory(ProductCategory category);
    Product updateStock(Long id,Double quantity);
    /*
        DataCollection<ProductDto> GetAll(int page, int take);
        ProductDto GetById(int id);
        DataCollection<ProductDto> GetByWeek(int page, int take);
        ProductDto Create(ProductCreateDto model);
        void Update(int id, ProductUpdateDto model);
        void Remove(int id);

     */

}
