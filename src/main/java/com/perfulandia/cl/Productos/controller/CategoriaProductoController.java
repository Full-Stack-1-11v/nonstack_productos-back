package com.perfulandia.cl.Productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.cl.Productos.model.CategoriaProducto;
import com.perfulandia.cl.Productos.service.CategoriaProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






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

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Integer id) {
       try {
            CategoriaProducto categoriaProducto = categoriaProductoService.buscarCategoria(id);
            return ResponseEntity.ok(categoriaProducto);
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

    @PutMapping("/{id}")
    public ResponseEntity<?> putCategoriaProducto(@PathVariable Integer id, @RequestBody CategoriaProducto categoriaProducto) {
        try {
            CategoriaProducto catPut = categoriaProductoService.putCategoria(categoriaProducto, id);
            return ResponseEntity.ok(catPut);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchCategoriaProducto(@PathVariable Integer id, @RequestBody CategoriaProducto categoriaProducto){
        try {
            CategoriaProducto catPatch = categoriaProductoService.parcharCategoria(categoriaProducto, id);
            return ResponseEntity.ok(catPatch);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoriaProducto(@PathVariable Integer id){
        try {
            categoriaProductoService.borrarCategoria(id);
            return new ResponseEntity<>("Eliminado",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    } 
    
    
}
