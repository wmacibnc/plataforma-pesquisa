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
		<form id="produtoForm"
			action="<c:url value="/produto/${produto.id }"/>" method="POST">
			<fieldset>
				<legend>Edita Produto</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="data">Data Cadastro:</label><label for="data">${produto.data}</label>
				<label for="data">Código antigo:</label><label for="data">${produto.codantigo}</label>
				
				<label for="subgrupo">Subgrupo:</label>
				 <select	name="produto.subgrupo.id">
					<c:forEach items="${subgrupoList}" var="subgrupo">
						<option value="${subgrupo.id}">${subgrupo.nome}</option>
					</c:forEach>
				</select>
				
				<input type="hidden" name="produto.data" value="${produto.data}">
				<input type="hidden" name="produto.codantigo" value="${produto.codantigo}">
				 
				<label for="nome">Nome:</label>
				<input type="text" name="produto.nome" value="${produto.nome}" />
				 
				<label for="fabricante">Fabricante:</label> 
				<input id="fabricante" type="text" name="produto.fabricante" value="${produto.fabricante}" />
				
				<label for="ncm">NCM:</label> 
				<input id="ncm" type="text"	name="produto.ncmsh" value="${produto.ncmsh}" />
				
				<label for="extipi"> Ex. Tipi</label>
						<input id="extipi" type="text" name="produto.extipi" value="${produto.extipi}" />
						
					<label for="genero"> Gênero</label>
						<input id="genero" type="text" name="produto.genero" value="${produto.genero}" />
						
					<label for="CodigoFiscalOperacoesPrestacoes"> Código Fiscal de Operações e Prestações </label>
					
					<select name="produto.codigofiscaloperacoesprestacoes.id">
				 	<c:forEach items="${codigoFiscalOperacoesPrestacoesList}" var="codigoFiscalOperacoesPrestacoes">
						<option value="${codigoFiscalOperacoesPrestacoes.id}">${codigoFiscalOperacoesPrestacoes.nome}</option>
					</c:forEach>
					</select>
				
					<label for="Fornecedor"> Fornecedor </label>
					<select name="produto.fornecedor.id">
				 	<c:forEach items="${fornecedorList}" var="fornecedor">
						<option value="${fornecedor.id}">${fornecedor.nome}</option>
					</c:forEach>
					</select>
					
					<label for="Tipo de Produto"> Tipo de Produto </label>
					<select name="produto.tipoproduto.id">
				 	<c:forEach items="${tipoProdutoList}" var="tipoProduto">
						<option value="${tipoProduto.id}">${tipoProduto.nome}</option>
					</c:forEach>
					</select>
				<button type="submit" name="_method" value="PUT">Enviar</button>
			</fieldset>
		</form>
	</div>
</body>
</html>