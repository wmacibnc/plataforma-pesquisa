<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function substituiVirgula(campo) {
campo.value = campo.value.replace(/,/gi, ".");
}
</script>
</head>
	<body>
	<div id="conteudo">

<h3>Empresa: ${empresaWeb.fantasia} Codigo: ${empresaWeb.id} (Softsol)</h3> 
<fieldset>
	<c:forEach items="${produtoList}" var="produto">
		<h4>Produto: ${produto.nome}</h4>
		
	<form action="<c:url value="/produtoEmpresa/softsol"/>" method="POST">
	<input type="hidden" name="produtoEmpresa.produto.id" value="${produto.id}"> 
	<input type="hidden" name="produtoEmpresa.empresa.id" value="${empresaWeb.id}">

	<table>
	
		<tr>
			<td>
				<label	for="quantidade">Quantidade em Estoque:</label>
					<input type="text" name="produtoEmpresa.quantidade_estoque"	value="${produtoEmpresa.quantidade_estoque}" />
			</td>
			<td>
				<label>IPI (%)</label>
					<input type="text" name="produtoEmpresa.ipiporcentagem" value="${produtoEmpresa.ipiporcentagem}" />
			</td>
			
		</tr>
		
		<tr>
			<td>
				<label for="preco">Preço de Venda:</label>
					<input type="text" onkeyup="substituiVirgula(this)" name="produtoEmpresa.preco" value="${produtoEmpresa.preco}" />
			</td>
			<td>
				<label>Margem de Lucro (%)</label>
					<input type="text" name="produtoEmpresa.margemdelucroporcentagem" value="${produtoEmpresa.margemdelucroporcentagem}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label for="codbarra">Código de barra:</label>
					<input type="text" name="produtoEmpresa.codbarra" value="${produtoEmpresa.codbarra}" />
			</td>
			<td>
				<label>Observação</label>
					<input type="text" name="produtoEmpresa.observacao" value="${produtoEmpresa.observacao}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label for="codprodutofabricante">Código do Produto(Fabricante):</label>
					<input type="text" name="produtoEmpresa.codprodutofabricante" value="${produtoEmpresa.codprodutofabricante}" />
			</td>
			<td>
				<label>Preço de Custo</label>
					<input type="text" name="produtoEmpresa.precocusto" value="${produtoEmpresa.precocusto}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Controla Estoque</label>
					<input type="checkbox" name="produtoEmpresa.controlaestoque" value="1" checked="checked">
			</td>
			<td>
				<label>Preço Faturado</label>
					<input type="text" name="produtoEmpresa.precofaturado" value="${produtoEmpresa.precofaturado}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Custo Líquido</label>
					<input type="text" name="produtoEmpresa.custoliquido" value="${produtoEmpresa.custoliquido}" />
			</td>
			<td>
				<label>Preço Venda no Atacado</label>
					<input type="text" name="produtoEmpresa.precovendaatacado" value="${produtoEmpresa.precovendaatacado}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Desconto na Nota Fiscal (%)</label>
					<input type="text" name="produtoEmpresa.descontonanotafiscalporcentagem" value="${produtoEmpresa.descontonanotafiscalporcentagem}" />
			</td>
			<td>
				<label>Preço Mínimo</label>
					<input type="text" name="produtoEmpresa.precovendaminimoepromocao" value="${produtoEmpresa.precovendaminimoepromocao}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Despesas Fixas</label>
					<input type="text" name="produtoEmpresa.despesasfixas" value="${produtoEmpresa.despesasfixas}" />
			</td>
			<td>
				<label>Quantidade de Venda</label>
					<input type="text" name="produtoEmpresa.quantidadedevenda" value="${produtoEmpresa.quantidadedevenda}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Despesas Váriaveis</label>
					<input type="text" name="produtoEmpresa.despesasvariaveis" value="${produtoEmpresa.despesasvariaveis}" />
			</td>
			<td>
				<label>Tributação</label>
					<input type="text" name="produtoEmpresa.tributacao" value="${produtoEmpresa.tributacao}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Frete (%)</label>
					<input type="text" name="produtoEmpresa.freteporcentagem" value="${produtoEmpresa.freteporcentagem}" />
			</td>
			<td>
				<label>Unidade de Consumo</label>
					<input type="text" name="produtoEmpresa.unidadeconsumo" value="${produtoEmpresa.unidadeconsumo}" />
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Gramatura</label>
					<input type="text" name="produtoEmpresa.gramatura" value="${produtoEmpresa.gramatura}" />
			</td>
			<td>
				<label>Código Situação Tributação</label>
				<select name="produtoEmpresa.codigoSituacaoTributacao.id">
				 	<c:forEach items="${codigoSituacaoTributacaoList}" var="codigoSituacaoTributacao">
						<option value="${codigoSituacaoTributacao.id}">${codigoSituacaoTributacao.nome} - ${codigoSituacaoTributacao.regimeTributacao.nome}</option>
					</c:forEach>
					</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<label>ICMS (%)</label>
					<input type="text" name="produtoEmpresa.icmsporcentagem" value="${produtoEmpresa.icmsporcentagem}" />
			</td>
			<td>
				<label>Comissão</label>
				<select name="produtoEmpresa.comissao.id">
				 	<c:forEach items="${comissaoList}" var="comissao">
						<option value="${comissao.id}">${comissao.nome}</option>
					</c:forEach>
					</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Impostosporcentagem</label>
					<input type="text" name="produtoEmpresa.impostosporcentagem" value="${produtoEmpresa.impostosporcentagem}" />
			</td>
			<td>
       			<label>Unidade de Estoque</label>
       			<select name="produtoEmpresa.unidadeEstoque.id">
				 	<c:forEach items="${unidadeEstoqueList}" var="unidadeEstoque">
						<option value="${unidadeEstoque.id}">${unidadeEstoque.nome}</option>
					</c:forEach>
					</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Imprimir Livro?</label>
					<input type="checkbox" name="produtoEmpresa.imprimilivro" value="1" checked="checked">
			</td>
			<td>
				<label>Ativo</label>
					<input type="checkbox" name="produtoEmpresa.ativo" value="1" checked="checked">
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="submit">Adicionar</button>
			</td>
		</tr>
		
	</table>
	</form>
	</c:forEach>
	</fieldset>
		</div>
	</body>
</html>
	