package com.example.prueba.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Field("id")
    private String id;
    private String usuario;
    private List<ProductDto> productos;

}
