package com.example.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_clientes", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClientes;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nit")
    private String nit;

}
