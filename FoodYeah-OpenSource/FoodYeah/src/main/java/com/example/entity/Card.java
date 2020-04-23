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

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    @ApiModelProperty(value="ID de la terjeta", dataType="long",  example="1", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Usuario de la tarjeta", dataType="Customer", position=2)
    @NotNull(message = "El usuario no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public Customer customer;

    @ApiModelProperty(value="Numero de la tarjeta", dataType="int",  example="1234567898765432", position=3)
    @NotEmpty(message = "El numero de la tarjeta no deber ser vacio")
    public int cardNumber;

    @ApiModelProperty(value="Tipo de tarjeta", dataType="bool",  example="1", position=4)
    @NotEmpty(message = "El tipo de tarjeta no deber ser vacio")
    public boolean cardType;

    @ApiModelProperty(value="El cvv o cvc de la tarjeta", dataType="byte",  example="1234", position=5)
    @NotEmpty(message = "El cvc o cvv de la tarjeta no deber ser vacio")
    public byte cardCvi;

    @ApiModelProperty(value="El nombre del usuario de la tarjeta", dataType="string",  example="Alexis Enrique Barrios Pérez", position=6)
    public String cardOwnerName;

    @ApiModelProperty(value="Fecha de expiracion de la tarjeta", dataType="string",  example="1234", position=5)
    @NotEmpty(message = "El cvc o cvv de la tarjeta no deber ser vacio")
    public String cardExpireDate;
}
