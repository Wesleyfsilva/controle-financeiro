package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByUsuario(Usuario usuario);
    Optional<Transacao> findByIdAndUsuario(Long id, Usuario usuario);
}
