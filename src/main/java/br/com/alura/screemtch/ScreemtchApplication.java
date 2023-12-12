package br.com.alura.screemtch;

import br.com.alura.screemtch.models.DadosSerie;
import br.com.alura.screemtch.services.ConsumoAPI;
import br.com.alura.screemtch.services.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemtchApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ScreemtchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var conversor = new ConverterDados();
		String apiKey = "85ab49f6";

		var json = consumoAPI.obterDados(String.format("https://www.omdbapi.com/?t=gilmore+girls&apikey=%s", apiKey));
		var dadosDaSerie =  conversor.obterDados(json, DadosSerie.class);

		System.out.println(dadosDaSerie);
	}
}
