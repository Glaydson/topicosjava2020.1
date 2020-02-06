package funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.lang.System.out;

public class ExemploForEach {
	
	public static void main(String[] args) {
		// Define um array de strings
		String[] citacoes = new String[] {
			"Hamlet Ato 3 Cena 1",
			"Hamlet Ato 3 Cena 1",
			"Romeu e Julieta Ato 2 Cena 2",
			"Ricardo III Ato 1 Cena 2",
			"Hamlet Ato 1 Cena 3",
			"Henrique IV Parte 2 Ato 3 Cena 2",
			"O Mercador de Veneza Ato 2 Cena 7"
		};
		
		// Imprime as citações que contenham Hamlet usando loop for
		for (String c: citacoes) {
			if (c.contains("Hamlet")) {
				out.println(String.format("%s", c));
			}
		}
		
		// Imprime as citações que contenham Hamlet usando streams, removendo duplicidades
		Stream.of(citacoes)
			.filter(c -> c.contains("Hamlet"))
			.distinct()
			.forEach(c -> {
				out.println(String.format("%s", c));
			});
		
		// Imprime todas as citações usando forEach da API Collections
		List<String> cLista = Arrays.asList(citacoes);
		cLista.forEach(c -> {
			out.println(String.format("%s", c));
		});
}
}
