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
	<h3>Adicionar Produtos ao Compre Sempre</h3>
	<h4>Nome do Produto</h4>
		<form action="<c:url value="/produto/busca3"/>">
			<input id="buscaproduto" name="nome" size="40" />
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
			<button>Pesquisar</button>
		</form>

	</div>
</body>
</html>