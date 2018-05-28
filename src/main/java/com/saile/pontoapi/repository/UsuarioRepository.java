package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
    Mono<Usuario> findByEmailAndSenha(String email, String senha);
}
