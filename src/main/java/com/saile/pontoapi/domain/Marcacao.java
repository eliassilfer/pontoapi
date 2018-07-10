package com.saile.pontoapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Marcacao {
    @Id
    private String id;
    @DBRef
    private Usuario usuario;
    private String tipo;
    private LocalDateTime dataHora;
    private String descricao;
    private Double latitude;
    private Double longitude;
    private Boolean valida;
}
