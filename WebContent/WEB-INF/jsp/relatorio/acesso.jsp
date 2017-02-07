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
<display:table  class="displaytag.css" id="menorPreco" export="true" name="${menorPrecoList}" pagesize="25" size="resultSize" requestURI="/relatorio/menorPreco">  
    <display:column property="empresa" title="Empresa" sortable="true"/>  
    <display:column property="produto" title="Produto" sortable="true"/>
    <display:column property="localidade" title="Localidade" sortable="true"/>
    <display:column property="tipo" title="Tipo" sortable="true"/>
</display:table>		
	</div>
</body>
</html>