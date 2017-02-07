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
		<form id="atividadeForm" action="<c:url value="/atividade"/>"
			method="POST">
			<fieldset>
				<legend>Adicionar Atividade</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				<label for="nome">Nome:</label> <input type="text"
					name="atividade.nome" value="${atividade.nome}" />
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
			</fieldset>
		</form>
		<!-- Validação do Formulário com JavaScript-->
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