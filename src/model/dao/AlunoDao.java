package model.dao;

import java.util.List;

import model.entities.Aluno;

public interface AlunoDao {
	
	void cadastrarAluno(Aluno aluno);
	List<Aluno> listarTodosAlunos();
	List<Aluno> adicionarNotasAosAlunos(List<Aluno> alunos);
}
