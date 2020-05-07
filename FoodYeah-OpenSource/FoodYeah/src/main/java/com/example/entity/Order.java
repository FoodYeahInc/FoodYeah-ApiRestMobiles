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

    @ApiModelProperty(value="ID de la orden", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="El usuario de la orden", dataType="Customer", position=2)
    @NotNull(message = "El usuario de la orden no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Customer costumer;

    @ApiModelProperty(value="El nombre del usuario", dataType="String", position=3)
    @NotEmpty(message = "La fecha no puede ser vacía")
    @Column(name = "Date", nullable = false)
    private String date;

    @ApiModelProperty(value="El tiempo de inicio del pedido", dataType="String", position=4)
    @NotEmpty(message = "El tiempo no puede ser vacío")
    @Column(name = "init_time", nullable = false)
    private String inittime;

    @ApiModelProperty(value="El tiempo de finalización del pedido", dataType="String", position=5)
    @NotEmpty(message = "El tiempo no puede ser vacío")
    @Column(name = "end_Time", nullable = false)
    private String endtime;

    @ApiModelProperty(value="El precio total de la orden", dataType="float", position=6)
    @NotNull(message = "El precio total no puede ser vacío")
    @Column(name = "total_price", nullable = false)
    private float totalPrice;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=7)
    @NotEmpty(message = "La Order no sea crea ni se destruye sólo se transforma")
    @Column(name = "order_state",nullable = false)
    public String state;
}