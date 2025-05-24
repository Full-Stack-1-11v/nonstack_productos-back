package com.perfulandia.cl.Productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.cl.Productos.model.CategoriaProducto;
import com.perfulandia.cl.Productos.service.CategoriaProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/productos/categorias")
public class CategoriaProductoController {

    @Autowired
    CategoriaProductoService categoriaProductoService;

    @GetMapping("")
    public ResponseEntity<?> getCategoriaProductos() {
        try {
            List<CategoriaProducto> categoriaProductos = categoriaProductoService.verCategorias();
            return ResponseEntity.ok(categoriaProductos);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createCategoriaProducto(@RequestBody CategoriaProducto nuevaCategoria) {
        try {
            CategoriaProducto catNueva = categoriaProductoService.crearCategoria(nuevaCategoria);
            return ResponseEntity.ok(catNueva);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        
       
    }
    
    
}
