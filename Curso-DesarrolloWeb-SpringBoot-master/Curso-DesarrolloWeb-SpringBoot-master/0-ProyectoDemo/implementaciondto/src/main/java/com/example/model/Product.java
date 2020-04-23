package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Product  {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float price;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
