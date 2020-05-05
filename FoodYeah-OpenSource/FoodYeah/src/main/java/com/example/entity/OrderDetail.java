package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="order_details")
public class OrderDetail {
    @ApiModelProperty(value="ID del detalle de la orden", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="La orden al cual pertenece el detalle", dataType="Order", position=2)
    @NotNull(message = "La orden no puede estar vacía")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Order order;

    @ApiModelProperty(value="El producto del detalle", dataType="Product", position=3)
    @NotNull(message = "El producto no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Product product;

    @ApiModelProperty(value="La cantidad de pedidos del producto", dataType="byte", position=4)
    @NotEmpty(message = "La cantidad no puede estar vacía")
    @Column(name = "quantity", nullable = false)
    private byte quantity;

    @ApiModelProperty(value="El precio unitario", dataType="float", position=5)
    @NotEmpty(message = "El precio unitario no puede ser vacío")
    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    @ApiModelProperty(value="El precio total", dataType="float", position=6)
    @NotEmpty(message = "El precio total no puede ser vacía")
    @Column(name = "total_price", nullable = false)
    private float totalPrice;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=5)
    @NotEmpty(message = "La OrderDetail no sea crea ni se destruye sólo se transforma")
    @Column(name = "order_detail_state",nullable = false)
    public String state;
}
