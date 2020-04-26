package com.example.service.impl;

import com.example.entity.Product_Category;
import com.example.repository.ProductCategoryRepository;
import com.example.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<Product_Category> findProduct_CategoryAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Product_Category getProduct_Category(Long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public Product_Category createProduct_Category(Product_Category product_category) {
        Product_Category product_categoryDB=this.getProduct_Category(product_category.getId());
        if(product_categoryDB!=null){
            return product_categoryDB;
        }
        product_categoryDB.setState("CREATED");
        product_categoryDB=productCategoryRepository.save(product_category);
        return product_categoryDB;
    }

    @Override
    public Product_Category updateProduct_Category(Product_Category product_category) {
        Product_Category product_categoryDB=this.getProduct_Category(product_category.getId());
        if(product_categoryDB==null){
            return null;
        }
        product_categoryDB.setProductCategoryName(product_category.getProductCategoryName());
        product_categoryDB.setProductCategoryDescription(product_category.getProductCategoryDescription());
        product_categoryDB.setState("UPDATED");
        product_categoryDB=productCategoryRepository.save(product_category);
        return product_categoryDB;
    }

    @Override
    public Product_Category deleteProduct_Category(Long id) {
        Product_Category product_categoryDB=this.getProduct_Category(id);
        if(product_categoryDB==null){
            return null;
        }
        product_categoryDB.setState("DELETED");
        return productCategoryRepository.save(product_categoryDB);
    }
}
