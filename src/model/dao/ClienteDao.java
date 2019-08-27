package model.dao;

import java.util.List;

import model.entities.Cliente;
import model.entities.Funcionario;

public interface ClienteDao {
	
	void insert (Cliente cli);
	void update (Cliente cli);
	void deleteById (Integer id);
	Cliente findById (Integer id);
	List<Cliente> findAll();
	List<Funcionario> findByCliente();

}
