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
@Table(name="orders")
public class Order{

    @ApiModelProperty(value="ID de la orden", dataType="int", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(value="El usuario de la orden", dataType="Customer", position=2)
    @NotNull(message = "El usuario de la orden no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Customer costumer;

    @ApiModelProperty(value="El nombre del usuario", dataType="String", position=3)
    @NotEmpty(message = "La fecha no puede ser vacía")
    @Column(name = "Date", nullable = false)
    private String date;

    @ApiModelProperty(value="El tiempo de la realización del pedido", dataType="String", position=4)
    @NotEmpty(message = "El tiempo no puede ser vacío")
    @Column(name = "Time", nullable = false)
    private String time;

    @ApiModelProperty(value="El precio total de la orden", dataType="float", position=4)
    @NotEmpty(message = "El precio total no puede ser vacío")
    @Column(name = "TotalPrice", nullable = false)
    private float totalPrice;
}