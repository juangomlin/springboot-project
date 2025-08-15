package com.sena3.clase3.services;

import com.sena3.clase3.dto.ProductDto;

public interface ProductService {
  public ProductDto getProduct(Integer id_product);

  public ProductDto saveProduct(ProductDto productDto);
}
