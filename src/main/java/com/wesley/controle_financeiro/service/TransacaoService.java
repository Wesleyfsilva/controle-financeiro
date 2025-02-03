package com.wesley.controle_financeiro.service;

<<<<<<< HEAD
import com.wesley.controle_financeiro.model.Transacao;
import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.repository.TransacaoRepository;
=======
import com.wesley.controle_financeiro.model.Usuario;
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
import com.wesley.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
<<<<<<< HEAD
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Transacao> findByUsuarioEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.map(value -> transacaoRepository.findByUsuario(value)).orElse(null);
    }

    public Transacao createTransacao(Transacao transacao, String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            transacao.setUsuario(usuario.get());
            return transacaoRepository.save(transacao);
        }
        return null;
    }

    public Transacao updateTransacao(Long id, Transacao transacao, String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            transacao.setUsuario(usuario.get());
            return transacaoRepository.save(transacao);
        }
        return null;
    }

    public void deleteTransacao(Long id, String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            Optional<Transacao> transacao = transacaoRepository.findById(id);
            transacao.ifPresent(value -> {
                if (value.getUsuario().equals(usuario.get())) {
                    transacaoRepository.delete(value);
                }
            });
        }
=======
    private UsuarioRepository usuarioRepository;

    public void metodoExemplo(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + email));

        // Lógica adicional aqui
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
    }
}
