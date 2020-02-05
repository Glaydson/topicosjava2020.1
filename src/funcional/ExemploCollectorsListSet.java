package funcional;

import static java.lang.System.out;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploCollectorsListSet {

	public static void main(String[] args) {
		// Cria um stream de Strings
		Stream<String> stream = Stream.of(new String[] { "ser", "ou", "n�o", "ser" });
		out.println();
		// Obt�m uma lista a partir do stream
		List<String> comoLista = stream
				.peek(s -> out.print(s + " "))  // Faz o log da sa�da, para checar a ordem de processamento
				.collect(Collectors.toList());
		out.println();
		// Os valores s�o impressos na mesma ordem do stream original
		out.println(comoLista);
		
		// No Set, n�o h� duplicatas e a ordem n�o � garantida
		Set<String> comoSet = comoLista.stream().collect(Collectors.toSet());
		out.println(comoSet);

	}

}
