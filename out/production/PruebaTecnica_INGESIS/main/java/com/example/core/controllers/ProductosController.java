package com.example.core.controllers;

import com.example.core.dtos.ResponseDTO;
import com.example.core.entities.Productos;
import com.example.core.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController //Indica a Spring que esta clase se encarga de actuar como controlador
@RequestMapping("/productos")//Indica en qué dirección se van a activar los métodos de esta clase
public class ProductosController {

    @Autowired
    ProductosService productosService;
    @PostMapping()
    public ResponseEntity<ResponseDTO> guardarProductos(@RequestBody ArrayList<Productos> productos){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<Productos> productosGuardados = productosService.guardarProductos(productos);
            responseDTO.setResponse("ok");
            responseDTO.setProductos(productosGuardados);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }
}
