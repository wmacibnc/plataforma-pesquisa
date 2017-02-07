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
	<form action="<c:url value="/produto/busca2"/>">
			<input id="buscaproduto" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscaproduto").puts("Busca produtos por nome");
				$("#buscaproduto").autocomplete(
						'<c:url value="/produto/busca.json"/>', {
							dataType : "json",
							parse : function(produto) {
								return $.map(produto, function(produto) {
									return {
										data : produto,
										value : produto.nome,
										result : produto.nome
									};
								});
							},
							formatItem : function(produto) {
								return produto.nome;
							}
						});
			</script>
			<img alt="" align="right" src="<c:url value="/imagens/paginas/itens.gif"/>">
			<button>Pesquisar</button>
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
				href="<c:url value="/orcamento/confirmar/${orcamentoEmProgresso.orcamento.id}"/>">Finalizar
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