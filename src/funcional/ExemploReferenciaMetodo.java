package funcional;

import java.io.PrintStream;
import java.util.Objects;
import java.util.stream.Stream;

public class ExemploReferenciaMetodo {

	public static void main(String[] args) {
		
		class Citacao  {
			private String citacao;
			public Citacao(String citacao) {
				this.citacao = citacao;
			}
			public String getCitacao() {
				return citacao;
			}
		}

		PrintStream log = System.out;
		
		// Cria array de array de strings
		String[][] citacoes = new String[][] {
			{"Hamlet Ato 3 Cena 1", 				"Hamlet",		"Ser ou não ser"},
			{"Hamlet Ato 3 Cena 2", 				"Hamlet",		null},
			{"Romeu e Julieta Ato 2 Cena 2",		"Julieta",		"Romeu!, Romeu! Onde está você, Romeu?"},
			{"Ricardo III Ato 1 Cena 2",			"Ricardo III", 	"Agora é o inverno dos descontentes"},
			{"Hamlet Ato 1 Cena 3", 				"Polonius",		"Sobretudo, seja verdadeiro contigo mesmo"},
			{"Henrique IV Parte 2 Ato 3 Cena 2",	"Feeble", 		"Um homem só pode morrer uma vez"},
			{"O Mercador de Veneza Ato 2 Cena 7",	"Morocco", 		"Nem tudo que reluz é ouro"}
		};
				
		// Aplica referências de método nas transformações
		Stream.of(citacoes)
			.map(c -> c[2])    // Ficam somente as citações
			.filter(Objects::nonNull)      // Método estático
			.peek(log::println)		// Método de instância de um objeto específico
			.map(String::toUpperCase)		// Método de instância de um objeto arbitrário
			.map(Citacao::new)  		// Construtor
			.forEach(c -> log.println(c.getCitacao()));
	}
	
	
}
