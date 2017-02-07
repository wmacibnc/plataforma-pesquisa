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
	<h3>Empresa: ${empresaWeb.fantasia} - Softsol</h3>
	<br />
<h3> Entre com o nome do produto que deseja buscar</h3>
			<form action="<c:url value="/produtoEmpresa/busca4"/>">
	<input id="buscaprodutoEmpresa" name="nome" align="middle" size="40" />
			<script type="text/javascript">
				$("#buscaprodutoEmpresa").puts("Busca produtos por nome");
				$("#buscaprodutoEmpresa").autocomplete(
						'<c:url value="/produtoEmpresa/busca3.json"/>', {
							dataType : "json",
							parse : function(produtoEmpresa) {
								return $.map(produtoEmpresa, function(produtoEmpresa) {
									return {
										data : produtoEmpresa,
										value : produtoEmpresa.nome,
										result : produtoEmpresa.nome
									};
								});
							},
							formatItem : function(produtoEmpresa) {
								return produtoEmpresa.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>		
<display:table  class="displaytag.css" id="produtoEmpresa" name="${produtoEmpresaList}" pagesize="5" size="resultSize" requestURI="/produtoEmpresa/empresa?id=${empresaWeb.id }">
<display:column title="Imagem" sortable="true"><img src="<c:url value="/subgrupo/${produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120"/></display:column>
<display:column property="produto.nome" title="Empresa" sortable="true"/>
<display:column property="quantidade_estoque" title="Quant" sortable="true"/>
<display:column format="R$ {0, number, #,##0.00}" property="preco" title="Preço" sortable="true"/>
<display:column title="Ativo" sortable="true"><c:if test="${produtoEmpresa.ativo==1}"> Sim</c:if> <c:if test="${produtoEmpresa.ativo!=1}">Não</c:if> 
</display:column><display:column title="Editar"><a href="<c:url value="/produtoEmpresa/softsol/${produtoEmpresa.id}"/>">Editar</a></display:column>
<display:column title="Remover"><form action="<c:url value="/produtoEmpresa/softsol/${produtoEmpresa.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>

</display:table>
	</div>
</body>
</html>