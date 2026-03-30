package br.edu.utfpr.tsi.td.raspador.atv.one;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RaspadorHtml {

	public void rasparPaginaStudents() {
		
		List<Orientacoes> lista = new ArrayList<>();
	    Orientacoes orienta = new Orientacoes();

		String url = "https://lds.td.utfpr.edu.br/sistemas/orienta.acoes/publico/orientacoes?usernameOrientador=ivanlsalvadori";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements bloco = doc.select("#resultadoOrientacoes");
			String saida = bloco.text();
			if (saida != null) {

				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				String json = gson.toJson(saida);

				System.out.println(json);

//				System.out.println(saida);
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}