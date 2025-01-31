package com.wesley.controle_financeiro.service;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServer implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + nomeUsuario));

        return User.builder()
                .username(usuario.getNomeUsuario())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }
}
