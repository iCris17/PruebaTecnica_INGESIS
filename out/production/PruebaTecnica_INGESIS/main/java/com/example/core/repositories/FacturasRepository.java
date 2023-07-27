package com.example.core.repositories;

import com.example.core.entities.Facturas;
import com.example.core.projections.FacturaProjections;
import com.example.core.projections.FacturasProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturasRepository extends JpaRepository<Facturas, Integer>, JpaSpecificationExecutor<Facturas> {
    @Query("select f.idFactura as idFactura, f.fecha as fecha, f.total as total, c.nombre as nombreCliente, f.eliminada as eliminada" +
            " from Facturas f inner join Clientes c on f.clientesIdClientes" +
            " = c.idClientes where f.eliminada = 0")
    List<FacturasProjections> obtenerFacturas();

    @Query("select f.idFactura as idFactura, f.fecha as fecha, f.total as total, c.nombre as nombreCliente, c.nit as nitCliente " +
            "from Facturas f inner join Clientes c on f.clientesIdClientes" +
            " = c.idClientes where f.idFactura = :idFactura")
    FacturaProjections obtenerFactura(@Param("idFactura") Integer idFactura);
}