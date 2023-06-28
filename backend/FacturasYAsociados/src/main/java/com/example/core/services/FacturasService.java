package com.example.core.services;

import com.example.core.entities.Facturas;
import com.example.core.projections.FacturaProjections;
import com.example.core.projections.FacturasProjections;
import com.example.core.repositories.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasService {

    @Autowired
    FacturasRepository facturasRepository;

    public Facturas guardarFactura(Facturas factura){
        return facturasRepository.save(factura);
    }

    public Facturas eliminarFactura(Integer id){
        Optional<Facturas> facturaAEliminar = facturasRepository.findById(id);
        Facturas facturaCasteada = facturaAEliminar.get();
        facturaCasteada.setEliminada(1);
        return facturasRepository.save(facturaCasteada);
    }

    public List<FacturasProjections> obtenerFacturas(){
        return facturasRepository.obtenerFacturas();
    }

    public FacturaProjections obtenerFactura(Integer id) { return facturasRepository.obtenerFactura(id);}
}
