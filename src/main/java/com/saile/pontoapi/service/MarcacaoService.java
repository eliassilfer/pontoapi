package com.saile.pontoapi.service;

import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.repository.MarcacaoRepository;
import com.saile.pontoapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MarcacaoService {
    private final MarcacaoRepository marcacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public Flux<Marcacao> porPeriodo(LocalDateTime inicio, LocalDateTime fim, Usuario usuario) {
        return marcacaoRepository.findByDataHoraBetweenAndUsuario(inicio, fim, usuario);

    }

    public Mono<Marcacao> salvar(Marcacao marcacao) {
        return marcacaoRepository.save(marcacao);
    }

    public Mono<Marcacao> alterar(Marcacao marcacao) {
        return marcacaoRepository.existsById(marcacao.getId())
                .flatMap(exists -> marcacaoRepository.save(marcacao));
    }

    public Flux<Marcacao> buscaTodas() {
        return marcacaoRepository.findAll();
    }
}
