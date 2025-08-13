package com.sena3.clase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena3.clase3.models.Producto;
import com.sena3.clase3.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


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
    return productRepo.findAll().toString();
  }
  
  @GetMapping("/productJson")
  public List<Producto> getProductJson() {
      return productRepo.findAll();
  }

  @PostMapping("/createProduct")
  public Producto postMethodName(@RequestBody Producto product) {
      return productRepo.save(product);
  }
  
  @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
      productRepo.deleteById(id);
      return "product deleted";
    }
  
  @PutMapping("updateProduct/{id}")
  public String putMethodName(@PathVariable String id, @RequestBody Producto product) {
      Producto productP = productRepo.findById(Integer.parseInt(id)).orElse(null);
      if (productP == null) {
        return "Product not found";
      }
      productP.setCategoria(product.getCategoria());
      productP.setNombre(product.getNombre());
      productP.setPrecio(product.getPrecio());
      productRepo.save(productP);

      return "product updated";
  }

}
