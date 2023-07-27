package com.example.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_productos", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductos;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "precio", nullable = false)
    private Double precio;

}
