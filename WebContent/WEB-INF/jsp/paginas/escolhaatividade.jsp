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
<h3>Escolha sua opção de busca</h3>
<p> No CompreSempre você deve especificar a atividade em que deseja fazer sua busca de produtos.
</p>
<h4>Buscar em:</h4>
<label>Escolha uma atividade abaixo.</label>
		<form id="Form" action="<c:url value="/atividadeEmProgresso"/>" method="get">
			<select name="atividade.id">
				<c:forEach items="${atividadeList}" var="atividade">
				
					<option value="${atividade.id}">${atividade.nome}</option>
				</c:forEach>
			</select>
			<button type="submit">Entrar</button>
		</form>

<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
</div>
</body>
</html>