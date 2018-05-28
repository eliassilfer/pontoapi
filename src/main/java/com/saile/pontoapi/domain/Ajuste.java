package com.saile.pontoapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ajuste {
    @Id
    private String id;
    private String usuarioId;
    private String periodo;
    private Boolean alerta;
    private Boolean localizacao;
}
