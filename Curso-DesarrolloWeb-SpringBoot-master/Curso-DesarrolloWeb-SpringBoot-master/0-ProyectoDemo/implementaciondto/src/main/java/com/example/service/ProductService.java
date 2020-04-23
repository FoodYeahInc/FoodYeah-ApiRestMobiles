package com.example.service;

import com.example.dto.CreateProductDTO;
import com.example.dto.EditProductDTO;
import com.example.dto.ProductDTO;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService  {
    Product save(CreateProductDTO productDTO) ;
    Optional <ProductDTO> findById(Long id) ;
    List<ProductDTO> findAll() ;
    Product edit(EditProductDTO productDTO, Long id);
    void deleteById(Long id) ;
}
