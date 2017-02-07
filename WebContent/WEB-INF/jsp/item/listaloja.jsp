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
<c:forEach items="${produtoEmpresaList}" var="produtoEmpresa" begin="1" end="1">
		<h2>Você está na Loja: ${produtoEmpresa.empresa.fantasia }</h2>
		<h3> Entre com o nome do produto que deseja buscar</h3>
		</c:forEach>
	
	<form action="<c:url value="/produtoEmpresa/busca2"/>">
	<input id="buscaprodutoEmpresa" name="nome" align="middle" size="40" />
			<script type="text/javascript">
				$("#buscaprodutoEmpresa").puts("Busca produtos por nome");
				$("#buscaprodutoEmpresa").autocomplete(
						'<c:url value="/produtoEmpresa/busca2.json"/>', {
							dataType : "json",
							parse : function(produtoEmpresa) {
								return $.map(produtoEmpresa, function(produtoEmpresa) {
									return {
										data : produtoEmpresa,
										value : produtoEmpresa.produto.nome,
										result : produtoEmpresa.produto.nome
									};
								});
							},
							formatItem : function(produtoEmpresa) {
								return produtoEmpresa.produto.nome;
							}
						});
			</script>
		</form>			

		<h3>Itens cadastrados</h3>
		<h3>Orçamento Número:${orcamentoEmProgresso.orcamento.id}</h3>
		<table>
			<thead>
				<tr>
					<th>Foto</th>
					<th>Produto</th>
					<th>Fabricante</th>
					<th>Preço Unit</th>
					<th>Qtd</th>
					<th>Valor Total</th>
					<th>Editar</th>
					<th>Remover</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itemList}" var="item">
					<c:if
						test="${orcamentoEmProgresso.orcamento.id==item.orcamento.id }">
						<tr>
							<td><img src="<c:url value="/subgrupo/${item.produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120" /></td>
							<td>${item.produtoEmpresa.produto.nome}</td>
							<td>${item.produtoEmpresa.produto.fabricante}</td>
							<td><fmt:formatNumber type="currency" value="${item.preco_unit}"/></td>
							<td>${item.quantidade}</td>
							<td><fmt:formatNumber type="currency" value="${item.preco_unit * item.quantidade }"/></td>
							<td><a href="<c:url value="/item/${item.id}"/>">Editar</a></td>
							<td><form action="<c:url value="/item/${item.id}"/>"
									method="POST">
									<button class="link" name="_method" value="DELETE">Remover</button>
								</form></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a
				href="<c:url value="/orcamento/confirmarloja/${orcamentoEmProgresso.orcamento.id}"/>">Finalizar
				Orçamento</a>
		</p>
		<p><b><font color="orange">Compre</font><font color="#6E6F73">Sempre</font></b> - Buscando para você o Melhor Preço.</p>
		<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
	</div>
</body>
</html>