package com.saile.pontoapi.service;

import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Mono<Usuario> buscarUsuario(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

    public Mono<Usuario> salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Mono<Usuario> alterar(Usuario usuario) {
        return usuarioRepository.existsById(usuario.getId())
                .flatMap(exists -> usuarioRepository.save(usuario));
    }
}
