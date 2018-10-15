package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/api/v1/usuarios/{email}/{senha}")
    public Mono<ResponseEntity<Usuario>> buscarUsuario(@PathVariable String email, @PathVariable String senha) {
        return usuarioService.buscarUsuario(email, senha)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/usuarios")
    public Mono<Usuario> salvar(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/api/v1/usuarios")
    public Mono<ResponseEntity<Usuario>> alterar(@RequestBody Usuario usuario) {
        return usuarioService.alterar(usuario)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
