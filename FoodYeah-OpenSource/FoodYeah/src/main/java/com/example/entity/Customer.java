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
    @ApiModelProperty(value="ID del usuario", dataType="Long", position=1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Categoria del usuario", dataType="Customer_Category", position=2)
    @NotNull(message = "La categoría no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerCategoryId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Customer_Category costumerCategory;

    @ApiModelProperty(value="El nombre del usuario", dataType="String", position=3)
    @NotEmpty(message = "El nombre no puede ser vacio ")
    @Column(name = "CustomerName", nullable = false)
    private String CustomerName;

    @ApiModelProperty(value="La edad del usuario", dataType="byte", position=4)
    @Column(name = "CustomerAge", nullable = true)
    private byte CustomerAge;

    @ApiModelProperty(value="Ultima acción realizada por el usuario", dataType="String",  example="CREATED", position=5)
    @NotEmpty(message = "El costumer no sea crea ni se destruye sólo se transforma")
    @Column(name = "CustomerState",nullable = false)
    public String State;
    //public List<Card> Cards { get; set; }
    //public List<Order> Orders {get; set;}

}
