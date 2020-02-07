package funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContaPalavras {

	public static void main(String[] args) {
		List<String> dataSource = new ArrayList<>();

		dataSource.add("isto");
		dataSource.add("é");
		dataSource.add("um");
		dataSource.add("teste");
		dataSource.add("é");
		dataSource.add("somente");
		dataSource.add("um");
		dataSource.add("teste");
		dataSource.add("e");
		dataSource.add("nada");
		dataSource.add("mais");

		Stream<String> streamStrings = dataSource.stream();
		
		long contador = dataSource.stream()
				.distinct()
				.filter(palavra -> palavra.length() >= 4)
				.count();

		System.out.println(String.format("A Coleção possui %d palavras distintas de 4 ou mais caracteres.", contador));
		
		dataSource.stream()
				.distinct()
				.filter(palavra -> palavra.length() >= 4)
				.forEach(System.out::println);
	}

}
