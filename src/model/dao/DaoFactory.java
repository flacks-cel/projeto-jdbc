package model.dao;

import db.DB;
import model.dao.impl.FuncionarioDaoJDBC;

public class DaoFactory {
	
	public static FuncionarioDao criaFuncionarioDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
}
}