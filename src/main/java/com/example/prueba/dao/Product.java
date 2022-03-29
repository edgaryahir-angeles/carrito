package com.example.prueba.dao;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "producto")
public class Product implements Serializable {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;

}
