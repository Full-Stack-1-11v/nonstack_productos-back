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

    public CategoriaProducto putCategoria(CategoriaProducto categoria, Integer id) throws Exception {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("No existe esa categoria con esa id");
        }

        CategoriaProducto categoriaProductoExistente = categoriaRepository.findById(id).get();

        categoriaProductoExistente.setDescripcionCategoria(categoria.getDescripcionCategoria());
        categoriaProductoExistente.setNombreCategoria(categoria.getNombreCategoria());

        categoriaRepository.save(categoriaProductoExistente);
        return categoriaProductoExistente;

    }

    public CategoriaProducto parcharCategoria(CategoriaProducto categoria, Integer id) throws Exception {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("No existe esa categoria con esa id");
        }

        CategoriaProducto categoriaProductoExistente = categoriaRepository.findById(id).get();

        if (categoria.getDescripcionCategoria() == null &&
                categoria.getNombreCategoria() == null) {
            throw new RuntimeException("Debe tener al menos un atributo a parchar.");
        }

        if (categoria.getDescripcionCategoria() != null) {
            categoriaProductoExistente.setDescripcionCategoria(categoria.getDescripcionCategoria());
        }

        if (categoria.getNombreCategoria() != null) {
            categoriaProductoExistente.setNombreCategoria(categoria.getNombreCategoria());
        }

        categoriaRepository.save(categoriaProductoExistente);
        return categoriaProductoExistente;
    }

    public void borrarCategoria(Integer id) throws Exception{
        if (!categoriaRepository.existsById(id)) {
            throw new Exception("No existe esa categoria con esa id");
        }

        CategoriaProducto categoriaProductoExistente = categoriaRepository.findById(id).get();

        categoriaRepository.delete(categoriaProductoExistente);
    }

}
