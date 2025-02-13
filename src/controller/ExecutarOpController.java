package controller;

import java.util.Scanner;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import utilities.GerenciadorMensagens;
import utilities.ObterString;

public class ExecutarOpController {

	private static AlunoDao alunoDao = DaoFactory.createAlunoDao();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void executarOp(int menuOp) {
		switch (menuOp) {
		case 1: cadastrarAluno();
			break;
		}
		
	}
	
	public static void cadastrarAluno() {
		String nome = ObterString.obterString(GerenciadorMensagens.EXECUTAR_OP_NOME_ALUNO, scanner);
		Aluno aluno =  new Aluno(nome);
		alunoDao.cadastrarAluno(aluno);
		System.out.println(GerenciadorMensagens.EXECUTAR_OP_CADASTRO_FEITO);
	}
	
}
