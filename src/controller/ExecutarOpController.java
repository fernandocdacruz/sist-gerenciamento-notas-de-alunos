package controller;

import java.util.List;
import java.util.Scanner;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.NotaDao;
import model.entities.Aluno;
import utilities.GerenciadorMensagens;
import utilities.ObterInt;
import utilities.ObterString;

public class ExecutarOpController {

	private static AlunoDao alunoDao = DaoFactory.createAlunoDao();
	private static NotaDao notaDao = DaoFactory.createNotaDao();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void executarOp(int menuOp) {
		switch (menuOp) {
		case 1: cadastrarAluno();
			break;
		case 2: adicionarNotaAluno();
			break;
		case 3: listarAlunosEMedias();
			break;
		}
		
	}
	
	public static void cadastrarAluno() {
		String nome = ObterString.obterString(GerenciadorMensagens.EXECUTAR_OP_NOME_ALUNO, scanner);
		Aluno aluno =  new Aluno(nome);
		alunoDao.cadastrarAluno(aluno);
		System.out.println(GerenciadorMensagens.EXECUTAR_OP_CADASTRO_FEITO);
	}
	
	public static void adicionarNotaAluno() {
		List<Aluno> alunos = alunoDao.listarTodosAlunos();
		if (alunos.isEmpty()) {
			System.out.println(GerenciadorMensagens.EXECUTAR_OP_NENHUM_ALUNO_CADASTRADO);
		} else {
			System.out.println();
			alunos.forEach(System.out::println);
			int id = ObterInt.obterInt(scanner, GerenciadorMensagens.EXECUTAR_OP_DIGITE_ID, 3);
			Aluno aluno = alunos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
			if (aluno == null) {
				System.out.println(GerenciadorMensagens.EXECUTAR_OP_ALUNO_INVALIDO);
			} else {
				System.out.print(GerenciadorMensagens.EXECUTAR_OP_DIGITE_NOTA);
				double nota = scanner.nextDouble();
				notaDao.adicionarNota(id, nota);
				System.out.println(GerenciadorMensagens.EXECUTE_OP_NOTA_ADICIONADA);
			}
		}
	}
	
	public static void listarAlunosEMedias() {
		List<Aluno> alunos = alunoDao.listarTodosAlunos();
		if (alunos.isEmpty()) {
			System.out.println(GerenciadorMensagens.EXECUTAR_OP_NENHUM_ALUNO_CADASTRADO);
		} else {
			alunoDao.adicionarNotasAosAlunos(alunos);
			System.out.println();
			alunos.forEach(a -> System.out.println(a.mediaFinal()));

		}
	}
	
}
