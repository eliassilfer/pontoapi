package com.saile.pontoapi.controller;

import com.saile.pontoapi.service.JustificativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JustificativaController {
    private final JustificativaService justificativaService;
}
