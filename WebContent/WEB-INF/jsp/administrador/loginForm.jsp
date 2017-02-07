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
		<form name ="administradorForm" action="<c:url value="/administrador/login"/>" method="POST">
			<fieldset>
				<legend>Efetue o login - Administrador</legend>
				<img width="250" height="150" alt="edita" align="left" src="<c:url value="/imagens/paginas/admin.gif"/>">
				<p></p>
				<label for="login">Login:</label> 
				<input id="login" type="text"name="administrador.login" />
				 <label for="senha">Senha:</label> <input id="senha" type="password" name="administrador.senha" />
				<button type="submit">Login</button>
				<!-- Validação do Formulário com JavaScript-->
		<script type="text/javascript">
			$('#administradorForm').validate({
				rules : {
					"administrador.login" : {
						required : true,
					},
					"administrador.senha" : {
						required : true,
					}
				}
			});
		</script>
			</fieldset>
		</form>
	</div>
</body>
</html>