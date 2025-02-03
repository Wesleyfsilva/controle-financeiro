package com.wesley.controle_financeiro.service;

import com.wesley.controle_financeiro.model.Usuario;
import com.wesley.controle_financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvarUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }
<<<<<<< HEAD

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario updateUsuario(Usuario usuario, String email) {
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            Usuario userToUpdate = existingUser.get();
            userToUpdate.setNomeUsuario(usuario.getNomeUsuario());
            userToUpdate.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(userToUpdate);
        }
        return null;
    }

    public void deleteUsuario(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        usuario.ifPresent(value -> usuarioRepository.delete(value));
    }
=======
>>>>>>> 3b57c15a35c711ff8b7486f73e514d70a3db5acc
}
