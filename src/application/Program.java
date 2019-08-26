package application;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		FuncionarioDao funcionarioDao = DaoFactory.criaFuncionarioDao();
		
		Funcionario funcionario = funcionarioDao.findById(1);
		System.out.println(funcionario);

	}
}
