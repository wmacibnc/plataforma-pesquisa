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
		<form id="tipoProdutoForm" action="<c:url value="/tipoProduto"/>"	method="POST">
			
			<fieldset>
			
				<legend>Adicionar Tipo de Produto</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				
				<label for="nome">Nome:</label> 
					<input id="nome" type="text" name="tipoProduto.nome" value="${tipoProduto.nome}" />
					 
								<button type="submit">Salvar</button>
								<button type="reset">Limpar</button>
			</fieldset>
			
		</form>
		<script type="text/javascript">
			$('#tipoProdutoForm').validate({
				rules : {
					"tipoProduto.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>