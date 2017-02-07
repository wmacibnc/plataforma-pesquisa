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
	<h3>Lista Geral de Produtos</h3>
	<h4>Buscar produtos</h4>
	<form action="<c:url value="/produto/busca"/>">
	<input id="buscaproduto" name="nome" />
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
		</form>
		<display:table class="displaytag.css" id="produto" export="true"
			name="${produtoList}" pagesize="18" size="resultSize"
			requestURI="/produto">
			<display:column property="id" title="Cód" sortable="true" />
			<display:column property="subgrupo.nome" title="Subgrupo"
				sortable="true" />
			<display:column property="nome" title="Nome" sortable="true" />
			<display:column property="fabricante" title="Fabricante"
				sortable="true" />
			<display:column property="data" title="Data" sortable="true" />
			<display:column property="ncmsh" title="NCM_SH" sortable="true" />
			<display:column property="codantigo" title="Código Softsol"
				sortable="true" />
			<display:column title="Editar">
				<a href="<c:url value="/produto/${produto.id}"/>">Editar</a>
			</display:column>
			<display:column title="Editar">
				<form action="<c:url value="/produto/${produto.id}"/>" method="POST">
					<button class="link" name="_method" value="DELETE">Remover</button>
				</form>
			</display:column>
		</display:table>
	</div>
</body>
</html>