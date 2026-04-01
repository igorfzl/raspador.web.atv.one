package br.edu.utfpr.tsi.td.raspador.atv.one;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RaspadorHtml {

    public void rasparPaginaStudents() {
        String url = "https://lds.td.utfpr.edu.br/sistemas/orienta.acoes/publico/orientacoes?usernameOrientador=ivanlsalvadori";
        try {
            Orientacoes orienta = new Orientacoes();
            Document doc = Jsoup.connect(url).get();
            List<Orientacoes> lista = new ArrayList<>();
            List<Documentos> listaDoc = new ArrayList<>();
            List<Acompanhamento> listaAcom = new ArrayList<>();
            Elements bloco = doc.select("#resultadoOrientacoes");
            for (Element blocos : bloco) {
                Elements itens = bloco.select("div.card.mb-3.bg-light");

                for (Element item : itens) {
                    Orientacoes o = new Orientacoes();
                    Acompanhamento a = new Acompanhamento();
                    Documentos d = new Documentos();


                    String titulo = item.select("h5.card-title").text();
                    String orientado = item.select("strong:contains(Orientando) + span").text();
                    String curso = item.select("strong:contains(Curso) + span").text();
                    String orientador = item.select("strong:contains(Orientador) + span").text();
                    String inicio = item.select("strong:contains(Início) + span").text();
                    String conclusao = item.select("strong:contains(Conclusão) + span").text();
                    String situacao = item.select("strong:contains(Situação) + span").text();
                    String etapa = item.select("strong:contains(Etapa) + span").text();

                    String acompanhamentoData = item.select("");
                    String cadastradoPor = item.select("");
                    String assunto = item.select("");

                    String nomeDoc = item.select("");
                    String enviadoPor = item.select("");
                    String docData = item.select("");
                    String acesso = item.select("");

                    o.setOrientado(titulo);
                    o.setOrientado(orientado);
                    o.setCurso(curso);
                    o.setOrientador(orientador);
                    o.setInicio(inicio);
                    o.setConclusao(conclusao);
                    o.setSituacao(situacao);
                    o.setEtapa(etapa);
                    lista.add(o);

                    a.setAcompanhamentoData(acompanhamentoData);
                    a.setCadastradoPor(cadastradoPor);
                    a.setAssunto(assunto);
                    listaAcom.add(a);

                    d.setNomeDoc(nomeDoc);
                    d.setEnviadoPor(enviadoPor);
                    d.setDocData(docData);
                    d.setAcesso(acesso);
                    listaDoc.add(d);


                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String json = gson.toJson(o);
                    System.out.println(json);

                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}