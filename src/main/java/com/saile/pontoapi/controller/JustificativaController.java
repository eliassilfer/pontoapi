package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Justificativa;
import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.service.JustificativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class JustificativaController {
    private final JustificativaService justificativaService;

    @GetMapping("/api/v1/justificativas/{id}")
    public Mono<Justificativa> buscarPorUsuario(@PathVariable String id) {
        return justificativaService.porUsuario(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/justificativas")
    public Mono<Justificativa> salvar(@RequestBody Justificativa justificativa) {
        return justificativaService.salvar(justificativa);
    }

    @PutMapping("/api/v1/justificativas")
    public Mono<Justificativa> alterar(@RequestBody Justificativa justificativa) {
        return justificativaService.alterar(justificativa);
    }
}
