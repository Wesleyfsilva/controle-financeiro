package com.wesley.controle_financeiro.service;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        logger.info("Procurando usuário: {}", nomeUsuario);

        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + nomeUsuario));

        logger.info("Usuário encontrado: {}", usuario.getNomeUsuario());

        return User.builder()
                .username(usuario.getNomeUsuario())
                .password(usuario.getSenha()) // Senha criptografada
                .roles("USER")
                .build();
    }
}
