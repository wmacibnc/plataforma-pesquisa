<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		<h3>Menor Preço - Cidade: ${cidadeWeb.nome}</h3>
			<a href="<c:url value="/"/>"> <img alt="Compre Sempre"
			src="<c:url value="/imagens/logo.png"/>" align="left"></a>
			
		<c:forEach items="${produtoEmpresaList}" var="produtoEmpresa">
			<p>Produto: ${produtoEmpresa.produto.nome}</p>
			<p><img src="<c:url value="/subgrupo/${produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120" /></p>
			
			<p>Preço:<fmt:formatNumber type="currency" value=" ${produtoEmpresa.preco}"/></p>
			
			<p>Empresa: ${produtoEmpresa.empresa.fantasia}</p>
			<p>Bairro: ${produtoEmpresa.empresa.bairro.nome}</p>
			<p>Cidade: ${produtoEmpresa.empresa.bairro.cidade.nome}</p>
			<p>Estado: ${produtoEmpresa.empresa.bairro.cidade.estado.nome}</p>
		<c:if test="${orcamentoEmProgresso==null}">
<a href="<c:url value="/orcamento/novo"/>">Fazer Orçamento</a>
			</c:if>
		<c:if test="${orcamentoEmProgresso!=null}">
		<form id="itemForm" action="<c:url value="/item"/>" method="POST">
			<fieldset>
				<legend>Adicionar Item ao seu Orçamento</legend>
				<p>
					<fieldset>
					<legend>Orçamento Número: ${orcamentoEmProgresso.orcamento.id} </legend>  
					<label for="qtd">Quantidade:</label>
					 <input type="text" name="item.quantidade" value="${item.quantidade}" />
					  
					 <label	for="precoUnit">Preço Unitário:<fmt:formatNumber type="currency" value=" ${produtoEmpresa.preco}"/></label>
					  
					 <input type="hidden" name="item.preco_unit" value="${produtoEmpresa.preco}" /> 
					 <!--<input	type="hidden" name="item.preco_total" value="${produtoEmpresa.preco * item.quantidade}" />--> 
					 <input	type="hidden" name="item.produtoEmpresa.id"	value="${produtoEmpresa.id}" /> 
					 <input type="hidden" name="item.orcamento.id" value="${orcamentoEmProgresso.orcamento.id }">
					<button type="submit">Salvar</button>
					<button type="reset">Limpar</button>
					</fieldset>
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
		</c:if>
		</c:forEach>
		<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
	</div>
</body>
</html>