package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.service.MarcacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class MarcacaoController {
    private final MarcacaoService marcacaoService;

    @GetMapping("/api/v1/marcacoes/{inicio}/{fim}")
    public Flux<Marcacao> buscarPorPeriodo(@PathVariable String inicio, @PathVariable String fim) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime dataInicio = LocalDateTime.of(LocalDate.parse(inicio, formatter), LocalDateTime.MIN.toLocalTime());
        LocalDateTime dataFim = LocalDateTime.of(LocalDate.parse(fim, formatter), LocalDateTime.MAX.toLocalTime());
        return marcacaoService.porPeriodo(dataInicio, dataFim);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/marcacoes")
    public Mono<Marcacao> salvar(@RequestBody Marcacao marcacao) {
        marcacao.setDataHora(LocalDateTime.now());
        return marcacaoService.salvar(marcacao);
    }

    @PutMapping("/api/v1/marcacoes")
    public Mono<Marcacao> alterar(@RequestBody Marcacao marcacao) {
        return marcacaoService.alterar(marcacao);
    }
}
