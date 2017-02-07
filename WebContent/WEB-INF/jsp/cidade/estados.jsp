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
	<h3>Escolha sua cidade</h3>
	<display:table  class="displaytag.css" id="cidade" name="${cidadeList}" pagesize="20" size="resultSize" requestURI="/estado/cidade">  
     <display:column property="estado.nome" title="Estado" sortable="true"/>  
    <display:column property="nome" title="Nome" sortable="true"/>
    <display:column title="Selecionar"><form action="<c:url value="/cidade/login"/>" method="Post"name="form1"><input type="hidden" name="cidade.nome" value="${cidade.nome}"><button type="submit">Selecionar</button></form></display:column>  
    </display:table>
	</div>
</body>
</html>