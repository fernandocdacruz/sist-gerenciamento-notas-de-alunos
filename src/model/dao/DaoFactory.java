package model.dao;

import db.DB;
import model.dao.jdbc.AlunoDaoJDBC;
import model.dao.jdbc.NotaDaoJDBC;

public class DaoFactory {

	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
	
	public static NotaDao createNotaDao() {
		return new NotaDaoJDBC(DB.getConnection());
	}
}
