package com.perfulandia.cl.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.cl.Productos.model.Producto;
import com.perfulandia.cl.Productos.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> verProductos() {
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto) throws Exception {
        if (producto.getNombreProducto() == null || producto.getNombreProducto().isEmpty()) {
            throw new Exception("El nombre del producto no puede estar vacío");
        }
        return productoRepository.save(producto);
    }
}
