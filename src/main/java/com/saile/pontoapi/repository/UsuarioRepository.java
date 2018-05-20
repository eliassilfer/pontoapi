package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
}
