package com.saile.pontoapi.service;

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

    public Mono<Justificativa> porUsuario(String id) {
        return justificativaRepository.findByUsuarioId(id);
    }

    public Mono<Justificativa> salvar(Justificativa justificativa) {
        return justificativaRepository.save(justificativa);
    }

    public Mono<Justificativa> alterar(Justificativa justificativa) {
        return justificativaRepository.existsById(justificativa.getId())
                .flatMap(exists -> justificativaRepository.save(justificativa));
    }
}
