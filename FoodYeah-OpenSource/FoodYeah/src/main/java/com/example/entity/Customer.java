package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="customers")
public class Customer {
    //int CostumerId?
    @ApiModelProperty(value="Usuario de la tarjeta", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Categoria del usuario", dataType="Customer", position=2)
    @NotNull(message = "La categoría no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private CustomerCategory costumerCategory;

    @ApiModelProperty(value="El nombre del usuario", dataType="String", position=3)
    @NotEmpty(message = "El nombre no puede ser vacio ")
    @Column(name = "costumer_name",nullable = false)
    private String costumerName;

    @ApiModelProperty(value="La edad del usuario", dataType="byte", position=4)
    @Column(name = "costumer_age",nullable = true)
    private byte costumerAge;
}
