package com.example.core.projections;

public interface DetallesFacturaProjection {
    Short getCantidad();
    String getNombreProducto();
    Float getPrecio();
    Float getTotalDetalle();
}