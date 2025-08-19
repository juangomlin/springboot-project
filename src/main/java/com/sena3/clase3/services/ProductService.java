package com.sena3.clase3.services;

import java.util.List;

import com.sena3.clase3.dto.ProductDto;

public interface ProductService {
  public ProductDto getProduct(Integer id_product);
  public ProductDto saveProduct(ProductDto productDto);
  public List<ProductDto> getProducts();
  public ProductDto updateProduct(Integer id, ProductDto productDto);
}
