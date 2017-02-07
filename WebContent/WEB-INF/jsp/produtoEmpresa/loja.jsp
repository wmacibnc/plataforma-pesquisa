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
	
	<c:if test="${orcamentoEmProgresso==null}">
	<p>Para buscar produtos, você precisa estar com orçamento ativo.</p>
	<p>
	<a href="<c:url value="/orcamento/novo"/>">
	Clique aqui para iniciar um orçamento!</a>
	</p>
			</c:if>
			<c:if test="${orcamentoEmProgresso!=null}">
			<h3>Orcamento Nº ${orcamentoEmProgresso.orcamento.id }</h3>
			<h3> Entre com o nome do produto que deseja buscar</h3>
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
			<button>Pesquisar</button>
		</form>		
		</c:if>		
	</div>
</body>
</html>