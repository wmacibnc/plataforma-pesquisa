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
		<h3>Unidade de Estoque Cadastrados</h3>
		<form action="<c:url value="/unidadeEstoque/busca"/>">
			<input id="buscaunidadeEstoque" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscaunidadeEstoque").puts("Busca Unidade de Estoque");
				$("#buscaunidadeEstoque").autocomplete(
						'<c:url value="/unidadeEstoque/busca.json"/>', {
							dataType : "json",
							parse : function(unidadeEstoque) {
								return $.map(unidadeEstoque, function(unidadeEstoque) {
									return {
										data : unidadeEstoque,
										value : unidadeEstoque.nome,
										result : unidadeEstoque.nome
									};
								});
							},
							formatItem : function(unidadeEstoque) {
								return unidadeEstoque.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="unidadeEstoque" export="true" name="${unidadeEstoqueList}" pagesize="25" size="resultSize" requestURI="/unidadeEstoque">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="sigla" title="Sigla" sortable="true"/>
    <display:column property="unidadevenda" title="Unidade de Venda" sortable="true"/>
   <display:column title="Editar"><a href="<c:url value="/unidadeEstoque/${unidadeEstoque.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/unidadeEstoque/${unidadeEstoque.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/unidadeEstoque/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>