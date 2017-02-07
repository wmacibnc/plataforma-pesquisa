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

		<form id="cidadeForm" action="<c:url value="/cidade/${cidade.id }"/>"
			method="POST">
			<fieldset>
				<legend>Editar Cidade</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="estado">Estado:</label><label for="estado">${cidade.estado.nome}</label>
				<input type="hidden" name="cidade.estado.id"
					value="${cidade.estado.id}"> <label for="nome">Nome:</label>
				<input type="text" name="cidade.nome" value="${cidade.nome}" /> <label
					for="codigo">Codigo:</label> <input type="text"
					name="cidade.codigo" value="${cidade.codigo}" />

				<button type="submit" name="_method" value="PUT">Salvar</button>
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