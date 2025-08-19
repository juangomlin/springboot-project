package com.sena3.clase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena3.clase3.dto.ProductDto;
import com.sena3.clase3.models.Product;
import com.sena3.clase3.repositories.ProductoRepository;
import com.sena3.clase3.services.ProductService;

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
    return productRepo.findAll().toString();
  }
  
  @GetMapping("/productJson")
  public List<Product> getProductJson() {
      return productRepo.findAll();
  }

  @PostMapping("/createProduct")
  public Product postMethodName(@RequestBody Product product) {
      return productRepo.save(product);
  }
  
  @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
      productRepo.deleteById(id);
      return "product deleted";
    }
  
  @PutMapping("updateProduct/{id}")
  public String putMethodName(@PathVariable String id, @RequestBody Product product) {
      Product productP = productRepo.findById(Integer.parseInt(id)).orElse(null);
      if (productP == null) {
        return "Product not found";
      }
      productP.setCategory(product.getCategory());
      productP.setName(product.getName());
      productP.setPrice(product.getPrice());
      productRepo.save(productP);

      return "product updated";
  }

  // Arquitectura por capas

  @Autowired
  public ProductService productServ;

  @GetMapping("/FindProduct/{id}")
  public ResponseEntity<ProductDto> getProduct(@PathVariable Integer id) {
      return new ResponseEntity<>(productServ.getProduct(id), HttpStatus.OK);
  }
  @PostMapping("/CreateProduct")
  public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
    return new ResponseEntity<>(productServ.saveProduct(productDto),HttpStatus.OK);
  }
  @GetMapping("/ListProducts")
  public ResponseEntity <List<ProductDto>> getProducts() {
      return new ResponseEntity<>(productServ.getProducts(), HttpStatus.OK);
  }
  
  @PutMapping("/UpdateProduct/{id}")
  public ResponseEntity<ProductDto> updateProductDto(@PathVariable Integer id, @RequestBody ProductDto productDto) {
  return new ResponseEntity<>(productServ.updateProduct(id, productDto), HttpStatus.OK);
  }


}
