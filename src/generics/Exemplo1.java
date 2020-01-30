package generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exemplo1 {

	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<>();
		lista.add(new Integer(1));
		Integer i = lista.iterator().next();

	}

	public <T> List<T> deArrayParaLista(T[] a) {
		return Arrays.stream(a).collect(Collectors.toList());
	}
	
	public static <T, G> List<G> deArrayParaLista(T[] a, Function<T, G> funcaoMapeadora) {
	    return Arrays.stream(a)
	      .map(funcaoMapeadora)
	      .collect(Collectors.toList());
	}

}
