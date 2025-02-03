package com.wesley.controle_financeiro.controller;

import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.security.Principal;
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

<<<<<<< HEAD
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
=======
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
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
    }
}
