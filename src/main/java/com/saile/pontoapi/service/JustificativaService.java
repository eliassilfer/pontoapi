package com.saile.pontoapi.service;

import com.saile.pontoapi.domain.Ajuste;
import com.saile.pontoapi.domain.Justificativa;
import com.saile.pontoapi.repository.JustificativaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class JustificativaService {
    private final JustificativaRepository justificativaRepository;

    public Flux<Justificativa> all() {
        return justificativaRepository.findAll();
    }

    public Mono<Justificativa> byId(String id) {
        return justificativaRepository.findById(id);
    }

    public Mono<Justificativa> save(Justificativa justificativa) {
        return justificativaRepository.save(justificativa);
    }

    public Mono<Justificativa> update(Justificativa justificativa) {
        return justificativaRepository.save(justificativa);
    }
}
