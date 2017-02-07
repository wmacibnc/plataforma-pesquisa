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
		<form id="formaPagamentoForm"
			action="<c:url value="/formaPagamento"/>" method="POST">
			<fieldset>
				<legend>Adicionar Forma de Pagamento</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				<label for="nome">Nome:</label> <input type="text"
					name="formaPagamento.nome" value="${formaPagamento.nome}" /> <label
					for="parcelassemjuros">Parcelas sem Juros:</label> <input
					type="text" name="formaPagamento.parcelas_semjuros"
					value="${formaPagamento.parcelas_semjuros}" /> <label
					for="parcelascomjuros">Parcelas com Juros:</label> <input
					type="text" name="formaPagamento.parcelas_comjuros"
					value="${formaPagamento.parcelas_comjuros}" /> <label
					for="porcetagem">Porcetagem:</label> <input type="text"
					name="formaPagamento.porcetagem"
					value="${formaPagamento.porcetagem}" />
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#formaPagamentoForm').validate({
				rules : {
					"formaPagamento.nome" : {
						required : true,
						minlength : 3				
					},
					"formaPagamento.parcelas_semjuros" : {
						required : true,
						minlength : 3				
					},
					"formaPagamento.parcelas_comjuros" : {
						required : true,
						minlength : 3				
					},
					"formaPagamento.porcetagem" : {
						required : true,
						minlength : 3				
					}
					
				}
			});
		</script>
	</div>
</body>
</html>