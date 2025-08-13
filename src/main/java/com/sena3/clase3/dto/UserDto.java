package com.sena3.clase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
  private Integer id_usuario;
  private String nombre;
  private String apellido;
  private String ciudad;
}
