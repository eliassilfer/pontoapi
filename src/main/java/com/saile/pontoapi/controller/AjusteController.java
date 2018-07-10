package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Ajuste;
import com.saile.pontoapi.service.AjusteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AjusteController {
    private final AjusteService ajusteService;

    @GetMapping("/api/v1/ajustes/{id}")
    public Mono<Ajuste> buscarPorUsuario(@PathVariable String id) {
        return ajusteService.porUsuario(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/ajustes")
    public Mono<Ajuste> salvar(@RequestBody Ajuste ajuste) {
        return ajusteService.salvar(ajuste);
    }

    @PutMapping("/api/v1/ajustes")
    public Mono<Ajuste> alterar(@RequestBody Ajuste ajuste) {
        return ajusteService.alterar(ajuste);
    }
}
