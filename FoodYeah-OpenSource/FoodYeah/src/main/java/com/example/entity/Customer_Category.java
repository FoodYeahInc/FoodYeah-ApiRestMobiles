package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="customer_categories")
public class Customer_Category {

    @ApiModelProperty(value="ID de la categoria de usuarios", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Nombre de la categoría", dataType="String", position=2)
    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name = "CustomerCategoryName",nullable = false)
    private String customerCategoryName;
    
    @ApiModelProperty(value="Descripción de la categoría", dataType="String", position=3)
    @NotEmpty(message = "La descripción no puede ser vacía")
    @Column(name = "CustomerCategoryDescription",nullable = false)
    private String customerCategoryDescription;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=5)
    @NotEmpty(message = "El costumer no sea crea ni se destruye sólo se transforma")
    @Column(name = "CustomerCategoryState",nullable = false)
    public String State;
}
