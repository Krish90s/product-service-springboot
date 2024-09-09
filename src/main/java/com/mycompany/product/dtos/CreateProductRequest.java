package com.mycompany.product.dtos;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String firstName;
    private String lastName;
    private String email;
}
