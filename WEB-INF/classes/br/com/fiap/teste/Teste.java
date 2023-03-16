package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {

		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.DBConnectionManager();
		Cliente c = null;
		System.out.println("STATUS da Atualização : " + new Teste().delete(2, con));
		
		
		con = cf.DBConnectionManager();
		List<Cliente> lista = new Teste().select(con);
		
		for (Cliente cli :  lista) {
			System.out.println("Nome do cliente : " + cli.getNome());
			System.out.println("Nome do cliente : " + new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
		}
		
		
//		cli = new Cliente();
//		cli.setNome("Marilia");
//		cli.setSobrenome("Maria");
//		cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-12"));
//		cli.setGenero('f');
//		cli.setTelefone("(11) 98965-3256");
//		
//		System.out.println("STATUS da Atualização : " + new Teste().update(cli, 5, con));
//		
//		
//		con = cf.DBConnectionManager();
//		//Verificando a ATUALIZAÇÃO
//		cli = new Teste().select(5, con);
//		System.out.println("Nome do cliente : " + cli.getNome());
//		System.out.println("Nome do cliente : " + new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));

	}

	public Cliente select(int idCli, Connection con) {

		String sql = null;
		Cliente cli = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// CRIANDO A INSTRUÇÃO SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";

			// Criando a conexão
			ps = con.prepareStatement(sql);

			// Popular a instrução SQL.
			ps.setInt(1, idCli);

			// Criando o ResultSet que vai armazenar o conteúdo da consulta.
			rs = ps.executeQuery();

			// Criando uma estrutura para ler o ResultSet
			while (rs.next()) {
				// A cada iteração, será criado um novo Objeto e este será populado
				// com os dados oriundos da base de dados.
				cli = new Cliente();
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cli;
	}

	public int update(Cliente cli, int idCli, Connection con) {

		String sql = null;
		PreparedStatement ps = null;
		int status = 0;

		try {

			// Criando a instrução SQL
			sql = "UPDATE TBL_CLIENTE SET NOME_CLI = ?, SOBRENOME_CLI = ?, "
					+ "DATA_NASC_CLI = TO_DATE(?,'YYYY-MM-DD'), GENERO_CLI = ?, TEL_CLI = ? " + "WHERE ID_CLI = ?";

			// Criando a conexão.
			ps = con.prepareStatement(sql);

			// Popular a conexão com o objeto
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());
			ps.setInt(6, idCli);

			// Gerando o retorno para o Status
			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public int delete(int idCli, Connection con) {
		
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
			//Criando a instrução SQL
			sql = "DELETE FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criar a conexão
			ps = con.prepareStatement(sql);
			
			//Popular a conexão com o parâmetro
			ps.setInt(1, idCli);
			
			//Obtendo o status
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return status;
	}

	public List<Cliente> select(Connection con) {

		// CRIANDO A INSTRUÇÃO SQL
		String sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";

		// Criando a lista que vai ser retornada com todos os registros.
		List<Cliente> lista = new ArrayList<Cliente>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// Criando a conexão
			ps = con.prepareStatement(sql);

			// Criando o ResultSet que vai armazenar o conteúdo da consulta.
			rs = ps.executeQuery();

			// Criando uma instância da classe Cliente
			Cliente cli = null;

			// Criando uma estrutura para ler o ResultSet
			while (rs.next()) {
				// A cada iteração, será criado um novo Objeto e este será populado
				// com os dados oriundos da base de dados.
				cli = new Cliente();
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));

				// Adicionamos o objeto na lista
				lista.add(cli);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}


	
}

//try {
//	Connection con = cf.DBConnectionManager();
//	Cliente cli = new Cliente();
//	cli.setNome("Lulu");
//	cli.setSobrenome("Nobre");
//	cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse("1966-06-09"));
//	cli.setGenero('m');
//	cli.setTelefone("11987659087");
//	
//		//CRIANDO A INSTRUÇÃO SQL
//		String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
//		
//		//CRIANDO A CONEXÃO
//		PreparedStatement ps = con.prepareStatement(sql); 
//				
//		//POPULANDO A CONEXÃO
//		ps.setString(1, cli.getNome());
//		ps.setString(2, cli.getSobrenome());
//		ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
//		ps.setString(4, String.valueOf(cli.getGenero()));
//		ps.setLong(5, Long.parseLong(cli.getTelefone()));
//		
//		//EXECUTANDO A INSTRUÇÃO COM O EXECUTE-UPDATE E SE RETORNAR 1 É PORQUE FOI SUCESSO!
//		int status = ps.executeUpdate();
//		
//		System.out.println("STATUS : " + status);
//		
//		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//
