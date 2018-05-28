package com.saile.pontoapi.controller;

import com.saile.pontoapi.service.AjusteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AjusteController {
    private final AjusteService ajusteService;
}
