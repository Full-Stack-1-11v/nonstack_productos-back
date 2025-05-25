package com.perfulandia.cl.Productos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"idCategoriaProducto", "nombreCategoria", "descripcionCategoria", "productos"}) // Raro que ocurra, pero esta anotacion ordena como arroja el json
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria_producto")
    private Integer IdCategoriaProducto;

    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoriaProducto" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> productos;
}
