package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Cliente;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		FuncionarioDao funcionarioDao = DaoFactory.criaFuncionarioDao();
		
		System.out.println("=== Teste 1 : Funcionario findById ===");
		Funcionario funcionario = funcionarioDao.findById(2);
		System.out.println(funcionario);
		
		System.out.println("\n=== Teste 2 : Funcionario findByCliente ===");
		Cliente cliente = new Cliente(2, null, null);
		List<Funcionario> list = funcionarioDao.findByCliente(cliente);
		for (Funcionario obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3 : Funcionario findAll ===");
		cliente = new Cliente(2, null, null);
		list = funcionarioDao.findAll();
		for (Funcionario obj : list) {
			System.out.println(obj);
		}
		
	}
}
