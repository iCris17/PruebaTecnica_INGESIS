package com.example.core.services;

import com.example.core.entities.Productos;
import com.example.core.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService {

    @Autowired//Esto quita la necesidad de instanciar el repositorio, Spring ya sabe cuál es la que se instancia
    private ProductosRepository productosRepository;

    public List<Productos> guardarProductos(ArrayList<Productos> productos) {
        List<Productos> productosGuardados = new ArrayList<>();
        for (Productos producto : productos) {
            productosGuardados.add(productosRepository.save(producto));
        }
        return productosGuardados;
    }
}
