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
	<h3>Lista de Orçamentos - Usuário: ${usuarioWeb.nome}</h3>
		<display:table class="displaytag.css" id="orcamento" export="true"	name="${orcamentoList}" pagesize="25" size="resultSize"
		requestURI="/orcamento/usuario/${usuarioWeb.id}"	>
			<display:column property="id" title="Cód" sortable="true" />
			<display:column property="data_cadastro" title="Usuário" sortable="true" />
			<display:column> <a href="<c:url value="/orcamento/vizualizar/${orcamento.id}"/>">Visualizar</a></display:column>
		</display:table>
	</div>
</body>
</html>