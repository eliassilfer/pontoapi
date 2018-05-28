package com.saile.pontoapi.controller;

import com.saile.pontoapi.domain.Usuario;
import com.saile.pontoapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/api/v1/usuarios/{email}/{senha}")
    public Mono<Usuario> buscarUsuario(@PathVariable String email, @PathVariable String senha) {
        return usuarioService.buscarUsuario(email, senha);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/usuarios")
    public Mono<Usuario> salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }
}
