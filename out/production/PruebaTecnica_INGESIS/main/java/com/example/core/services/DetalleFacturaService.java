package com.example.core.services;

import com.example.core.entities.DetalleFactura;
import com.example.core.projections.DetallesFacturaProjection;
import com.example.core.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaService {

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFactura crearDetalleFactura(DetalleFactura detalleFactura){
        return detalleFacturaRepository.save(detalleFactura);
    }

    public List<DetallesFacturaProjection> obtenerDetallesFactura(String facturaId){
        return detalleFacturaRepository.obtenerDetalles(Integer.parseInt(facturaId));
    }
}
