package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {
	
	private ClienteDAO cd = null;
	
	
	public int cadastroCliente(Cliente cli) {
		cd = new ClienteDAO();
		return cd.insert(cli);
	}
	
	public List<Cliente> listagemCliente(){
		cd = new ClienteDAO();
		return cd.select();
	}
	
	public Cliente listagemCliente(int idCli){
		cd = new ClienteDAO();
		return cd.select(idCli);
	}
	
	public int atualizaCliente(Cliente cli, int idCli) {
		cd = new ClienteDAO();
		return cd.update(cli, idCli);
	}
	
	public int apagaCliente(int idCli) {
		cd = new ClienteDAO();
		return cd.delete(idCli);
	}

	
}
