package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Usuario getAuthenticatedUsuario(Principal principal) {
        return usuarioService.findByEmail(principal.getName());
    }

    @PutMapping
    public Usuario updateAuthenticatedUsuario(@RequestBody Usuario usuarioDetails, Principal principal) {
        return usuarioService.updateUsuario(usuarioDetails, principal.getName());
    }

    @DeleteMapping
    public void deleteAuthenticatedUsuario(Principal principal) {
        usuarioService.deleteUsuario(principal.getName());
    }
}
