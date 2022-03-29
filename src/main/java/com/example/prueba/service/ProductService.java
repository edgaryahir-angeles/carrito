package com.example.prueba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.prueba.dao.Product;
import com.example.prueba.dto.ProductDto;
import com.example.prueba.exception.RecursoDuplicadoException;
import com.example.prueba.exception.RecursoNoEncontradoExcepcion;
import com.example.prueba.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IproductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductosInventario() {
        List<Product> productos = productRepository.findAll();
        List<ProductDto> productosDtos = new ArrayList<>();

        for (Product product : productos) {
            ProductDto productoDto = new ProductDto();
            productoDto.setId(product.getId());
            productoDto.setNombre(product.getNombre());
            productoDto.setPrecio(product.getPrecio());
            productoDto.setDescripcion(product.getDescripcion());

            productosDtos.add(productoDto);
        }

        return productosDtos;
    }

    @Override
    public ProductDto save(ProductDto producto) {
        Optional<Product> product = productRepository.findByNombre(producto.getNombre().trim());

        Product pro = new Product();
        if (product.isPresent())
            throw new RecursoDuplicadoException("El producto ya se encuentra registrado " + producto.getNombre());

        pro.setNombre(producto.getNombre());
        pro.setDescripcion(producto.getDescripcion());
        pro.setPrecio(producto.getPrecio());
        productRepository.save(pro);

        return producto;
    }

    @Override
    public ProductDto edit(ProductDto producto) {
        productRepository.findById(producto.getId()).orElseThrow(
                () -> new RecursoNoEncontradoExcepcion("Producto con inválido id " + producto.getId()));

        Product pro = new Product();
        pro.setPrecio(producto.getPrecio());
        productRepository.save(pro);

        return producto;
    }

    @Override
    public boolean delete(String idProducto) {
        boolean bandera = false;

        Product prod = productRepository.findById(idProducto).orElseThrow(
                () -> new RecursoNoEncontradoExcepcion("Producto con inválido id " + idProducto));

        bandera = true;

        productRepository.delete(prod);

        return bandera;
    }

}
