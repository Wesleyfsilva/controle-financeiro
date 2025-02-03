package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.model.Usuario;
<<<<<<< HEAD
import com.wesley.controle_financeiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByUsuario(Usuario usuario);
    List<Transacao> findByCategoria(Categoria categoria);
=======
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByUsuario(Usuario usuario);
    Optional<Transacao> findByIdAndUsuario(Long id, Usuario usuario);
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
}
