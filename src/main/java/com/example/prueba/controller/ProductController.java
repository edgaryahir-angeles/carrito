package com.example.prueba.controller;

import java.util.List;

import com.example.prueba.dto.ProductDto;
import com.example.prueba.service.IproductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/miempresa/bolsa/productos")
public class ProductController {

    @Autowired
    private IproductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        log.info("Consulta todos los productos de inventario");
        List<ProductDto> getProductos = productService.getProductosInventario();

        return ResponseEntity.ok().body(getProductos);

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestHeader("x-usuario") String idUsuario, @RequestBody ProductDto producto) {
        log.info("Inserta el producto {}", producto);
        ProductDto prod = productService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestHeader("x-usuario") String idUsuario, @RequestBody ProductDto producto) {
        log.info("Inserta el producto {}", producto);
        ProductDto prod = productService.edit(producto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(prod);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestHeader("x-usuario") String idUsuario, @PathVariable String idProducto) {
        log.info("Eliminamos el producto {}", idProducto);
        try {
            productService.delete(idProducto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
