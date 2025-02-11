package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObterInt {

	public static int obterInt(Scanner scanner, String prompt, int opCondicaoValidar) {
		int valor = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				System.out.print(prompt);
				valor = scanner.nextInt();
				validarValor(opCondicaoValidar, valor);
				inputValido = true;
			} catch (InputMismatchException e) {
				System.out.println(GerenciadorMensagens.OBTER_INT_INPUT_INVALIDO);
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return valor;
	}
	
	public static void validarValor(int opCondicaoValidar, int valor) {
		switch (opCondicaoValidar) {
		case 1: validarCond1(valor);
			break;
		}
	}
	
	public static void validarCond1(int valor) {
		if (valor < 0 || valor > 1) {
			throw new IllegalArgumentException(GerenciadorMensagens.OBTER_INT_OPCAO_INVALIDA);
		}
	}
	
}
