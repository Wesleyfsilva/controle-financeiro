package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{email}")
    public Optional<Usuario> findByEmail(@PathVariable String email) {
        return usuarioService.findByEmail(email);
    }

    @PutMapping("/{email}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable String email) {
        return usuarioService.updateUsuario(usuario, email);
    }

    @DeleteMapping("/{email}")
    public void deleteUsuario(@PathVariable String email) {
        usuarioService.deleteUsuario(email);
    }
}
