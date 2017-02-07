<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	window.onload = function() {
		new dgCidadesEstados(document.getElementById('estado'), document
				.getElementById('cidade'), true);
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="conteudo">

		<script type="text/javascript">
			nome()
		</script>
		<form action="<c:url value="/bairro/login"/>" method="Post"
			name="form1">
			<fieldset>
				<legend>Bairro na Sessão</legend>
				<label>Estado</label> <select id="estado" name="estado"></select> <label>Cidade</label>
				<select id="cidade" name="cidade"></select> <label> Bairro:</label>
				<select name="bairro.nome">
					<c:forEach items="${bairroList}" var="bairro">
						<option value="${bairro.nome}">${bairro.nome}</option>
					</c:forEach>
				</select>
			</fieldset>
			<button type="submit" onclick="bairro()">Entrar</button>
		</form>
	</div>
</body>
</html>