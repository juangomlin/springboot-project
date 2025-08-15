package com.sena3.clase3.services;

import java.util.List;


import com.sena3.clase3.dto.UserDto;


public interface UserServices {

  public UserDto getUser(Integer userId);
  public UserDto saveUser(UserDto usuarioDto);
  public List<UserDto> getUsers();
  public UserDto deleteUser(Integer id);
  public UserDto updateUser(Integer id, UserDto userDto);
}
