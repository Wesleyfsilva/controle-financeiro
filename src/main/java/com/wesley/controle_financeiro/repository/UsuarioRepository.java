package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
<<<<<<< HEAD
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
=======
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
    Optional<Usuario> findByEmail(String email); // Se necessário
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
}
