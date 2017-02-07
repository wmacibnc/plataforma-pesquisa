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
		<form id="bairroForm" action="<c:url value="/bairro/${bairro.id }"/>"
			method="POST">
			<fieldset>
				<legend>Editar Bairro</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="bairro">Bairro:</label><label for="bairro">${bairro.cidade.nome}</label>
				<label for="nome">Nome:</label> <input type="text"
					name="bairro.nome" value="${bairro.nome}" /> <label for="codigo">Código:</label>
				<input type="text" name="bairro.codigo" value="${bairro.codigo}" />
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#bairroForm').validate({
				rules : {
					"bairro.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>