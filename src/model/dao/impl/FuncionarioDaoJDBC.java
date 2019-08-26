package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.FuncionarioDao;
import model.entities.Cliente;
import model.entities.Funcionario;

public class FuncionarioDaoJDBC implements FuncionarioDao {

	private Connection conn;

	public FuncionarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Funcionario cli) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Funcionario cli) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Funcionario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement(
				"SELECT funcionario.*,Empresa as EmpNome,Projeto as ProjNome "
				+ "FROM funcionario INNER JOIN cliente "
				+ "ON funcionario.ClienteId = cliente.Id "
				+ "WHERE funcionario.Id = ?");
		
		st.setInt(1, id);
		rs = st.executeQuery();
		if(rs.next()) {
			Cliente cli = instantiateCliente(rs);
			Funcionario obj = instantiateFuncionario(rs, cli);
			return obj;
		}
		return null;
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Funcionario instantiateFuncionario(ResultSet rs, Cliente cli) throws SQLException {
		Funcionario obj = new Funcionario();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Nome"));
		obj.setEmail(rs.getString("Email"));
		obj.setInicio(rs.getDate("Inicio"));
		obj.setSalario(rs.getDouble("Salario"));
		obj.setCliente(cli);
		return obj;
	}

	private Cliente instantiateCliente(ResultSet rs) throws SQLException {
		Cliente cli = new Cliente();
		cli.setId(rs.getInt("ClienteId"));
		cli.setEmpresa(rs.getString("EmpNome"));
		cli.setProjeto(rs.getString("ProjNome"));
		return cli;
	}

	@Override
	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
