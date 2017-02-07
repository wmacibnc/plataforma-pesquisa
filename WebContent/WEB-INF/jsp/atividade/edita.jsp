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
		<form id="atividadeForm"
			action="<c:url value="/atividade/${atividade.id }"/>" method="POST">
			<fieldset>
				<legend>Editar Atividade</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="nome">Nome:</label> <input type="text"
					name="atividade.nome" value="${atividade.nome}" />
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#atividadeForm').validate({
				rules : {
					"atividade.nome" : {
						required : true,
						minlength : 3,
						maxlenght : 100,
					}
				}
			});
		</script>
	</div>
</body>
</html>