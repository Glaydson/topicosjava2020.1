package funcional;

import static java.lang.System.out;

public class Exemplo1 {

	@FunctionalInterface
	interface Conversor<T, R> {
		R converter(T fonte);
	}

	public static void main(String[] args) {
		Conversor<String, Boolean> stringParaBoolean = s -> Boolean.parseBoolean(s);

		out.println(stringParaBoolean.converter("TRUE"));
		out.println(stringParaBoolean.converter("tRue"));
		out.println(stringParaBoolean.converter("faLse"));
		out.println(stringParaBoolean.converter("No"));
		out.println(stringParaBoolean.converter(null));
		
		Conversor<Boolean, Integer> booleanParaInteger = b -> b ? 1 : 0;
		out.println(booleanParaInteger.converter(true));

	}

}
