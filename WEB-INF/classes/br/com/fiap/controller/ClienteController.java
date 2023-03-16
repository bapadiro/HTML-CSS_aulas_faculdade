package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns =  {"/cliente","/listaall","/listar", "/update", "/excluir"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Request do FORM da index.jsp
		if (request.getRequestURI().equals("/cadastro-01/cliente")) {
			//Realizando a chamada para o m�todo inserirCliente
			// e passando os pr�metros request e response.
			inserirCliente(request, response);
		}else if(request.getRequestURI().equals("/cadastro-01/listaall")) {
			listarCliente(request, response);
		}else if(request.getRequestURI().equals("/cadastro-01/listar")) {
			listarCliente(request, response, Integer.parseInt(request.getParameter("id_cli")));
		}else if(request.getRequestURI().equals("/cadastro-01/update")) {
			atualizarCliente(request, response);
		}else if(request.getRequestURI().equals("/cadastro-01/excluir")) {
			excluirCliente(request, response);
		}
				
	}
	
	//APAGANDO CLIENTE
	private void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.apagaCliente(Integer.parseInt(request.getParameter("id_cli")));
		
		//Verifica��o do resultado para gerar uma mensagem 
		// para o usu�rio.
		if(resultado == 1) {

			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Registro excluído com SUCESSO!");
		}else {
			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar EXCLUIR o registro.");
		}

	}

	//ATUALIZANDO UM CLIENTE
	private void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Recuperando os dados do request e adicionando em um objeto.
		Cliente cli = null;
		cli = new Cliente();
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.atualizaCliente(cli, Integer.parseInt(request.getParameter("txtIdCli")));
		
		//Verifica��o do resultado para gerar uma mensagem 
		// para o usu�rio.
		if(resultado == 1) {

			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram ATUALIZADOS com SUCESSO!");
		}else {
			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar ATUALIZAR os dados.");
		}
				
	}

	//LISTANDO CLIENTE BY ID
	private void listarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws ServletException, IOException {
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		Cliente cli = cb.listagemCliente(idCli);
		
		if(cli != null) {
			//Criando um atributo no request  com o ObjCliente
			request.setAttribute("objCli", cli);
			request.setAttribute("objIdCli", idCli);
			
			//Realizar o encaminhamento para a p�gina atualiza.jsp.
			request.getRequestDispatcher("atualiza.jsp").forward(request, response);
		}else{
			//Criando um par�metro no com uma mensagem de erro para a p�gina JSP index.
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro com a sele��o atual.");
		}

	}

	//INSERINDO UM CLIENTE
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperando os dados do request e adicionando em um objeto.
		Cliente cli = null;
		cli = new Cliente();
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		System.out.println("TESTE : " + cli.getNome());
		
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.cadastroCliente(cli);
		
		//Verifica��o do resultado para gerar uma mensagem 
		// para o usu�rio.
		if(resultado == 1) {
			//Criando um atributo no request e enviando para a index.jsp
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
			
			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");
		}else {
			//Caso ocorra algum problema envie uma mensagem de erro.
			//request.setAttribute("msgStatus", "Ocorreu um erro ao gravar os dados.");
			
			//Criando um redirecionamento com par�metros.
			//Obs:Para carregar par�metros no JSP � necess�rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao gravar os dados.");
		}
		
		//REALIZANDO O ENCAMINHAMENTO.
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//LISTANDO TODOS OS CLIENTES
	public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		List<Cliente> lista = cb.listagemCliente();
		
		if(lista != null) {
			//Criando um atributo no request  com a lista de clientes
			request.setAttribute("lista_cli", lista);
			
			//Realizar o encaminhamento para a p�gina lista.jsp para carregar a lista de clientes.
			request.getRequestDispatcher("/WEB-INF/lista.jsp").forward(request, response);
		}else{
			//Criando um par�metro no com uma mensagem de erro para a p�gina JSP index.
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro com a listagem dos clientes!");
		}
	}

	
	
}
