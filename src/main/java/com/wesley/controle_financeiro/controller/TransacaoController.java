package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/{email}")
    public List<Transacao> findByUsuarioEmail(@PathVariable String email) {
        return transacaoService.findByUsuarioEmail(email);
    }

    @PostMapping("/{email}")
    public Transacao createTransacao(@RequestBody Transacao transacao, @PathVariable String email) {
        return transacaoService.createTransacao(transacao, email);
    }

    @PutMapping("/{id}/{email}")
    public Transacao updateTransacao(@PathVariable Long id, @RequestBody Transacao transacao, @PathVariable String email) {
        return transacaoService.updateTransacao(id, transacao, email);
    }

    @DeleteMapping("/{id}/{email}")
    public void deleteTransacao(@PathVariable Long id, @PathVariable String email) {
        transacaoService.deleteTransacao(id, email);
    }
}
