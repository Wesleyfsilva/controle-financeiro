package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.Map;

>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
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

<<<<<<< HEAD
    @PostMapping("/loginSuccess")
    public String loginSuccess() {
        return "Autenticação bem-sucedida";
    }

    @PostMapping("/loginFailure")
    public String loginFailure() {
        return "Falha na autenticação";
=======
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        // Autenticação será lidada pelo CustomAuthenticationFilter
        return "Attempting authentication";
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
    }
}
