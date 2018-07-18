package com.saile.pontoapi.service;

import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.repository.MarcacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MarcacaoService {
    private final MarcacaoRepository marcacaoRepository;

    public Flux<Marcacao> porPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return marcacaoRepository.findByDataHoraBetween(inicio, fim);
    }

    public Mono<Marcacao> salvar(Marcacao marcacao) {
        return marcacaoRepository.save(marcacao);
    }

    public Mono<Marcacao> alterar(Marcacao marcacao) {
        return Mono.just(marcacaoRepository.existsById(marcacao.getId()))
                .flatMap(p -> marcacaoRepository.save(marcacao));
    }
}
