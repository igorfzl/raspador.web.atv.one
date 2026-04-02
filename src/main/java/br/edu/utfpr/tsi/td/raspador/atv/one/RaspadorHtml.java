package br.edu.utfpr.tsi.td.raspador.atv.one;

import br.edu.utfpr.tsi.td.model.Acompanhamento;
import br.edu.utfpr.tsi.td.model.Documentos;
import br.edu.utfpr.tsi.td.model.Links;
import br.edu.utfpr.tsi.td.model.Orientacoes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RaspadorHtml {

    public void rasparPaginaStudents() {
        String url = "https://lds.td.utfpr.edu.br/sistemas/orienta.acoes/publico/orientacoes?usernameOrientador=ivanlsalvadori";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements bloco = doc.select("#resultadoOrientacoes div.card.mb-3.bg-light");

            List<Orientacoes> lista = new ArrayList<>();

            for (Element item : bloco) {
                Orientacoes o = new Orientacoes();

                String titulo = item.select("h5.card-title").text();
                String orientado = item.select("strong:contains(Orientando) + span").text();
                String curso = item.select("strong:contains(Curso) + span").text();
                String orientador = item.select("strong:contains(Orientador) + span").text();
                String inicio = item.select("strong:contains(Início) + span").text();
                String conclusao = item.select("strong:contains(Conclusão) + span").text();
                String situacao = item.select("strong:contains(Situação) + span").text();
                String etapa = item.select("strong:contains(Etapa) + span").text();

                o.setTitulo(titulo);
                o.setOrientado(orientado);
                o.setCurso(curso);
                o.setOrientador(orientador);
                o.setInicio(inicio);
                o.setConclusao(conclusao);
                o.setSituacao(situacao);
                o.setEtapa(etapa);

                List<Acompanhamento> listaAcom = new ArrayList<>();
                Elements linhas = item.select("div[id^=reunioes] table tbody tr");

                for (Element linha : linhas) {
                    Elements cols = linha.select("td");
                    if (cols.size() >= 3) {
                        Acompanhamento a = new Acompanhamento();
                        a.setAcompanhamentoData(cols.get(0).text());
                        a.setCadastradoPor(cols.get(1).text());
                        a.setAssunto(cols.get(2).text());
                        listaAcom.add(a);
                    }
                }
                o.setAcompanhamentos(listaAcom);

                List<Documentos> listaDoc = new ArrayList<>();
                Elements linhasDoc = item.select("div[id^=documentos] table tbody tr");

                for (Element itemLinha : linhasDoc) {
                    Elements cols = itemLinha.select("td");
                    if (cols.size() >= 4) {
                        Documentos d = new Documentos();
                        d.setNomeDoc(cols.get(0).text());
                        d.setEnviadoPor(cols.get(1).text());
                        d.setDocData(cols.get(2).text());
                        d.setAcesso(cols.get(3).text());
                        listaDoc.add(d);
                    }
                }
                o.setDocumentos(listaDoc);

                List<Links> listaLinks = new ArrayList<>();
                Elements linhasLink = item.select("div[id^=links] table tbody tr");

                for (Element itemLink : linhasLink) {
                    Elements cols = itemLink.select("td");
                    if (cols.size() >= 3) {
                        Links l = new Links();
                        l.setDescricao(cols.get(0).text());
                        l.setCadastradoPor(cols.get(1).text());
                        l.setData(cols.get(2).text());
                        listaLinks.add(l);
                    }
                }
                o.setLinks(listaLinks);


                lista.add(o);

            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(lista);

            try (FileWriter writer = new FileWriter("orientacoes.json")) {
                writer.write(json);
            }

            System.out.println("Arquivo orientacoes.json gerado com sucesso!");

        } catch (IOException e) { // O CATCH AGORA FECHA O TRY CORRETAMENTE
            System.err.println(e.getMessage());
        }
    }
}