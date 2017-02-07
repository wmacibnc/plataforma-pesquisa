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
			<table>
				<tr>
					<td><a href="<c:url value="/empresa/loginForm"/>"> <img
							alt="Login Empresa"
							src="<c:url value="/imagens/paginas/empresa.gif"/>"></a>
						<p /> <a href="<c:url value="/empresa/loginForm"/>"> Login
							Empresa </a></td>
					<td><a href="<c:url value="/usuarios/loginForm"/>"> <img
							alt="Login Usuário"
							src="<c:url value="/imagens/paginas/usuario.gif"/>" align="left"></a>
						<p /> <a href="<c:url value="/usuarios/loginForm"/>"> Login
							Usuário</a></td>
					<td><a href="<c:url value="/administracao"/>"> <img
							alt="Login Administrador"
							src="<c:url value="/imagens/paginas/admin.gif"/>" align="left"></a>
						<p /> <a href="<c:url value="/administracao"/>"> Softsol
							Administrador </a></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>