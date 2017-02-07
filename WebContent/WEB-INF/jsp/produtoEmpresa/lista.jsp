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
<h3>Produto Empresa - Todos os produtos cadastrados</h3>
<display:table  class="displaytag.css" id="produtoEmpresa" export="true" name="${produtoEmpresaList}" pagesize="5" size="resultSize" requestURI="/produtoEmpresa">
<display:column property="empresa.fantasia" title="Empresa" sortable="true"/>
<display:column title="Imagem" sortable="true"><img src="<c:url value="/subgrupo/${produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120"/></display:column>
<display:column property="produto.nome" title="Produto" sortable="true"/>
<display:column property="quantidade_estoque" title="Quant" sortable="true"/>
<display:column  format="R$ {0, number, #,##0.00}" property="preco" title="Preço" sortable="true"/>
<display:column property="ativo" title="Ativo" sortable="true"/>
</display:table>
	</div>
</body>
</html>