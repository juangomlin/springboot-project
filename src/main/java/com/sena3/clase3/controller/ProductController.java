package com.sena3.clase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena3.clase3.models.Usuario;
import com.sena3.clase3.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
  @Autowired
  private ProductoRepository productRepo;

  @GetMapping("/productConnect")
  public String productConnect() {
      return new String("connected from product");
  }
  
  @GetMapping("/productList")
  public String getProductList() {
    
  }
  

}
