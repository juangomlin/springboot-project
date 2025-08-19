package com.sena3.clase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena3.clase3.dto.UserDto;
import com.sena3.clase3.models.User;
import com.sena3.clase3.repositories.UsuarioRepository;
import com.sena3.clase3.services.UserServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {


  @Autowired
  private UsuarioRepository userRepo;

  @GetMapping("/userConect")
    public String buscarUsuario() {
      return "conectando desde usuario ";
  }

  @GetMapping("/userList")
    public String listaUser() {
      return userRepo.findAll().toString();
    }
    @GetMapping("/userJson")
    public List<User> jsonUser() {
        return userRepo.findAll();
    }
    
    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String eliminUsuario(@PathVariable Integer id){
      userRepo.deleteById(id);
      return "User deleted";
    }
    @PutMapping("userupdate/{id}")
    public String userUpdate(@PathVariable String id, @RequestBody User user) {
      User userup = userRepo.findById(Integer.parseInt(id)).orElse(null);
      if(userup == null){
        return "user not found";
      }
      userup.setNombre(user.getNombre());
      userup.setApellido(user.getApellido());
      userup.setCiudad(user.getCiudad());
      userRepo.save(userup);

        return "user updated";
    }
    
    // metodos de arquitectura por capas
    @Autowired
    private UserServices userServ;

    @GetMapping("/userServ/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userServ.getUser(id),
        HttpStatus.OK);
    }

    @PostMapping("/createUserDto")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userServ.saveUser(userDto), HttpStatus.CREATED);
    }

    // Lista de usuarios

    @GetMapping("/userListDto")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userServ.getUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity<UserDto> deleteUser (@PathVariable Integer id) {
      return new ResponseEntity<>(userServ.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("/UserUpdate/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto ){
      return new ResponseEntity<>(userServ.updateUser(id, userDto), HttpStatus.OK);
    }
        
}
