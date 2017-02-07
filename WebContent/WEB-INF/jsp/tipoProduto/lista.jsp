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
		<h3>Tipos de Produtos Cadastrados</h3>
		<form action="<c:url value="/tipoProduto/busca"/>">
			<input id="buscatipoProduto" name="nome"size="60" />
			<script type="text/javascript">
				$("#buscatipoProduto").puts("Busca Tipo de Produto");
				$("#buscatipoProduto").autocomplete(
						'<c:url value="/tipoProduto/busca.json"/>', {
							dataType : "json",
							parse : function(tipoProduto) {
								return $.map(tipoProduto, function(tipoProduto) {
									return {
										data : tipoProduto,
										value : tipoProduto.nome,
										result : tipoProduto.nome
									};
								});
							},
							formatItem : function(tipoProduto) {
								return tipoProduto.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="tipoProduto" export="true" name="${tipoProdutoList}" pagesize="25" size="resultSize" requestURI="/tipoProduto">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column title="Editar"><a href="<c:url value="/tipoProduto/${tipoProduto.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/tipoProduto/${tipoProduto.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/tipoProduto/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>