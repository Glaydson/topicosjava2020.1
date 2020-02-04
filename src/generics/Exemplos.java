package generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exemplos {

	public static void main(String[] args) {
		
		// CRIANDO UMA LISTA DE INTEIROS
		List<Integer> lista = new LinkedList<>();
		lista.add(new Integer(1));
		Integer i = lista.iterator().next();

	}

	// MÉTODO GENÉRICO PARA CONVERTER UM ARRAY PARA UMA LISTA
	public <T> List<T> deArrayParaLista(T[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}
	
	// MÉTODO GENÉRICO PARA CONVERTER UM ARRAY DE UM TIPO T PARA UMA LISTA DE UM TIPO G
	public static <T, G> List<G> deArrayParaLista(T[] a, Function<T, G> funcaoMapeadora) {
	    return Arrays.stream(a)
	      .map(funcaoMapeadora)
	      .collect(Collectors.toList());
	}

}
