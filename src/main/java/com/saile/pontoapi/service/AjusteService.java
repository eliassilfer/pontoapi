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

    public Mono<Ajuste> porUsuario(String id) {
        return ajusteRepository.findByUsuarioId(id);
    }

    public Mono<Ajuste> salvar(Ajuste ajuste) {
        return ajusteRepository.save(ajuste);
    }

    public Mono<Ajuste> alterar(Ajuste ajuste) {
        return ajusteRepository.existsById(ajuste.getId())
            .flatMap(exists -> ajusteRepository.save(ajuste));
    }
}
