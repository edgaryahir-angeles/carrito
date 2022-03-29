package com.example.prueba.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuario")
public class User implements Serializable {

    @Id
    private String id;
    private String usuario;
    private List<Product> productos;

}
