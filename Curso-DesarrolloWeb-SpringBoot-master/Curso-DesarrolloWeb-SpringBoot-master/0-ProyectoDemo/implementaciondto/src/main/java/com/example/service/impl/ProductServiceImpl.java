package com.example.service.impl;

import com.example.dto.CreateProductDTO;
import com.example.dto.EditProductDTO;
import com.example.dto.ProductDTO;
import com.example.dto.converter.ProductDTOConverter;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOConverter productDTOConverter;



    @Override
    public Product save(CreateProductDTO productDTO) {
        Product product=productDTOConverter.convertToEntity(productDTO);
        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productsDTO=productRepository.findAll().stream().map(productDTOConverter::convertToDto)
                .collect(Collectors.toList());
        return productsDTO;
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        //Luego habra manejo de exception
        return productRepository.findById(id).map(productDTOConverter::convertToDto);
    }




    @Override
    public Product edit(EditProductDTO productDTO, Long id) {
        return productRepository.findById(id).map(p -> {
            p.setName(productDTO.getName());
            p.setPrice(productDTO.getPrice());
            return productRepository.save(p);
        }).orElse(null);
    }


    @Override
    public void deleteById(Long id) {
            productRepository.deleteById(id);
    }


}
