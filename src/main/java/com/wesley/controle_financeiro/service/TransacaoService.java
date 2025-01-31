package com.wesley.controle_financeiro.service;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void metodoExemplo(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + email));

        // Lógica adicional aqui
    }
}
