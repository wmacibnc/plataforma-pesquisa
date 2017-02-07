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
	<form action="<c:url value="/produto/buscadestaque"/>">
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
		
	<display:table  class="displaytag.css" id="produto" name="${produtoList}" pagesize="5" size="resultSize" requestURI="/produto/destaque" export="true">  
    <display:column title="Imagem" ><img src="<c:url value="/subgrupo/${produto.subgrupo.id}/imagem"/>" width="120" height="120" /></display:column>
    <display:column property="nome" title="Nome"  sortable="true"/>
    <display:column title="Destaque"><form id="produtoDestaqueForm" action="<c:url value="/produtoDestaque"/>" method="POST"><input type="hidden" name="produtoDestaque.produto.id" value="${produto.id}"><button type="submit">Adicionar</button></form></display:column>
    </display:table>
	</div>
</body>
</html>