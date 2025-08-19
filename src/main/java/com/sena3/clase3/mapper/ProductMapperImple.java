package com.sena3.clase3.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sena3.clase3.dto.ProductDto;
import com.sena3.clase3.models.Product;

@Component
public class ProductMapperImple implements ProductMapper{

  @Override
  public Product consulProduct(ProductDto productDto){
    if (productDto == null){
      return null;
    }
    Product product = new Product();
    product.setId_product(productDto.getId());
    product.setCategory(productDto.getCatePro());
    product.setName(productDto.getNomPro());
    product.setPrice(productDto.getPreciPro());
    return product;
  }

  @Override
  public ProductDto consulProductDto(Product product){
    if ( product == null) {
      return null;
    }
    ProductDto productDto = new ProductDto();
    productDto.setId(product.getId_product());
    productDto.setCatePro(product.getCategory());
    productDto.setNomPro(product.getName());
    productDto.setPreciPro(product.getPrice());
    return productDto;
  }

  @Override
  public List<ProductDto> consulProductDtoList(List<Product> product) {
    if (product == null) {
      return null;
    }
    List<ProductDto> productDto = new ArrayList<ProductDto>(product.size());
    for (Product products : product) {
      productDto.add(consulProductDto(products));
    }
    return productDto;
  }
  @Override
  public void updateProduct(Product product, ProductDto productDto) {
    if (productDto == null) {
      return;
    }
    product.setCategory(productDto.getCatePro());
    product.setName(productDto.getNomPro());
    product.setPrice(productDto.getPreciPro());
  }
}
