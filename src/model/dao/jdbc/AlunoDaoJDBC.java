package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoDaoJDBC implements AlunoDao {

	private Connection conn = null;
	
	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void cadastrarAluno(Aluno aluno) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO alunos(nome) VALUES(?);");
			st.setString(1, aluno.getNome());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

}
