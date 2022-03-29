package com.example.prueba.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @Field("id")
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;

}
