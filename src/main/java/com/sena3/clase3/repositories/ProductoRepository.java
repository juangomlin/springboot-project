package com.sena3.clase3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena3.clase3.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
