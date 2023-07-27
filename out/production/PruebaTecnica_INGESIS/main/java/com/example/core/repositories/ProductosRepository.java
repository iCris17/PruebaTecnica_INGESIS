package com.example.core.repositories;

import com.example.core.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>, JpaSpecificationExecutor<Productos> {

}