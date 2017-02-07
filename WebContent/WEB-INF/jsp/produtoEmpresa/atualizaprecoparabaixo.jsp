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
	<h3>Empresa: ${empresaWeb.fantasia}</h3>
	<h3>Preços com seus Reajustes</h3>
	<label>Precisamos da sua confirmação, para reajustar. Entre em contato com <b>sac@softsol.com.br</b></label>
	<br />
<display:table  class="displaytag.css" id="produtoEmpresa" export="true" name="${produtoEmpresaList}" pagesize="5" size="resultSize" requestURI="/produtoEmpresa/decrescimo">
<display:column title="Imagem" sortable="true"><img src="<c:url value="/subgrupo/${produtoEmpresa.produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120"/></display:column>
<display:column property="produto.nome" title="Empresa" sortable="true"/>
<display:column format="R$ {0, number, #,##0.00}" property="preco" title="Preço" sortable="true"/>
<display:column title="Ativo" sortable="true"><c:if test="${produtoEmpresa.ativo==1}"> Sim</c:if> <c:if test="${produtoEmpresa.ativo!=1}">Não</c:if> </display:column>
</display:table>

	</div>
</body>
</html>