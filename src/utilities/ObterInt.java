package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObterInt {

	public static int obterInt(Scanner scanner, String prompt, int opCondicaoValidar) {
		int valor = 10;
		boolean inputValido = false;
		boolean sairDaOp = false;
		while (!inputValido) {
			try {
				if(sairDaOp) {
					int opTentarNovamente = obterInt(scanner, "\nDigite 1 para tentar novamente ou 2 para sair: ", 2);
					if (opTentarNovamente == 2) {
						break;
					}
				}
				sairDaOp = true;
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
		case 2: validarCond2(valor);
		}
	}
	
	//Menu Controller
	public static void validarCond1(int valor) {
		if (valor < 0 || valor > 2) {
			throw new IllegalArgumentException(GerenciadorMensagens.OBTER_INT_OPCAO_INVALIDA);
		}
	}
	
	//Op tentar input novamente
	public static void validarCond2(int valor) {
		if (valor < 1 || valor > 2) {
			throw new IllegalArgumentException(GerenciadorMensagens.OBTER_INT_OPCAO_INVALIDA);
		}
	}
	
}
