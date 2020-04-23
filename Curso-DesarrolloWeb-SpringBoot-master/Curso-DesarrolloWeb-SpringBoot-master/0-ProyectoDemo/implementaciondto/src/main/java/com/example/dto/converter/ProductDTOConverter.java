package com.example.dto.converter;

import com.example.dto.CreateProductDTO;
import com.example.dto.EditProductDTO;
import com.example.dto.ProductDTO;
import com.example.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ProductDTOConverter {
    private final ModelMapper modelMapper;

    //mapExplicitly
    @PostConstruct
    public void init(){
        modelMapper.addMappings(new PropertyMap<Product, ProductDTO>() {

            @Override
            protected void configure() {
                map().setCategoryName(source.getCategory().getName());
            }
        });
    }

    //mapAutomatic
    public ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);

    }

    public Product convertToEntity(CreateProductDTO productDto) {
        return modelMapper.map(productDto, Product.class);

    }

    /*public Product convertToEntity(EditProductDTO productDto) {
        return modelMapper.map(productDto, Product.class);

    }*/


}
