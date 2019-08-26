package application;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		FuncionarioDao funcionarioDao = DaoFactory.criaFuncionarioDao();
		
		System.out.println("=== Teste 1 : Funcionario findById ===");
		Funcionario funcionario = funcionarioDao.findById(2);
		System.out.println(funcionario);

	}
}
