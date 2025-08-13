package com.sena3.clase3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.mapper.UserMapper;
import com.sena3.clase3.models.Usuario;
import com.sena3.clase3.repositories.UsuarioRepository;

@Service
public class UserServicesImple implements UserServices{
  
  @Autowired
  private UsuarioRepository userRepo;
  private UserMapper usermapper;

  @Override
  public UserDto getUser(Integer userId) {
    Usuario usuario = userRepo.findById(userId).get();
    return usermapper.consultDto(usuario);
  }
}




















