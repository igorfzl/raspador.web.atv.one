package br.edu.utfpr.tsi.td.raspador.atv.one;

public class Documentos {
    private String nomeDoc;
    private String enviadoPor;
    private String docData;
    private String acesso;

    public String getDocData() {
        return docData;
    }

    public void setDocData(String docData) {
        this.docData = docData;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }

    public String getEnviadoPor() {
        return enviadoPor;
    }

    public void setEnviadoPor(String enviadoPor) {
        this.enviadoPor = enviadoPor;
    }


    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
}
