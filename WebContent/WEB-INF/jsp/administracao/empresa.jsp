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
	<h3> Empresa Administração</h3>
	
	<h4>${empresaWeb.fantasia }</h4>
	
	<div id="login" align="center">
	<table cellspacing="40">
	<tr>
		<td>
		<a href="<c:url value="/produto/empresa"/>"> <img alt="Adicionar Produtos" src="<c:url value="/imagens/paginas/adicionar.gif"/>"></a>
		<p />
		<a href="<c:url value="/produto/empresa"/>"> Adicionar Produtos </a>
		</td>
		<td>
		<a href="<c:url value="/produtoEmpresa/empresa?id=${empresaWeb.id}"/>"> <img alt="Gerenciar Produtos" src="<c:url value="/imagens/paginas/gerenciar.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/produtoEmpresa/empresa?id=${empresaWeb.id}"/>"> Gerenciar Produtos</a>
		</td>
		<td>
		<a href="<c:url value="/empresa/porcentagem/${empresaWeb.id}"/>"> <img alt="Porcentagem da Loja" src="<c:url value="/imagens/paginas/desconto.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/empresa/porcentagem/${empresaWeb.id}"/>"> Porcentagem da Loja</a>
		</td>
	</tr>
	</table>
	</div>
	
	</div>
</body>
</html>