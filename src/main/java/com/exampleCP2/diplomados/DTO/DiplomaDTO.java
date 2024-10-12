package com.exampleCP2.diplomados.DTO;

import java.time.LocalDate;



public class DiplomaDTO {

    private String nomeDiplomado;
    private String nacionalidade;
    private String naturalidade;
    private String rg;
    private String tipoCurso;
    private String nomeCurso;
    private LocalDate dataConclusao;
    private String tituloReitor;
    private String cargoReitor;

    public String getNomeDiplomado() {
        return nomeDiplomado;
    }

    public void setNomeDiplomado(String nomeDiplomado) {
        this.nomeDiplomado = nomeDiplomado;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getTituloReitor() {
        return tituloReitor;
    }

    public void setTituloReitor(String tituloReitor) {
        this.tituloReitor = tituloReitor;
    }

    public String getCargoReitor() {
        return cargoReitor;
    }

    public void setCargoReitor(String cargoReitor) {
        this.cargoReitor = cargoReitor;
    }

    public DiplomaDTO() {
        this.nomeDiplomado = nomeDiplomado;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.rg = rg;
        this.tipoCurso = tipoCurso;
        this.nomeCurso = nomeCurso;
        this.dataConclusao = dataConclusao;
        this.tituloReitor = tituloReitor;
        this.cargoReitor = cargoReitor;
    }
}