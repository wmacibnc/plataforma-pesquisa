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
		<form id="subgrupoForm" action="<c:url value="/subgrupo"/>"
			method="POST">
			<fieldset>
				<legend>Adicionar Subgrupo</legend>
				 <select name="subgrupo.grupo.id">
					<c:forEach items="${grupoList}" var="grupo">
						<option value="${grupo.id}">${grupo.nome}</option>
					</c:forEach>
				</select>
				
				<label for="nome">Nome:</label>
				<input id="subgrupo.nome" type="text" name="subgrupo.nome"/>
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
				</fieldset>
		</form>
	</div>
</body>
</html>