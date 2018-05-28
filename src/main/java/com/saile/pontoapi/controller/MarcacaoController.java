package com.saile.pontoapi.controller;

import com.saile.pontoapi.service.MarcacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MarcacaoController {
    private final MarcacaoService marcacaoService;
}
