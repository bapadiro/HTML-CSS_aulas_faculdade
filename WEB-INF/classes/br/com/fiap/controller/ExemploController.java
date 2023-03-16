package br.com.fiap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.Clinit;

import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(description = "Servlet controladora de acesso e fluxo de dados.", urlPatterns = { "/exemplo" })
public class ExemploController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cliente> lista = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExemploController() {
		super();

		if (lista == null) {
			// Implementando o arrayList do tipo Cliente na lista
			lista = new ArrayList<Cliente>();

			// Criando um objeto do tipo cliente
			Cliente cli = new Cliente();
			cli.setNome("Alexandre");
			cli.setSobrenome("Carlos");
			cli.setDataNasc("1975-12-21");
			cli.setGenero('m');
			cli.setTelefone("(11) 97845-6325");
			// Adicionando na lista
			lista.add(cli);

			// ADICIONANDO UM NOVO REGISTRO
			// Criando um objeto do tipo cliente
			cli = new Cliente();
			cli.setNome("Julia");
			cli.setSobrenome("Alberto");
			cli.setDataNasc("1982-04-03");
			cli.setGenero('f');
			cli.setTelefone("(48) 97568-1245");
			// Adicionando na lista
			lista.add(cli);

			// ADICIONANDO UM NOVO REGISTRO
			// Criando um objeto do tipo cliente
			cli = new Cliente();
			cli.setNome("Jorge");
			cli.setSobrenome("Matheus");
			cli.setDataNasc("1965-02-18");
			cli.setGenero('m');
			cli.setTelefone("(12) 98569-1245");
			// Adicionando na lista
			lista.add(cli);
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DETERMINANDO A ORIGEM DA REQUISIÇÃO

		System.out.println("origem do request : " + request.getRequestURI());

		if (request.getRequestURI().equals("/cadastro-01/cliente")) {

			// RECEPÇÃO DOS DADOS DO REQUEST - INÍCIO

			// Receber os dados do request utilizando o método
			// getParameter(nomeDoCampo) e adicionando em um objeto do tipo Cliente.

			// Criar uma instância de Cliente
			Cliente cli = null;
			// Criar o objeto e adicionar os dados do request.
			cli = new Cliente();
			cli.setNome(request.getParameter("txtNm"));
			cli.setSobrenome(request.getParameter("txtSnm"));
			cli.setDataNasc(request.getParameter("txtDtNasc"));
			cli.setGenero(request.getParameter("txtGen").charAt(0));
			cli.setTelefone(request.getParameter("txtTel"));

			// Adicionando na lista
			lista.add(cli);

			// RECEPÇÃO DOS DADOS DO REQUEST - FIM

			// Adicionando os dados/lista no atributo do request
			// utilizando o método setAttribute(nomeAtributo, Objeto)<-- Onde Objeto é o que
			// armazenado no atributo.
			request.setAttribute("listaCli", lista);

			// ENCAMINHAMENTO DO REQUEST/RESPONSE - INÍCIO

			// Criar o Dispatcher através da interface RequestDispatcher
			// que vai receber o target do request, onde o TARGET é uma URI/URL.
			RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");

			// Devemos encaminhar de fato o
			// request e response através do método forward.
			rd.forward(request, response);

			// ENCAMINHAMENTO DO REQUEST/RESPONSE - FIM
		}else if (request.getRequestURI().equals("/cadastro-01/listar")) {
			
			//Parâmetro retornado de pesquisa do cliente
			int id = Integer.parseInt(request.getParameter("id-cli"));
			
			//Manipular a lista de clientes através de um for
			for(int x = 0; x < lista.size() ; x++) {
				if(x == (id-1)) {
					//Adicionamos o item da lista no atributo do request.
					request.setAttribute("cliObj", lista.get(x));
					//Realizando o processo de encaminhamento.
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			
			
		}

	}

}
