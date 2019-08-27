package application;

import java.util.List;
import java.util.Scanner;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ClienteDao clienteDao = DaoFactory.criaClienteDao();

		System.out.println("=== teste 1: findById =======");
		Cliente dep = clienteDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== teste 2: findAll =======");
		List<Cliente> list = clienteDao.findAll();
		for (Cliente cli : list) {
			System.out.println(cli);
		}
		
		System.out.println("\n=== teste 3: insert =======");
		Cliente novoCli = new Cliente(null, "Luftansa", "Alemanha");
		clienteDao.insert(novoCli);
		System.out.println("Inseriu novo id = " + novoCli.getId());
		
		System.out.println("\n=== teste 4: update =======");
		Cliente cli2 = clienteDao.findById(5);
		cli2.setEmpresa("Google");
		cli2.setProjeto("Novo Google");
		clienteDao.update(cli2);
		System.out.println("Atualizado ! ");
		
		System.out.println("\n=== teste 5: delete =======");
		System.out.print("Digite um Id para deletar : ");
		int id = sc.nextInt();
		clienteDao.deleteById(id);
		System.out.println("Deletado com sucesso !");
		
		
		
		
		sc.close();
	}

}
