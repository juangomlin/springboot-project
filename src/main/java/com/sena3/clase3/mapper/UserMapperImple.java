package com.sena3.clase3.mapper;

import org.springframework.stereotype.Component;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.models.Usuario;

@Component
public class UserMapperImple implements UserMapper{
  @Override
  public Usuario consultUser(UserDto userDto) {
    if (userDto == null) {
      return null;
    }

    Usuario user = new Usuario();
    user.setId_usuario(userDto.getId_usuario());
    user.setNombre(userDto.getNombre());
    user.setApellido(userDto.getApellido());
    user.setCiudad(userDto.getCiudad());
    return user;
  }

  @Override
  public UserDto consultDto(Usuario user){
    if (user == null) {
      return null;
    }

    UserDto userDto = new UserDto();
    userDto.setId_usuario(user.getId_usuario());
    userDto.setNombre(user.getNombre());
    userDto.setApellido(user.getApellido());
    userDto.setCiudad(user.getCiudad());
    return userDto;
  }

}
