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
	
		<form action="<c:url value="/login"/>" method="POST">
			<fieldset>
				<legend>Efetue o login - Usuário</legend>
				<img width="250" height="150" align="left" alt="edita" src="<c:url value="/imagens/paginas/usuario.gif"/>">
				<p></p>
				<label for="login">Login:</label> 
				<input id="login" type="text"name="usuario.login" />
				 <label for="senha">Senha:</label> <input id="senha" type="password" name="usuario.senha" />
				<button type="submit">Login</button>
			</fieldset>
	</form>
	
	<h3>Não tem Cadastro ainda?</h3>
	<h3>Leva menos de 1 minuto</h3>
	<a href="<c:url value="/usuarios/novo"/>">Novo usuário</a>
	</div>
</body>
</html>