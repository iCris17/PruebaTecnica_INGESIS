package com.example.core.dtos;

import com.example.core.entities.Clientes;
import com.example.core.entities.DetalleFactura;
import com.example.core.entities.Facturas;
import com.example.core.entities.Productos;
import com.example.core.projections.DetallesFacturaProjection;
import com.example.core.projections.FacturaProjections;
import com.example.core.projections.FacturasProjections;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String response;
    private List<FacturasProjections> facturasList;
    private FacturaProjections facturaProjection;
    private Facturas factura;
    private List<Clientes> clientes;
    private DetalleFactura detalleFactura;
    private List<DetalleFactura> detallesFactura;

    private List<DetallesFacturaProjection> detallesFacturaProjections;

    public List<DetallesFacturaProjection> getDetallesFacturaProjections() {
        return detallesFacturaProjections;
    }

    public void setDetallesFacturaProjections(List<DetallesFacturaProjection> detallesFacturaProjections) {
        this.detallesFacturaProjections = detallesFacturaProjections;
    }

    private Exception error;


    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    private List<Productos> productos;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<FacturasProjections> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<FacturasProjections> facturasList) {
        this.facturasList = facturasList;
    }

    public Facturas getFactura() {
        return factura;
    }

    public void setFactura(Facturas factura) {
        this.factura = factura;
    }

    public FacturaProjections getFacturaProjection() {
        return facturaProjection;
    }

    public void setFacturaProjection(FacturaProjections facturaProjection) {
        this.facturaProjection = facturaProjection;
    }
}
