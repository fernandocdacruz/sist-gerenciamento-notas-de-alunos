package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.NotaDao;

public class NotaDaoJDBC implements NotaDao {
	
	private Connection conn = null;

	public NotaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void adicionarNota(int id_aluno, double nota) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO notas(id_aluno, nota) VALUES(?, ?);");
			st.setInt(1, id_aluno);
			st.setDouble(2, nota);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
}
