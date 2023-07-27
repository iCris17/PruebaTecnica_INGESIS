package com.example.core.repositories;

import com.example.core.entities.DetalleFactura;
import com.example.core.projections.DetallesFacturaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer>, JpaSpecificationExecutor<DetalleFactura> {
    @Query("select df.cantidad as cantidad, p.nombreProducto as nombreProducto, p.precio as precio, df.totalDetalle as totalDetalle from DetalleFactura df inner join " +
            "Productos p on df.productosIdProductos = p.idProductos " +
            "inner join Facturas f on df.facturasIdFactura = f.idFactura where f.idFactura = :idFactura")
    List<DetallesFacturaProjection> obtenerDetalles(@Param("idFactura") Integer factura);
}