package com.sena3.clase3.mapper;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.models.Usuario;

public interface UserMapper {
  Usuario consultUser(UserDto userDto);

  UserDto consultDto(Usuario user);
}
