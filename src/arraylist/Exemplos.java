package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Exemplos {

	public static void main(String[] args) {

		// CONSTRUTOR DE ARRAYLIST ACEITANDO UMA COLEÇÃO
		Collection<Integer> numeros = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
		List<Integer> lista1 = new ArrayList<>(numeros);
		lista1.forEach(System.out::println);

		// ADICIONAR ELEMENTOS A UM ARRAYLIST
		List<Long> lista2 = new ArrayList<>();
		lista2.add(1L);
		lista2.add(2L);
		lista2.add(1, 3L);
		lista2.forEach(System.out::println);

		// PERCORRENDO O ARRAYLIST COM LISTITERATOR
		List<Integer> lista3 = new ArrayList<>(
				IntStream.range(0, 10).boxed().collect(Collectors.toCollection(ArrayList::new)));
		ListIterator<Integer> it = lista3.listIterator(lista3.size());
		// Criando uma lista com os valores invertidos
		List<Integer> resultado = new ArrayList<>(lista3.size());
		while (it.hasPrevious()) {
			resultado.add(it.previous());
		}
		resultado.forEach(System.out::println);

		// BUSCANDO ELEMENTOS
		List<String> lista4 = LongStream.range(0, 16).boxed().map(Long::toHexString)
				.collect(Collectors.toCollection(ArrayList::new));
		List<String> stringsParaBuscar = new ArrayList<>(lista4);
		stringsParaBuscar.addAll(lista4);
		stringsParaBuscar.forEach(System.out::println);

		// Buscando na coleção não ordenada
		System.out.println(stringsParaBuscar.indexOf("a"));
		System.out.println(stringsParaBuscar.lastIndexOf("a"));
		
		// Buscando em uma coleção ordenada
		List<String> copia = new ArrayList<>(stringsParaBuscar);
		Collections.sort(copia);
		int index = Collections.binarySearch(copia, "f");
		System.out.println(index);

		// REMOVENDO UM ELEMENTO
		List<Integer> lista5 = new ArrayList<>(
				IntStream.range(0, 10).boxed().collect(Collectors.toCollection(ArrayList::new)));
		Collections.reverse(lista5);

		lista5.remove(0);   // Deve remover o número 9, que está no índice 0
		lista5.forEach(System.out::println);

		lista5.remove(Integer.valueOf(0));  // Deve remover o número 0
		lista5.forEach(System.out::println);

	}

}
