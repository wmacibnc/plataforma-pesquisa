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
		Lista Geral de Usuarios
	<display:table  class="displaytag.css" id="usuario" export="true" name="${usuarioList}" pagesize="25" size="resultSize" requestURI="/usuarios">  
     <display:column property="nome" title="Nome"  sortable="true"/>  
    <display:column property="login" title="Login" sortable="true"/>
    <display:column property="datanasc" title="datanasc" sortable="true"/>
    <display:column property="cpf" title="cpf" sortable="true"/>
    <display:column property="rg" title="rg" sortable="true"/>
    <display:column property="telefoneResidencial" title="Telefone Res." sortable="true"/>
    <display:column property="endereço" title="Endereco" sortable="true"/>
    <display:column property="bairro" title="Bairro" sortable="true"/>
    <display:column property="email" title="E-mail" sortable="true"/>
    </display:table>
</div>
</body>
</html>