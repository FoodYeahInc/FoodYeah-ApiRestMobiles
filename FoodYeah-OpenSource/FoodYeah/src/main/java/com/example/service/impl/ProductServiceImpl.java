package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }



    @Transactional
    @Override
    public Product createProduct(Product product) {

        product.setState("CREATED");
     return  productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB=getProduct(product.getId());
        if(productDB==null){
            return null;
        }
        productDB.setCategory(product.getCategory());
        productDB.setProductName(product.getProductName());
        productDB.setProductPrice(product.getProductPrice());
        productDB.setState("UPDATED");
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB=getProduct(id);
        if(productDB==null){
            return null;
        }
        productDB.setState("DELETE");
        return productRepository.save(productDB);
    }

}
