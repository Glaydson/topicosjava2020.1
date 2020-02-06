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
			{"Hamlet Ato 3 Cena 1", 				"Hamlet",		"Ser ou n�o ser"},
			{"Hamlet Ato 3 Cena 2", 				"Hamlet",		null},
			{"Romeu e Julieta Ato 2 Cena 2",		"Julieta",		"Romeu!, Romeu! Onde est� voc�, Romeu?"},
			{"Ricardo III Ato 1 Cena 2",			"Ricardo III", 	"Agora � o inverno dos descontentes"},
			{"Hamlet Ato 1 Cena 3", 				"Polonius",		"Sobretudo, seja verdadeiro contigo mesmo"},
			{"Henrique IV Parte 2 Ato 3 Cena 2",	"Feeble", 		"Um homem s� pode morrer uma vez"},
			{"O Mercador de Veneza Ato 2 Cena 7",	"Morocco", 		"Nem tudo que reluz � ouro"}
		};
				
		// Aplica refer�ncias de m�todo nas transforma��es
		Stream.of(citacoes)
			.map(c -> c[2])    // Ficam somente as cita��es
			.filter(Objects::nonNull)      // M�todo est�tico
			.peek(log::println)		// M�todo de inst�ncia de um objeto espec�fico
			.map(String::toUpperCase)		// M�todo de inst�ncia de um objeto arbitr�rio
			.map(Citacao::new)  		// Construtor
			.forEach(c -> log.println(c.getCitacao()));
	}
	
	
}
