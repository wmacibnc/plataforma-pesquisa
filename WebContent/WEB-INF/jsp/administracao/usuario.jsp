<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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



<div id="login" align="center">
			<table cellspacing="30">
				<tr>
					<td>
					<form id="orcamentoForm" action="<c:url value="/orcamento"/>" method="POST">
			 		<input	type="hidden" name="orcamento.usuario.id" value="${usuarioWeb.id}" />
			 		<img alt="Fazer Orçamento" src="<c:url value="/imagens/paginas/orcamento.gif"/>">
			 		<p />
					<button type="submit">Fazer Orçamento</button>					
					</form>
					</td>
										
					<td>
					<a href="<c:url value="/usuarios/${usuarioWeb.id}"/>"> <img	alt="Alterar Dados"	src="<c:url value="/imagens/paginas/alterar.gif"/>"></a>
					<p /> <a href="<c:url value="/usuarios/${usuarioWeb.id}"/>">Alterar dados</a>
					</td>
					
					<td>
					<a href="<c:url value="/orcamento/usuario/${usuarioWeb.id }"/>"> <img	alt="Orçamentos"	src="<c:url value="/imagens/paginas/orcamento.gif"/>"></a>
					<p /><a href="<c:url value="/orcamento/usuario/${usuarioWeb.id}"/>">Orçamentos</a>
					</td>
					
				</tr>
			</table>
		</div>
	</div>
</body>
</html>