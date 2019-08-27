package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Cliente;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		System.out.println("\n=== Teste 4 : Funcionario Insert ===");
		Funcionario funcNovo = new Funcionario(null, "Armani", "armani@gmail.com", new Date(), 1000.0, cliente);
		funcionarioDao.insert(funcNovo);
		System.out.println("Inseriu novo id = " + funcNovo.getId());
		
		System.out.println("\n=== Teste 5 : Funcionario update ===");
		funcionario = funcionarioDao.findById(1);
		funcionario.setNome("Bruna");
		funcionarioDao.update(funcionario);
		System.out.println("Atualizado ! ");
		
		System.out.println("\n=== Teste 6 : Funcionario delete ===");
		System.out.println("Digite um Id para deletar : ");
		int id = sc.nextInt();
		funcionarioDao.deleteById(id);
		System.out.println("Deletado com sucesso !");
	
	sc.close();
	}
}
