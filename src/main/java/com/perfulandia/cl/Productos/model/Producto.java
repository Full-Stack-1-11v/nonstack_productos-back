package com.perfulandia.cl.Productos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer productoId;

    @Column(name = "nombre_producto" , length = 50)
    private String nombreProducto;

    @Column(name = "descripcion_producto" , length = 200)
    private String descripcionProducto;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @Column(name = "id_categoria_producto")
    private Integer idCategoriaProducto;

    @Column(name = "stock_producto")
    private Integer stockProducto;

}
