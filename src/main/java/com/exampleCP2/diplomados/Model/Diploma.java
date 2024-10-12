package com.exampleCP2.diplomados.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Diploma {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Diplomado diplomado;

    @ManyToOne
    private Curso curso;

    @NotNull
    private LocalDate dataConclusao;

    @Enumerated(EnumType.STRING)
    private Sexo sexoReitor;

    @NotBlank
    private String nomeReitor;

    // Getters e Setters
}

