package com.exampleCP2.diplomados.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Diplomado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String nacionalidade;

    @NotBlank
    private String naturalidade;

    @NotBlank
    private String rg;

    // Campos adicionais para autenticação
    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    public Diplomado() {}

    public Diplomado(String nome, String nacionalidade, String naturalidade, String rg, String username, String password, Set<Role> roles) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.rg = rg;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
