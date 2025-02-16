package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;
import model.entities.Nota;

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

	@Override
	public List<Aluno> listarTodosAlunos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT alunos.* FROM alunos;");
			rs = st.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				alunos.add(aluno);
			}
			return alunos;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Aluno> adicionarNotasAosAlunos(List<Aluno> alunos) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT notas.* FROM notas;");
			rs = st.executeQuery();
			List<Aluno> list = alunos;
			while (rs.next()) {
				int id = rs.getInt("id_aluno");
				Aluno aluno = alunos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
				Nota nota = new Nota();
				nota.setId(rs.getInt("id"));
				nota.setId_aluno(rs.getInt("id_aluno"));
				nota.setNota(rs.getDouble("nota"));
				aluno.adicionarNota(nota);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
