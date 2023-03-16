<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>CADASTRO</title>
</head>
<body>

	<header>
		<nav>
			<ul class="nav">
				<li class="nav-link"><a href="index.jsp">Início</a></li>
				<li class="nav-link"><a href="listaall">Clientes</a></li>
   			</ul>
		</nav>
	</header>
	<div>
		<h2>${param.msgStatus}</h2>
	</div>
	<section>
		<form action="cliente" method="POST">
			<fieldset>
				<legend>Cadastro de Clientes</legend>
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm">Nome
						Cliente</label>
					<div class="col-sm-8">
						<input type="text" name="txtNm" id="idNm"
							placeholder="Digite seu nome" required="required"
							class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm">Sobrenome</label>
					<div class="col-sm-8">
						<input type="text" name="txtSnm" id="idSnm"
							placeholder="Digite seu sobrenome" required="required"
							class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc">Data Nascimento</label>
					<div class="col-sm-8">
						<input type="date" name="txtDtNasc" id="idDtNasc"
							required="required" class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idGen">Gênero</label>
					<div class="col-sm-8">
						<select name="txtGen" id="idGen" required="required" class="form-control">
							<option value="0" selected="selected">Selecione uma opção.</option>
							<option value="m">Masculino</option>
							<option value="f">Feminino</option>
							<option value="o">Outros</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idTel">Telefone</label>
					<div class="col-sm-8">
						<input type="tel" name="txtTel" id="idTel"
							placeholder="(xx) xxxxxx-xxxx" required="required"
							class="form-control" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" value="">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success btn-lg">Cadastrar</button>
					</div>
				</div>
			</fieldset>
		</form>
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>