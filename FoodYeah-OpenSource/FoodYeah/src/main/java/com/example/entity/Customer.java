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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="customers")
public class Customer {
    @ApiModelProperty(value="ID del usuario", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Categoria del usuario", dataType="Customer_Category", position=2)
    @NotNull(message = "La categoría no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private CustomerCategory customerCategory;

    @ApiModelProperty(value="El nombre del usuario", dataType="String", position=3)
    @NotEmpty(message = "El nombre no puede ser vacio ")
    @Column(name = "customer_name", nullable = false)
    private String CustomerName;

    @ApiModelProperty(value="La edad del usuario", dataType="byte", position=4)
    @Column(name = "customer_age", nullable = true)
    @NotNull(message = "No puede estar vacio")
    private byte CustomerAge;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=5)
    @NotEmpty(message = "El costumer no sea crea ni se destruye sólo se transforma")
    @Column(name = "customer_state",nullable = false)
    public String state;

    //public List<Card> Cards { get; set; }
    //public List<Order> Orders {get; set;}

}
