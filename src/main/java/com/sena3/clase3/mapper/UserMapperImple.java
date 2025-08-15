package com.sena3.clase3.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.models.User;

@Component
public class UserMapperImple implements UserMapper{
  @Override
  public User consultUser(UserDto userDto) {
    if (userDto == null) {
      return null;
    }
    User user = new User();
    user.setId_usuario(userDto.getId());
    user.setNombre(userDto.getNom());
    user.setApellido(userDto.getApe());
    user.setCiudad(userDto.getCiu());
    return user;
  }

  @Override
  public UserDto consultDto(User user){
    if (user == null) {
      return null;
    }
    UserDto userDto = new UserDto();
    userDto.setId(user.getId_usuario());
    userDto.setNom(user.getNombre());
    userDto.setApe(user.getApellido());
    userDto.setCiu(user.getCiudad());
    return userDto;
  }

  @Override
  public List<UserDto> ListDto(List<User> users)
  {
    if (users == null) {
      return List.of();
    }
    List<UserDto> usersDto = new ArrayList<UserDto>(users.size());
    for (User user : users) {
      usersDto.add(consultDto(user));
    }
    return usersDto;
  }

  @Override
  public void updateUser(User user, UserDto userDto) {
    if (userDto == null){
      return;
    }
    user.setNombre(userDto.getNom());
    user.setApellido(userDto.getApe());
    user.setCiudad(userDto.getCiu());
  }
}
