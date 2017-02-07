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
		<form id="formaPagamentoForm"
			action="<c:url value="/formaPagamento/${formaPagamento.id }"/>"
			method="POST">
			<fieldset>
				<legend>Editar Forma Pagamento</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
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
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
	</div>
</body>
</html>