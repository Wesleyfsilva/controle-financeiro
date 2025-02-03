package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
=======
import java.security.Principal;

@RestController
@RequestMapping("/usuario")
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

<<<<<<< HEAD
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
=======
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
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
    }
}
