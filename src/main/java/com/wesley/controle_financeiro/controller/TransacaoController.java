package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> getAuthenticatedUsuarioTransacoes(Principal principal) {
        return transacaoService.findByUsuarioEmail(principal.getName());
    }

    @PostMapping
    public Transacao createTransacao(@RequestBody Transacao transacao, Principal principal) {
        return transacaoService.createTransacao(transacao, principal.getName());
    }

    @PutMapping("/{id}")
    public Transacao updateTransacao(@PathVariable Long id, @RequestBody Transacao transacaoDetails, Principal principal) {
        return transacaoService.updateTransacao(id, transacaoDetails, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteTransacao(@PathVariable Long id, Principal principal) {
        transacaoService.deleteTransacao(id, principal.getName());
    }
}
