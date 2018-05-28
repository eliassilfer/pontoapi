package com.saile.pontoapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
}
