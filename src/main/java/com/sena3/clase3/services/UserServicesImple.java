package com.sena3.clase3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.mapper.UserMapper;
import com.sena3.clase3.models.User;
import com.sena3.clase3.repositories.UsuarioRepository;

@Service
public class UserServicesImple implements UserServices{
  
  @Autowired
  private UsuarioRepository userRepo;
  @Autowired
  private UserMapper usermapper;

 @Override
  public UserDto getUser(Integer userId) {
    User usuario = userRepo.findById(userId).get();
    return usermapper.consultDto(usuario);
  }

  @Override
  public UserDto saveUser(UserDto userDto){
    User user = usermapper.consultUser(userDto);
  return usermapper.consultDto(userRepo.save(user));
  }

  @Override
  public List<UserDto> getUsers(){
    List<User> users = userRepo.findAll();
    return usermapper.ListDto(users);
  }

  @Override
  public UserDto deleteUser(Integer id) {
    User users = userRepo.findById(id).get();
    userRepo.delete(users);
    return usermapper.consultDto(users);
  }
}




















