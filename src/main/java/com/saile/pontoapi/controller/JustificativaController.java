package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Justificativa;
import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.service.JustificativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class JustificativaController {
    private final JustificativaService justificativaService;

    @GetMapping("/api/v1/justificativas/{id}")
    public Mono<ResponseEntity<Justificativa>> buscarPorUsuario(@PathVariable String id) {
        return justificativaService.porUsuario(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/justificativas")
    public Mono<Justificativa> salvar(@Valid @RequestBody Justificativa justificativa) {
        return justificativaService.salvar(justificativa);
    }

    @PutMapping("/api/v1/justificativas")
    public Mono<ResponseEntity<Justificativa>> alterar(@RequestBody Justificativa justificativa) {
        return justificativaService.alterar(justificativa)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
