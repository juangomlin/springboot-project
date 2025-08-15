package com.sena3.clase3.mapper;

import java.util.List;
import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.models.User;

public interface UserMapper {
  User consultUser(UserDto userDto);

  UserDto consultDto(User user);

  List<UserDto> ListDto(List<User> users);

  void updateUser(User user, UserDto userDto);
}
