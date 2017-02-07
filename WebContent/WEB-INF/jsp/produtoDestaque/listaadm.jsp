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
<display:table  class="displaytag.css" id="produtoDestaque" export="true" name="${produtoDestaqueList}" pagesize="5" size="resultSize" requestURI="/produtoDestaque/adm">
<display:column property="produto.nome" title="Produto" sortable="true"/>
<display:column title="Imagem" sortable="true"><img src="<c:url value="/subgrupo/${produtoDestaque.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120"/></display:column>
<display:column title="Remover"><form action="<c:url value="/produtoDestaque/${produtoDestaque.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
<display:footer>Remove somente o produto da lista de Produtos em Destaque</display:footer>
<display:footer><a href="<c:url value="/produto/destaque"/>">Adicionar</a></display:footer>
</display:table>
</div>
</body>
</html>