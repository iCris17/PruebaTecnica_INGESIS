package com.example.core.projections;

import java.util.Date;

public interface FacturaProjections {
    Integer getIdFactura();
    Date getFecha();
    Float getTotal();
    String getNombreCliente();
    String getNitCliente();
}
