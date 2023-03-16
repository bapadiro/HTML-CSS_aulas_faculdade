package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class ClienteDAO {

	private Connection con;

	public ClienteDAO() {
		ConnectionFactory cf = new ConnectionFactory();
		try {
			this.con = cf.DBConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> select() {

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
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
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

	public Cliente select(int idCli) {
		
		String sql = null;
		Cliente cli = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			// CRIANDO A INSTRUÇÃO SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			// Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Popular a instrução SQL.
			ps.setInt(1, idCli);

			//Criando o ResultSet que vai armazenar o conteúdo da consulta.
			rs = ps.executeQuery();

			// Criando uma estrutura para ler o ResultSet
			while (rs.next()) {
				// A cada iteração, será criado um novo Objeto e este será populado
				// com os dados oriundos da base de dados.
				cli = new Cliente();
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
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

	public int insert(Cliente cli) {

		try {

			// CRIANDO A INSTRUÇÃO SQL
			String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

			// CRIANDO A CONEXÃO
			PreparedStatement ps = con.prepareStatement(sql);

			// POPULANDO A CONEXÃO
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());

			// EXECUTANDO A INSTRUÇÃO COM O EXECUTE-UPDATE E SE RETORNAR 1 É PORQUE FOI
			// SUCESSO!
			int status = ps.executeUpdate();
			return status;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int update(Cliente cli, int idCli) {
		
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
			
			//Criando a instrução SQL
			sql = "UPDATE TBL_CLIENTE SET NOME_CLI = ?, SOBRENOME_CLI = ?, "
					+ "DATA_NASC_CLI = TO_DATE(?,'YYYY-MM-DD'), GENERO_CLI = ?, TEL_CLI = ? "
					+ "WHERE ID_CLI = ?";
			
			//Criando a conexão.
			ps = con.prepareStatement(sql);
			
			//Popular a conexão com o objeto
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
			ps.setString(4, String.valueOf(cli.getGenero()));
			ps.setString(5, cli.getTelefone());
			ps.setInt(6, idCli);
			
			//Gerando o retorno para o Status
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

	public int delete(int idCli) {
		
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

}
