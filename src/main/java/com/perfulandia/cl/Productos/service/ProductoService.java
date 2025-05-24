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

    public Producto buscarProductoPorId(Integer id) throws Exception {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto con la id : " + id + " no existe");
        }

        Producto productoEncontrado = productoRepository.findById(id).get();

        return productoEncontrado;
    }

    public Producto crearProducto(Producto producto) throws Exception {
        if (producto.getNombreProducto() == null || producto.getNombreProducto().isEmpty()) {
            throw new Exception("El nombre del producto no puede estar vacío");
        }
        return productoRepository.save(producto);
    }

    public Producto putProducto(Producto producto, Integer id) throws Exception {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("El producto con la id: " + id + " no existe");
        }

        if (producto.getNombreProducto() == null ||
                producto.getPrecioProducto() == null ||
                producto.getDescripcionProducto() == null ||
                producto.getStockProducto() == null) {
            throw new RuntimeException("El producto debe tener todos sus atributos");
        }
        Producto productoExistente = productoRepository.findById(id).get();

        productoExistente.setDescripcionProducto(producto.getDescripcionProducto());
        productoExistente.setNombreProducto(producto.getNombreProducto());
        productoExistente.setPrecioProducto(producto.getPrecioProducto());
        productoExistente.setStockProducto(producto.getStockProducto());

        productoRepository.save(productoExistente);

        return productoExistente;

    }

    public Producto parcharProducto(Producto producto, Integer id) throws Exception {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("El producto con la id: " + id + " no existe");
        }
        if (producto.getNombreProducto() == null &&
                producto.getPrecioProducto() == null &&
                producto.getDescripcionProducto() == null &&
                producto.getStockProducto() == null) {
            throw new RuntimeException("El body debe tener al menos un atributo");
        }

        Producto productoExistente = productoRepository.findById(id).get();

        if (producto.getNombreProducto() != null) {
            productoExistente.setNombreProducto(producto.getNombreProducto());
        }
        if (producto.getPrecioProducto() != null) {
            productoExistente.setPrecioProducto(producto.getPrecioProducto());
        }
        if (producto.getDescripcionProducto() != null) {
            productoExistente.setDescripcionProducto(producto.getDescripcionProducto());
        }
        if (producto.getStockProducto() != null) {
            productoExistente.setStockProducto(producto.getStockProducto());
        }

        productoRepository.save(productoExistente);
        return productoExistente;
    }

    public void borrarProducto(Integer id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser vacio");
        }

        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("El producto con la id: " + id + " no existe");
        }

        productoRepository.deleteById(id);
    }
}
