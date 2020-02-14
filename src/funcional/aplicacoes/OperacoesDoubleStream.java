package funcional.aplicacoes;

import java.util.stream.DoubleStream;

public class OperacoesDoubleStream {

	public static void main(String[] args) {
		// Array original
		double[] notas = { 4.8, 5.5, 10.0, 8.2, 1.5, 4.5, 7.5, 8.0, 9.7, 6.0 };

		/*
		 * A média das notas 
		 * A maior e menor notas 
		 * A quantidade de notas maiores ou iguais a 5.0 
		 * A lista de notas abaixo de 5.0 em ordem crescente
		 */

		// Exibir os valores originais usando um stream
		System.out.println("Valores originais:");
		DoubleStream.of(notas).forEach(n -> System.out.printf("%.2f ", n));
		
		// Contador, média, maior e menor
		System.out.printf("%nQuantidade de Notas: %d%n", DoubleStream.of(notas).count());
		System.out.printf("%nMaior Nota: %.2f%n", DoubleStream.of(notas).max().getAsDouble());
		System.out.printf("%nMenor Nota: %.2f%n", DoubleStream.of(notas).min().getAsDouble());
		System.out.printf("%nMédia: %.2f%n", DoubleStream.of(notas).average().getAsDouble());
		
		// Novos valores
		DoubleStream.of(notas)
			.map(n -> ((n + 0.5) >= 10) ? 10 : n + 0.5)
			.forEach(n -> System.out.printf("%.2f ", n));
		
		System.out.printf("%nNova média com meio ponto para todos: %.2f%n", 
				DoubleStream.of(notas)
					.map(n -> ((n + 0.5) >= 10) ? 10 : n + 0.5)
					.average().getAsDouble());
		
		// Quantidade de alunos reprovados após meio ponto
		System.out.printf("%nQuantidade de reprovados após meio ponto: %d%n", 
				DoubleStream.of(notas)
					.map(n -> ((n + 0.5) >= 10) ? 10 : n + 0.5)
					.filter(n -> n < 5)
					.count());

	}
}
