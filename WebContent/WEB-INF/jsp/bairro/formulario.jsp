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
		<form id="bairroForm" action="<c:url value="/bairro"/>" method="POST">
			<fieldset>
				<legend>Adicionar Bairro</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				<label for="cidade">Cidade:</label> <select name="bairro.cidade.id">
					<c:forEach items="${cidadeList}" var="cidade">
						<option value="${cidade.id}">${cidade.nome}</option>
					</c:forEach>
				</select> <label for="nome">Nome:</label> <input type="text"
					name="bairro.nome" value="${bairro.nome}" /> <label for="sigla">Código:</label>
				<input type="text" name="bairro.codigo" value="${bairro.codigo}" />
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
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