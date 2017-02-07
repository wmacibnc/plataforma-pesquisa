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

		<form id="cidadeForm" action="<c:url value="/cidade"/>" method="POST">
			<fieldset>
				<legend>Adicionar Cidade</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				<label for="estado">Estado:</label> <select name="cidade.estado.id">
					<c:forEach items="${estadoList}" var="estado">
						<option value="${estado.id}">${estado.nome}</option>
					</c:forEach>
				</select> <label for="nome">Nome:</label> <input type="text"
					name="cidade.nome" value="${cidade.nome}" /> <label for="codigo">Codigo:</label>
				<input type="text" name="cidade.codigo" value="${cidade.codigo}" />
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#cidadeForm').validate({
				rules : {
					"cidade.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>