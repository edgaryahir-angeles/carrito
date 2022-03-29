package com.example.prueba.service;

import java.util.List;

import com.example.prueba.dto.ProductDto;

public interface IproductService {

    public List<ProductDto> getProductosInventario();

    public ProductDto save(ProductDto producto);

    public ProductDto edit(ProductDto producto);

    // public List<ProductDto> getProductosCarrito(Integer idUsuario);

    public boolean delete(String idProducto);

}
