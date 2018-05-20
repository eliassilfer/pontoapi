package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Ajuste;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AjusteRepository extends ReactiveMongoRepository<Ajuste, String> {
}
