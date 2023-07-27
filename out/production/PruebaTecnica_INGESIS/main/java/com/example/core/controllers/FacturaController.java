package com.example.core.controllers;

import com.example.core.dtos.ResponseDTO;
import com.example.core.entities.Facturas;
import com.example.core.projections.FacturaProjections;
import com.example.core.projections.FacturasProjections;
import com.example.core.services.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturasService facturasService;

    @PostMapping()
    public ResponseEntity<ResponseDTO> guardarFactura(@RequestBody Facturas factura){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Facturas facturaCreada = facturasService.guardarFactura(factura);
            responseDTO.setFactura(factura);
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }

    @PatchMapping(path = "/{idFactura}")
    public ResponseEntity<ResponseDTO> eliminarFactura(@PathVariable("idFactura") String idFactura){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Facturas factura = facturasService.eliminarFactura(Integer.parseInt(idFactura));
            responseDTO.setResponse("ok");
            responseDTO.setFactura(factura);
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> obtenerFacturas(){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<FacturasProjections> facturas = facturasService.obtenerFacturas();
            responseDTO.setResponse("ok");
            responseDTO.setFacturasList(facturas);
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }

    @GetMapping(path = "/{idFactura}")
    public ResponseEntity<ResponseDTO> obtenerFactura(@PathVariable("idFactura") String idFactura){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            FacturaProjections factura = facturasService.obtenerFactura(Integer.parseInt(idFactura));
            responseDTO.setResponse("ok");
            responseDTO.setFacturaProjection(factura);
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }
}
