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
		<c:forEach items="${menorPrecoList }" var="menor">
			<p>Menor Pre�o</p>
			<p>Empresa: ${menor.empresa}</p>
			<p>Produto:${menor.produto}</p>
			<p>Localidade:${menor.localidade}</p>
			<p>Tipo:${menor.tipo}</p>
		</c:forEach>
	</div>
</body>
</html>