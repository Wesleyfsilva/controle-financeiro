package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByUsuario(Usuario usuario);
    List<Transacao> findByCategoria(Categoria categoria);
}
