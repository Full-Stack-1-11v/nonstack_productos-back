package com.perfulandia.cl.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.cl.Productos.model.CategoriaProducto;
import com.perfulandia.cl.Productos.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaProductoService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaProducto> verCategorias() {
        return categoriaRepository.findAll();

    }

    public CategoriaProducto buscarCategoria(Integer id) throws Exception {
        if (categoriaRepository.existsById(id)) {
            return categoriaRepository.findById(id).get();
        } else {
            throw new RuntimeException("No existe la categoría con id: " + id);
        }
    }

    public CategoriaProducto crearCategoria(CategoriaProducto categoria) throws Exception {
        if (categoria.getNombreCategoria() == null || categoria.getNombreCategoria().isEmpty()) {
            throw new Exception("El nombre de la categoría no puede estar vacío");
        }
        return categoriaRepository.save(categoria);
    }

    

}
