package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Marcacao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MarcacaoRepository extends ReactiveMongoRepository<Marcacao, String> {
}
