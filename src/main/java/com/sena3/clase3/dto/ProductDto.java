package com.sena3.clase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
  private Integer id;
  private String catePro;
  private String nomPro;
  private Integer preciPro;
}
