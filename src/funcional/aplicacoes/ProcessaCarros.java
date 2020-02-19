package funcional.aplicacoes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProcessaCarros {

	public static void main(String[] args) {
		Carro[] carros = { new Carro("Ford", "Corcel", 1985, 2000), 
				new Carro("Ford", "Fiesta", 2015, 15000),
				new Carro("Ford", "Ranger", 2014, 75000), 
				new Carro("Fiat", "Uno", 1999, 5000),
				new Carro("Fiat", "Palio", 2014, 10000), 
				new Carro("Chevrolet", "Cobalt", 2017, 40000),
				new Carro("Chevrolet", "Onix", 2016, 30000), 
				new Carro("Chevrolet", "Vectra", 2010, 23000),
				new Carro("Kia", "Sportage", 2014, 70000), 
				new Carro("Toyota", "Corolla", 2018, 98000) };
		
		
		// Lista de todos os carros
		List<Carro> listaCarros = Arrays.asList(carros);
		System.out.println("***** TODOS OS CARROS *****");
		listaCarros.stream().forEach(System.out::println);
		
		// Carros com ano entre 2000 e 2015 (inclusive), em ordem de marca
		System.out.println("***** CARROS ENTRE 2000 E 2015 EM ORDEM DE MARCA *****");
		listaCarros.stream().filter(c -> (c.getAno() >= 2000 && c.getAno() <= 2015))
			.sorted(Comparator.comparing(Carro::getMarca))
			.forEach(System.out::println);
		
		// Média dos preços dos carros
		System.out.println("***** MÉDIA DOS PREÇOS *****");
		System.out.println(listaCarros.stream()
			.mapToDouble(c -> c.getValor())
			.average()
			.getAsDouble());
		
		//Carros agrupados por marca
		System.out.println("***** CARROS AGRUPADOS POR MARCA *****");
		Map<String, List<Carro>> agrupadosPorMarca =
				listaCarros.stream().collect(Collectors.groupingBy(Carro::getMarca));
		agrupadosPorMarca.forEach(
				(marca, carrosDaMarca) -> 
				{
					System.out.println(marca.toUpperCase());
					carrosDaMarca.forEach(
							carro -> System.out.printf("     %s%n", carro));
					System.out.println("Total da Marca: " + carrosDaMarca.size());
				}
		);
		
		//Número de carros de cada marca
		System.out.println("***** NÚMERO DE CARROS DE CADA MARCA *****");
		Map<String, Long> numeroCarrosPorMarca=
				listaCarros.stream()
					.collect(Collectors.groupingBy(Carro::getMarca, 
							TreeMap::new, Collectors.counting()));
		numeroCarrosPorMarca.forEach(
				(marca, quantidade) -> System.out.printf(
						"A marca %s possui %d carros(s)%n", marca, quantidade));

		 
		
	}

}
