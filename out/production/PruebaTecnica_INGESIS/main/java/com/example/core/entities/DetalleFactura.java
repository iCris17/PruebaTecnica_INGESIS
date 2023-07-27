package com.example.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_factura", nullable = false)
    private Integer idDetalleFactura;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "total_detalle")
    private String totalDetalle;

    @Column(name = "facturas_id_factura", nullable = false)
    private Integer facturasIdFactura;

    @Column(name = "productos_id_productos", nullable = false)
    private Integer productosIdProductos;

}
