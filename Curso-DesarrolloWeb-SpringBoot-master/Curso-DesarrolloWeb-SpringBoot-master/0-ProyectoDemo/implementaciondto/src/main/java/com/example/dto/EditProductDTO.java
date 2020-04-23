package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EditProductDTO {

    private String name;
    private float price;

}