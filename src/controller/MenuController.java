package controller;

import java.util.Scanner;

import utilities.GerenciadorMensagens;
import utilities.ObterInt;

public class MenuController {

	public static void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
	    sb.append(GerenciadorMensagens.MENU_CONTROLLER_CABECALHO_MENU)
	      .append(GerenciadorMensagens.MENU_CONTROLLER_OP_0);
	    System.out.print(sb);
	}
	
	public static int obterOpMenu(Scanner scanner) {
		int opMenu = ObterInt.obterInt(scanner, GerenciadorMensagens.MENU_CONTROLLER_PROMPT_OBTER_INT, 1);
		return opMenu;
	}
	
}
