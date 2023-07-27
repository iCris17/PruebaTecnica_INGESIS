package com.example.core.projections;

import java.util.Date;

public interface FacturasProjections {
    Integer getIdFactura();
    Date getFecha();
    Float getTotal();
    String getNombreCliente();
    Short getEliminada();
}
