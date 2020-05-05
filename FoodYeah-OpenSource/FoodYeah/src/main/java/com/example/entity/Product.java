package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @ApiModelProperty(value="ID del Producto", dataType="Long",  example="1", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Categoría del producto", dataType="Categoria", position=2)
    @NotNull(message = "La categoria no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ProductCategory category;
    
    @ApiModelProperty(value="Nombre del producto", dataType="String", example="Lomo saltado", position=3)
    @NotEmpty(message = "El nombre no deber ser vacio")
    @Column(name = "product_name",nullable = false)
    private String productName;

    @ApiModelProperty(value="Descripción del producto", dataType="float", example="69.99", position=4)
    @Column(name = "product_price",nullable = false)
    private float productPrice;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=6)
    @NotEmpty(message = "La Order no sea crea ni se destruye sólo se transforma")
    @Column(name = "product_state",nullable = false)
    public String state;

    @ApiModelProperty(value="dia del menu de venta", dataType="Date",  example="CREATED", position=5)
    @NotEmpty(message = "La Order no sea crea ni se destruye sólo se transforma")
    @Column(name = "product_sellday",nullable = false)
    public Date sellday;
    //TODO: Sellday
}
