<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		<form id="orcamentoForm" action="<c:url value="/orcamento"/>"
			method="POST">
			<input	type="hidden" name="orcamento.usuario.id" value="${usuarioWeb.id}" />
			<button type="submit">Fazer Or�amento</button>
		</form>
	</div>
</body>
</html>