package utilities;

import java.util.Scanner;

public class ObterString {

	public static String obterString(String prompt, Scanner scanner) {
		String frase = null;
		boolean inputValido = false;
		boolean fraseIsEmpty = false;
		while (!inputValido) {
			try {
				System.out.print(prompt);
				frase = scanner.nextLine();
				fraseIsEmpty = testarFrase(frase);
				testarExcessao(fraseIsEmpty);
				inputValido = true;
				
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return frase;
	}
	
	public static boolean testarFrase(String frase) {
		boolean resultadoTeste = false;
		if (frase.isBlank()) {
			resultadoTeste = true;
		}
		return resultadoTeste;
	}
	
	public static void testarExcessao(boolean fraseIsEmpty) {
		if (fraseIsEmpty) {
			throw new IllegalArgumentException(GerenciadorMensagens.OBTER_STRING_INPUT_EM_BRANCO);
		}
	}
	
}
