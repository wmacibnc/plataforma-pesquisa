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
		<form id="itemForm" action="<c:url value="/item"/>" method="POST">
			<fieldset>
				<legend>Adicionar Item ao seu Orçamento</legend>
				<p>
					Orçamento Número: ${orcamentoEmProgresso.orcamento.id} <label
						for="qtd">Quantidade:</label> <input type="text"
						name="item.quantidade" value="${item.quantidade}" /> <label
						for="precoUnit">Preço Unitário:</label> <input type="hidden"
						name="item.preco_unit"
						value="${item.produtoEmpresa.produto.preco}" /> <input
						type="hidden" name="item.preco_total"
						value="${item.produtoEmpresa.produto.preco*item.quantidade}" /> <input
						type="hidden" name="item.produtoEmpresa.id"
						value="${produtoEmpresa.id}" /> <input type="hidden"
						name="item.orcamento.id"
						value="${orcamentoEmProgresso.orcamento.id }">

					<button type="submit">Salvar</button>
					<button type="reset">Limpar</button>
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#itemForm').validate({
				rules : {
					"item.quantidade" : {
						required : true,
						number: true				
					},
					"item.preco_unit" : {
						required : true,
						number: true				
					},"item.preco_total" : {
						required : true,
						number: true				
					}
				}
			});
		</script>
	</div>
</body>
</html>