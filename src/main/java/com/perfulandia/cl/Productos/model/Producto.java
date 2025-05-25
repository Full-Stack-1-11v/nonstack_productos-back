package com.perfulandia.cl.Productos.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre_producto" , length = 50)
    private String nombreProducto;

    @Column(name = "descripcion_producto" , length = 200)
    private String descripcionProducto;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @Column(name = "stock_producto")
    private Integer stockProducto;

    @ManyToOne
    @JoinColumn(name = "id_categoria_producto")
    @JsonBackReference
    private CategoriaProducto categoriaProducto;

}
