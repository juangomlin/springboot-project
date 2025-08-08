package com.sena3.clase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena3.clase3.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

  @Autowired
  private UsuarioRepository userRepo;

  @GetMapping("/userConect")
    public String buscarUsuario() {
      return "conectando desde usuario ";
  }

  @GetMapping("/user")
    public String listaUsuario() {
      return userRepo.findAll().toString();
    }
}
