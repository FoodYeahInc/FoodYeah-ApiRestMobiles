package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Data
@Table(name = "product_categories")
public class Product_Category {
    @ApiModelProperty(value="Id de la categoría de productos", dataType="int", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(value="Nombre de la categoría", dataType="String", position=2)
    @NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name = "ProductName",nullable = false)
    private String productCategoryName;
    
    @ApiModelProperty(value="Descripción de la categoría", dataType="String", position=3)
    @NotEmpty(message = "La descripción no puede ser vacía")
    @Column(name = "ProductDescription",nullable = false)
    private String productCategoryDescription;
}
