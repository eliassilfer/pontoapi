package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Ajuste;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AjusteRepository extends ReactiveMongoRepository<Ajuste, String> {
    Mono<Ajuste> findByUsuarioId(String id);
}
