package com.saile.pontoapi.repository;

import com.saile.pontoapi.domain.Marcacao;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface MarcacaoRepository extends ReactiveMongoRepository<Marcacao, String> {
    Flux<Marcacao> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
