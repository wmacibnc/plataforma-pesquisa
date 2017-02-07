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
	<div id="formulario" align="center">
		<form id="administradorForm"	action="<c:url value="/administrador/${administrador.id }"/>" method="POST">
			<fieldset>
			<legend>Editar Administrador</legend>
				<p></p>
								
				<label for="nome">Nome:</label> 
				<input id="nome" type="text" name="administrador.nome" value="${administrador.nome}"/> 
				
				<label for="login">Login:</label> 
				<input id="login" type="text" name="administrador.login" value="${administrador.login}"/>
				
				<label for="senha">Senha:</label> 
				<input id="senha" type="text" name="administrador.senha" value="${administrador.senha}"/>
				
				<label for="email">E-mail:</label> 
				<input id="email" type="text" name="administrador.email" value="${administrador.email}"/>
							
				
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
		</div>
	</div>
</body>
</html>