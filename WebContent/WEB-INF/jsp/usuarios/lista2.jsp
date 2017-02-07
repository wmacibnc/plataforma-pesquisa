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
		<h3>Dados Alterados com Sucesso!</h3>
		
		<table>
		<tr>
		<td>Nome</td>
		<td>Data Nascimento</td>
		<td>E-mail</td>
		<td>Telefone Residencial</td>
		<td>Telefone Celular</td>
		<td>Telefone Comercial</td>
		<td>Endereço</td>
		<td>Bairro</td>
		<td>Cidade</td>
		<td></td>
		<td></td>
		</tr>
				
		<c:forEach items="${usuarioList}" var="usuario">
		<c:if test="${usuarioWeb.id == usuario.id}">
		<tr>
		<td>${usuario.nome}</td>
		<td>${usuario.datanasc}</td>
		<td>${usuario.email}</td>
		<td>${usuario.telefoneResidencial}</td>
		<td>${usuario.telefoneCelular}</td>
		<td>${usuario.telefoneComercial}</td>
		<td>${usuario.endereço}</td>
		<td>${usuario.bairro.nome}</td>
		<td>${usuario.bairro.cidade.nome} - ${usuario.bairro.cidade.estado.sigla}</td>
		<td></td>
		<td></td>
		</tr>
		</c:if>
		</c:forEach>
		</table>
		
		<a href="<c:url value="/administracao/usuario"/>">Voltar para Administração</a>
	
</div>
</body>
</html>