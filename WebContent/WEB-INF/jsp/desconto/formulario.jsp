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
		<form id="descontoForm" action="<c:url value="/desconto"/>"	method="POST">
			
			<fieldset>
			
				<legend>Adicionar Desconto</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				
				<label for="nome">Nome:</label> 
					<input id="nome" type="text" name="desconto.nome" value="${desconto.nome}" />
					 
						<label for="valor">Valor:</label>
							<input id="valor" type="text" name="desconto.valor" value="${desconto.valor}" />
							
								<input type="hidden" name="desconto.empresa.id" value="${empresaWeb.id}">
							
								<button type="submit">Salvar</button>
								<button type="reset">Limpar</button>
			</fieldset>
			
		</form>
		<script type="text/javascript">
			$('#descontoForm').validate({
				rules : {
					"desconto.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>