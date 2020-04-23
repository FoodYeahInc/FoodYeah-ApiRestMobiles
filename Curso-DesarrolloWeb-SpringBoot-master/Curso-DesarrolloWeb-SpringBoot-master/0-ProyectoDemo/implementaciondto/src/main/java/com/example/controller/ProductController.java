package com.example.controller;

import com.example.dto.CreateProductDTO;
import com.example.dto.EditProductDTO;
import com.example.dto.ProductDTO;
import com.example.dto.converter.ProductDTOConverter;
import com.example.repository.CategoryRepository;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {

  @Autowired
  private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAll() {
        List<ProductDTO> products=productService.findAll();

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<ProductDTO> result = productService.findById(id);
        if (!result.isPresent())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(result);
    }


    @PostMapping("/products")
    public ResponseEntity<?> newProduct (@RequestBody CreateProductDTO productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDto));

    }



    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody EditProductDTO productDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.edit(productDto,id));
    }



   @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
