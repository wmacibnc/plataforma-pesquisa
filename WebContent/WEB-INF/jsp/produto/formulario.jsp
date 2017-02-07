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
		<form id="produtoForm" action="<c:url value="/produto"/>"
			method="POST">
			<fieldset>
				<legend>Adicionar Produto</legend>
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<%
					Date dataAtual = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String dataStr = sdf.format(dataAtual);
				%>
				
				<input type="hidden" name="produto.data" value="<%=dataStr%>" /> 
							
				<label for="data">Data do Cadastro: <%=dataStr%></label>
				
				 <label for="subgrupo">Subgrupo:</label> 
				 <select name="produto.subgrupo.id">
				 	<c:forEach items="${subgrupoList}" var="subgrupo">
						<option value="${subgrupo.id}">${subgrupo.nome}</option>
					</c:forEach>
				</select>
				
				 <label for="nome">Nome:</label>
				  	<input id="nome" type="text" name="produto.nome" value="${produto.nome }" /> 
				  
				  <label for="fabricante">Fabricante:</label> 
				  		<input id="fabricante" type="text" name="produto.fabricante" value="${produto.fabricante}" />
				  	
					<label for="ncm">NCM_SH:</label> 
						<input id="ncm" type="text" name="produto.ncm" value="${produto.ncm}" /> 
						
					<label for="preco">Preço:</label>
						<input id="preco" type="text" name="produto.preco" value="${produto.preco}" />
						
					<label for="extipi"> Ex. Tipi</label>
						<input id="extipi" type="text" name="produto.extipi" value="${produto.extipi}" />
						
					<label for="genero"> Gênero</label>
						<input id="genero" type="text" name="produto.genero" value="${produto.genero}" />
						
					<label for="CodigoFiscalOperacoesPrestacoes"> Código Fiscal de Operações e Prestações - CFOP </label>
					
					<select name="produto.codigofiscaloperacoesprestacoes.id">
				 	<c:forEach items="${codigoFiscalOperacoesPrestacoesList}" var="codigoFiscalOperacoesPrestacoes">
						<option value="${codigoFiscalOperacoesPrestacoes.id}">${codigoFiscalOperacoesPrestacoes.nome}</option>
					</c:forEach>
					</select>
				
					<label for="Fornecedor"> Fornecedor </label>
					<select name="produto.fornecedor.id">
				 	<c:forEach items="${fornecedorList}" var="fornecedor">
						<option value="${fornecedor.id}">${fornecedor.deno_vin}</option>
					</c:forEach>
					</select>
					
					<label for="Tipo de Produto"> Tipo de Produto </label>
					<select name="produto.tipoproduto.id">
				 	<c:forEach items="${tipoProdutoList}" var="tipoProduto">
						<option value="${tipoProduto.id}">${tipoProduto.nome}</option>
					</c:forEach>
					</select>
						
				<button type="submit">Enviar</button>
				
				
				<script type="text/javascript">
					$('#produtosForm').validate({
						rules : {
							"produto.nome" : {
								required : true,
								minlength : 3
							},
							"produto.descricao" : {
								required : true,
								maxlength : 40
							},
							"produto.preco" : {
								min : 0.0
							}
						}
					});
				</script>
			</fieldset>
		</form>
	</div>
</body>
</html>