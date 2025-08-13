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
import com.sena3.clase3.models.Usuario;
import com.sena3.clase3.repositories.UsuarioRepository;
import com.sena3.clase3.services.UserServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UsuarioController {


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
    public List<Usuario> jsonUser() {
        return userRepo.findAll();
    }
    
    @PostMapping("/CreateUser")
    public Usuario createUser(@RequestBody Usuario usuario) {
        return userRepo.save(usuario);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String eliminUsuario(@PathVariable Integer id){
      userRepo.deleteById(id);
      return "User deleted";
    }
    @PutMapping("userupdate/{id}")
    public String userUpdate(@PathVariable String id, @RequestBody Usuario user) {
      Usuario userup = userRepo.findById(Integer.parseInt(id)).orElse(null);
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
    

}
