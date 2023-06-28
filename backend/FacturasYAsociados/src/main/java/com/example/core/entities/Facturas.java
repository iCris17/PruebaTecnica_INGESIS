package com.example.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "facturas")
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_factura", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "total", nullable = false)
    private Float total;
    @Column(name = "eliminada", nullable = false)
    private Integer eliminada;
    @Column(name = "clientes_id_clientes", nullable = false)
    private Integer clientesIdClientes;

}
