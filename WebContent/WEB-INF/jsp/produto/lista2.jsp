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
	<display:table  class="displaytag.css" id="produto" name="${produtoList}" pagesize="5" size="resultSize" requestURI="/produto2">  
    <display:column property="subgrupo.nome" title="Subgrupo"/>
    <display:column title="Imagem" ><img src="<c:url value="/subgrupo/${produto.subgrupo.id}/imagem"/>" width="120" height="120" /></display:column>
    <display:column property="nome" title="Nome" />
    <display:column property="fabricante" title="Fabricante" />
    <display:column title="Menor Preço - Cidade"><a href="<c:url value="/produtoEmpresa/menorpreco/cidade/${produto.id}/${cidadeWeb.id}"/>">Menor Preço (Cidade)</a></display:column>
    <c:if test="${bairroWeb!=null}">
    <display:column title="Menor Preço - Bairro"><a href="<c:url value="/produtoEmpresa/menorpreco/bairro/${produto.id}/${bairroWeb.id}"/>">Menor Preço (Bairro)</a></display:column>
    <display:footer><a href="<c:url value="/produto/novo"/>">Adicionar</a></display:footer>
    </c:if>
    </display:table>
    <div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
	</div>
</body>
</html>