package funcional;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.out;

public class ExemploCollectorsMap {

	public static void main(String[] args) {
		Stream<String[]> stream = Stream.of(new String[][] {
			{"Hamlet Ato 3 Cena 1", 				"Ser ou n�o ser"},
			{"Romeu e Julieta Ato 2 Cena 2",		"Romeu!, Romeu! Onde est� voc�, Romeu?"},
			{"Ricardo III Ato 1 Cena 2",			"Agora � o inverno dos descontentes"},
			{"Henrique IV Parte 2 Ato 3 Cena 2",	"Um homem s� pode morrer uma vez"},
			{"O Mercador de Veneza Ato 2 Cena 7",	"Nem tudo que reluz � ouro"}
		});
		
		Map<String, String> comoMap = stream
				.peek(q -> out.println(String.format("%s: '%s'", q[0], q[1])))
				.collect(Collectors.toMap(
						q -> q[0],  // Deriva��o da chave
						q -> q[1]   // Deriva��o do valor
				));
		out.println(comoMap.keySet());
		out.println(comoMap.values());
		
		out.println(comoMap.get("Henrique IV Parte 2 Ato 3 Cena 2"));
	}

}
