package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Justificativa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface JustificativaRepository extends ReactiveMongoRepository<Justificativa, String> {
}
