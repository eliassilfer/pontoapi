package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Justificativa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface JustificativaRepository extends ReactiveMongoRepository<Justificativa, String> {
    Mono<Justificativa> findByUsuarioId(String id);
}
