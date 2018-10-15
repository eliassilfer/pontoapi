package com.saile.pontoapi.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Document
@Builder
public class Usuario {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String email;
    @Indexed
    private String senha;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;
}
