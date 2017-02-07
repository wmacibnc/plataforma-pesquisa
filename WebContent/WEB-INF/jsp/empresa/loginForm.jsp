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
		<form action="<c:url value="/empresa/login"/>" method="Post"
			name="form1">
			<fieldset>
				<legend>Efetue o login - Empresa</legend>
				<img width="300" height="200" alt="edita" src="<c:url value="/imagens/paginas/empresa.gif"/>" align="left">
				
				<label for="login">Login:</label> <input id="login" type="text"
					name="empresa.login" /> <label for="senha">Senha:</label> <input
					id="senha" type="password" name="empresa.senha" />
				<button type="submit">Login</button>
			</fieldset>
		</form>
	</div>
</body>
</html>