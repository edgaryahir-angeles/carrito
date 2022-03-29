package com.example.prueba.repository;

import java.util.Optional;

import com.example.prueba.dao.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByNombre(String nombre);

}
