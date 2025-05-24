package com.perfulandia.cl.Productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.cl.Productos.model.Producto;
import com.perfulandia.cl.Productos.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<?> getProductos() {
        try {
            List<Producto> productos = productoService.verProductos();
            if (productos.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Integer id) {
        try {
            Producto producto = productoService.buscarProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
        try {
            Producto productoCreado = productoService.crearProducto(producto);
            return ResponseEntity.ok(productoCreado);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoPut = productoService.putProducto(producto, id);
            return ResponseEntity.ok(productoPut);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoPatch = productoService.putProducto(producto, id);
            return ResponseEntity.ok(productoPatch);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id){
        try {
            productoService.borrarProducto(id);
            return new ResponseEntity<>("Borrado",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
