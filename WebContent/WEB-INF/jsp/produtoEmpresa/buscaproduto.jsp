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
		
		</c:forEach>
	<h3> Orçamento Nº ${orcamentoEmProgresso.orcamento.id }</h3>
	<h3> Entre com o nome do produto que deseja buscar</h3>
	<form action="<c:url value="/produtoEmpresa/busca2"/>">
	<input id="buscaprodutoEmpresa" name="nome" align="middle" size="20" />
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
			<button>Pesquisar</button>
		</form>				
		
		<display:table class="displaytag.css" id="produtoEmpresa" name="${produtoEmpresaList}" pagesize="5" size="resultSize" requestURI="/produtoEmpresa/busca2">
			<display:column title="Imagem" sortable="true">	<img src="<c:url value="/subgrupo/${produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120" />	</display:column>
			<display:column property="produto.nome" title="Produto"	sortable="true" />
			<display:column format="R$ {0, number, #,##0.00}" property="preco" title="Preço" sortable="true" />
			<display:column title="Quantidade" sortable="true">
			<c:if test="${orcamentoEmProgresso==null}">
	<p>Para buscar produtos, você precisa estar com orçamento ativo.</p>
	<p>
	<a href="<c:url value="/orcamento/novo"/>">
	Clique aqui para iniciar um orçamento!</a>
	</p>
			</c:if>
			<c:if test="${orcamentoEmProgresso!=null }">
			<form id="itemForm" action="<c:url value="/itemloja"/>" method="POST">
					 <input type="text" name="item.quantidade" size="5" value="${item.quantidade}" />
					  <input type="hidden" name="item.preco_unit" value="${produtoEmpresa.preco}" /> 
					  <input type="hidden" name="item.produtoEmpresa.id"	value="${produtoEmpresa.id}" /> 
					 <input type="hidden" name="item.orcamento.id" value="${orcamentoEmProgresso.orcamento.id }">
					<button type="submit"> Adicionar </button>			
		</form>
		</c:if>
			</display:column>
		</display:table>
	</div>

</body>
</html>