package com.example.core.controllers;

import com.example.core.dtos.ResponseDTO;
import com.example.core.entities.Clientes;
import com.example.core.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;
    @PostMapping()
    public ResponseEntity<ResponseDTO> guardarClientes(@RequestBody ArrayList<Clientes> clientes ){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<Clientes> clientesGuardados = clientesService.guardarClientes(clientes);
            responseDTO.setResponse("ok");
            responseDTO.setClientes(clientesGuardados);
            return ResponseEntity.ok(responseDTO);
        }
        catch (Exception e){
            responseDTO.setResponse("ko");
            responseDTO.setError(e);
            return ResponseEntity.ok(responseDTO);
        }
    }
}
