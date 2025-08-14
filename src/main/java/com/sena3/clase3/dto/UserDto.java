package com.sena3.clase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
  private Integer id;
  private String nom;
  private String ape;
  private String ciu;
}
