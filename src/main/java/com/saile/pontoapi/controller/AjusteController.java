package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Ajuste;
import com.saile.pontoapi.service.AjusteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AjusteController {
    private final AjusteService ajusteService;

    @GetMapping("/api/v1/ajustes/{id}")
    public Mono<ResponseEntity<Ajuste>> buscarPorUsuario(@PathVariable String id) {
        return ajusteService.porUsuario(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/ajustes")
    public Mono<Ajuste> salvar(@Valid @RequestBody Ajuste ajuste) {
        return ajusteService.salvar(ajuste);
    }

    @PutMapping("/api/v1/ajustes")
    public Mono<ResponseEntity<Ajuste>> alterar(@RequestBody Ajuste ajuste) {
        return ajusteService.alterar(ajuste)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
