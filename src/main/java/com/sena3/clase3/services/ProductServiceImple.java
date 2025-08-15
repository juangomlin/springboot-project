package com.sena3.clase3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena3.clase3.dto.ProductDto;
import com.sena3.clase3.mapper.ProductMapper;
import com.sena3.clase3.models.Product;
import com.sena3.clase3.repositories.ProductoRepository;

@Service
public class ProductServiceImple implements ProductService{
  @Autowired
  private ProductoRepository productRepo;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public ProductDto getProduct(Integer id_product){
    Product product = productRepo.findById(id_product).get();
    return productMapper.consulProductDto(product);
  }

  @Override
  public ProductDto saveProduct(ProductDto productDto){
    Product product = productMapper.consulProduct(productDto);
    return productMapper.consulProductDto(productRepo.save(product));
  }


}
