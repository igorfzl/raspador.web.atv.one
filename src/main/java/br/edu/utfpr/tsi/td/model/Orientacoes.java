package br.edu.utfpr.tsi.td.model;

import java.util.List;

public class Orientacoes {
    private String titulo;
    private String orientado;
    private String curso;
    private String orientador;
    private String inicio;
    private String conclusao;
    private String situacao;
    private String etapa;
    private String observacoes;

    private List<Acompanhamento> acompanhamentos;
    private List<Documentos> documentos;
    private List<Links> links;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrientado() {
        return orientado;
    }

    public void setOrientado(String orientado) {
        this.orientado = orientado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    public List<Documentos> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentos> documentos) {
        this.documentos = documentos;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}