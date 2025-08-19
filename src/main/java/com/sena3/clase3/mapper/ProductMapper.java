package com.sena3.clase3.mapper;

import java.util.List;

import com.sena3.clase3.dto.ProductDto;
import com.sena3.clase3.models.Product;

public interface ProductMapper {
  Product consulProduct(ProductDto productDto);

  ProductDto consulProductDto(Product product);

  List<ProductDto> consulProductDtoList(List<Product> products);

  void updateProduct(Product product, ProductDto productDto);
}
