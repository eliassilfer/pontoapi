package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Marcacao;
import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.service.MarcacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MarcacaoController {
    private final MarcacaoService marcacaoService;

    @GetMapping("/api/v1/marcacoes/{inicio}/{fim}/usuarios/{id}")
    public Mono<ResponseEntity<List<Marcacao>>> buscarPorPeriodo(@PathVariable String inicio,
                                                                 @PathVariable String fim,
                                                                 @PathVariable String id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime dataInicio = LocalDateTime.of(LocalDate.parse(inicio, formatter), LocalDateTime.MIN.toLocalTime());
        LocalDateTime dataFim = LocalDateTime.of(LocalDate.parse(fim, formatter), LocalDateTime.MAX.toLocalTime());
        Usuario usuario = Usuario.builder().id(id).build();
        return marcacaoService.porPeriodo(dataInicio, dataFim, usuario)
                .collectList()
                .filter(marcacaos -> !marcacaos.isEmpty())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/marcacoes")
    public Mono<Marcacao> salvar(@RequestBody Marcacao marcacao) {
        return marcacaoService.salvar(marcacao);
    }

    @PutMapping("/api/v1/marcacoes")
    public Mono<ResponseEntity<Marcacao>> alterar(@RequestBody Marcacao marcacao) {
        return marcacaoService.alterar(marcacao)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/api/v1/marcacoes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Marcacao> buscaTodas() {
        return marcacaoService.buscaTodas();
    }
}
