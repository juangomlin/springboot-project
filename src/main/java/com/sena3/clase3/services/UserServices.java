package com.sena3.clase3.services;

import org.springframework.stereotype.Service;

import com.sena3.clase3.dto.UserDto;

@Service
public interface UserServices {

  public UserDto getUser(Integer userId);


}
