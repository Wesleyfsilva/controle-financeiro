package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
    Optional<Usuario> findByEmail(String email); // Se necessário
}
