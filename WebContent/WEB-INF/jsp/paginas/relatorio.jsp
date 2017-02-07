<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="conteudo" align="center">
<h4>Página de Relatórios</h4>
<h3>Usuários</h3>

<table cellspacing="30">
		<tr>
		
		<td>
		<a href="<c:url value="/relatorio/acesso"/>"> <img alt="Acessos" src="<c:url value="/imagens/paginas/pdf.gif"/>">Acessos</a>
		</td>
		
		<td>
		<a href="<c:url value="/relatorio/menorPreco"/>"> <img alt="Menor Preço" src="<c:url value="/imagens/paginas/pdf.gif"/>">Menor Preço</a>
		</td>
		
		<td>
		<a href="<c:url value="/relatorio/pesquisas"/>"> <img alt="Pesquisas" src="<c:url value="/imagens/paginas/pdf.gif"/>">Pesquisas</a>
		</td>
		
		</tr>
		</table>

</div>
</body>
</html>