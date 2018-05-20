package com.saile.pontoapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Justificativa {
    @Id
    private String id;
    private String usuarioId;
    private String responsavelId;
    private String descricao;
    private LocalDateTime dataHora;
}
