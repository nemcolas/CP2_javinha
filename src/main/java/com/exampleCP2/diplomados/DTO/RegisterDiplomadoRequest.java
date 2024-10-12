package com.exampleCP2.diplomados.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterDiplomadoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String nacionalidade;

    @NotBlank
    private String naturalidade;

    @NotBlank
    private String rg;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}