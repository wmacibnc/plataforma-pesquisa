<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="conteudo">
		<form id="orcamentoForm"
			action="<c:url value="/orcamento/${orcamento.id }"/>" method="POST">
			<fieldset>
				<legend>Editar Atividade</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="data">Data:</label><label for="data">${orcamento.data_cadastro}</label>
				<label for="hora">Hora:</label><label for="hora">${orcamento.hora_cadastro}</label>
				<input type="hidden" name="orcamento.hora_cadastro"
					value="${orcamento.hora_cadastro}" /> <input type="hidden"
					name="orcamento.data_cadastro" value="${orcamento.data_cadastro}" />
				<label for="usuario">Usuário:</label> <input type="text"
					name="orcamento.usuario.id" value="${orcamento.usuario.id}" />
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
	</div>
</body>
</html>