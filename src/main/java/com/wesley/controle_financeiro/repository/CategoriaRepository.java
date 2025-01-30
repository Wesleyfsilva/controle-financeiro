package com.wesley.controle_financeiro.repository;

import com.wesley.controle_financeiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNomeContaining(String nome);
}
