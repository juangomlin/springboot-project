package com.sena3.clase3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena3.clase3.models.Product;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Product, Integer>{
  List<Product> findByCategory(String category);

}
