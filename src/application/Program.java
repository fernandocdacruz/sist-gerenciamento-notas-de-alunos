package application;

import java.util.Locale;
import java.util.Scanner;

import controller.ExecutarOpController;
import controller.MenuController;
import utilities.GerenciadorMensagens;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(GerenciadorMensagens.PROGRAM_MENSAGEM_ABERTURA);
			int menuOp = 0;
			do {
				MenuController.mostrarMenu();
				menuOp = MenuController.obterOpMenu(scanner);
				ExecutarOpController.executarOp(menuOp);
			} while (menuOp != 0);
			System.out.println(GerenciadorMensagens.PROGRAM_MENSAGEM_ENCERRAMENTO);
		}
	}

}
