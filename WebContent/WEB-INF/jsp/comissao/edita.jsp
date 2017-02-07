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
		<form id="comissaoForm"
			action="<c:url value="/comissao/${comissao.id }"/>" method="POST">
			
			<fieldset>
				<legend>Editar Comissão</legend>
				
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				
				<label for="nome">Nome:</label> 
					<input id="nome" type="text" name="comissao.nome" value="${comissao.nome}" />
					 
						<label for="valor">Valor:</label>
							<input id="valor" type="text" name="comissao.valor" value="${comissao.valor}" />
				
				<button type="submit" name="_method" value="PUT">Salvar</button>
				<button type="reset">Limpar</button>
				
			</fieldset>
		</form>
		
		<script type="text/javascript">
			$('#comissaoForm').validate({
				rules : {
					"comissao.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>