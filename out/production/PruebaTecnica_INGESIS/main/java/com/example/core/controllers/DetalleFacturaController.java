package com.example.core.controllers;

import com.example.core.dtos.ResponseDTO;
import com.example.core.entities.DetalleFactura;
import com.example.core.projections.DetallesFacturaProjection;
import com.example.core.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/detallefactura")
public class DetalleFacturaController {
    @Autowired
    DetalleFacturaService detalleFacturaService;

    @PostMapping()
    public ResponseEntity<ResponseDTO> guardarDetalleFactura(@RequestBody DetalleFactura detalleFactura){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            DetalleFactura detalleFacturaCreada = detalleFacturaService.crearDetalleFactura(detalleFactura);
            responseDTO.setResponse("ok");
            responseDTO.setDetalleFactura(detalleFacturaCreada);
            return ResponseEntity.ok(responseDTO);
        } catch(Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }

    @GetMapping(path= "/{idFactura}")
    public ResponseEntity<ResponseDTO> obtenerDetallesFactura(@PathVariable("idFactura") String idFactura){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<DetallesFacturaProjection> detallesFactura = detalleFacturaService.obtenerDetallesFactura(idFactura);
            responseDTO.setResponse("ok");
            responseDTO.setDetallesFacturaProjections(detallesFactura);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }
}
