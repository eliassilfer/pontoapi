package com.saile.pontoapi.service;

import com.saile.pontoapi.domain.Ajuste;
import com.saile.pontoapi.repository.AjusteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AjusteService {
    private final AjusteRepository ajusteRepository;

    public Flux<Ajuste> all() {
        return ajusteRepository.findAll();
    }

    public Mono<Ajuste> byId(String id) {
        return ajusteRepository.findById(id);
    }

    public Mono<Ajuste> save(Ajuste ajuste) {
        return ajusteRepository.save(ajuste);
    }

    public Mono<Ajuste> update(Ajuste ajuste) {
        return ajusteRepository.save(ajuste);
    }
}
