package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrar(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        // Autenticação será lidada pelo CustomAuthenticationFilter
        return "Attempting authentication";
    }
}
