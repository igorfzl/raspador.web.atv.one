package br.edu.utfpr.tsi.td.raspador.atv.one;

public class Acompanhamento {
    private String acompanhamentoData;
    private String cadastradoPor;
    private String assunto;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(String cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }

    public String getAcompanhamentoData() {
        return acompanhamentoData;
    }

    public void setAcompanhamentoData(String acompanhamentoData) {
        this.acompanhamentoData = acompanhamentoData;
    }

}