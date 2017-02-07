<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/javascripts/jquery-1.3.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/javascripts/jquery.validate.min.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="conteudo">
		<form id="estadoForm" action="<c:url value="/estado"/>" method="POST">
			<fieldset>
				<legend>Adicionar Estado</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				<label for="nome">Nome:</label> <input type="text"
					name="estado.nome" value="${estado.nome}" /> <label for="sigla">Sigla:</label>
				<input type="text" name="estado.sigla" value="${estado.sigla}" />

				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#estadoForm').validate({
				rules : {
					"estado.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>