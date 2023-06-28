package com.example.core.services;

import com.example.core.entities.Clientes;
import com.example.core.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    public List<Clientes> guardarClientes(ArrayList<Clientes> clientes){
        List<Clientes> clientesGuardados = new ArrayList<>();
        for (Clientes cliente: clientes) {
            clientesGuardados.add(clientesRepository.save(cliente));
        }
        return clientesGuardados;
    }
}
