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

		<form action="<c:url value="/cidade/login"/>" method="Post"
			name="form1">
			<fieldset>
				<legend>Cidade na Sessão</legend>
				<label>Cidade:</label> <select name="cidade.nome">
					<c:forEach items="${cidadeList}" var="cidade">
						<option value="${cidade.nome}">${cidade.nome}</option>
					</c:forEach>
				</select>
			</fieldset>
			<button type="submit">Entrar</button>
		</form>
	</div>

</body>
</html>