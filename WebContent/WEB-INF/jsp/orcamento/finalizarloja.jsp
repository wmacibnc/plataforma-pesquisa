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
	<img alt="email" align="left" src="<c:url value="/imagens/paginas/email.gif"/>">
	<h2>Mais um orçamento Compre Sempre Finalizado</h2>
	<p />
	<h3> Seu Orçamento foi Enviado!</h3>
		<c:forEach items="${orcamentoList}" var="orcamento">
			
			<p>E-mail</p>
			<br>
			
			<b>Orçamento Número : ${orcamento.id}</b> - 
			Data Orçamento: ${orcamento.data_cadastro} - 
			Hora do Orçamento: ${orcamento.hora_cadastro}
			<br> <br/>
			
			<p><b>Dados do Usuário</b></p>
			<p />
			<p>Usuário: ${orcamento.usuario.nome}</p>
			<p>E-mail: ${orcamento.usuario.email}</p>
			
			<p>Item (s) do Orçamento</p>
			<display:table  class="displaytag.css" id="item" export="true" name="${itemList}" pagesize="5" size="resultSize" requestURI="/vizualizar">  
    <display:column title="Imagem"  sortable="true"><img src="<c:url value="/subgrupo/${item.produtoEmpresa.produto.subgrupo.id}/imagem"/>" width="120" height="120"></display:column>  
    <display:column property="produtoEmpresa.produto.nome" title="Produto" sortable="true"/>
    <display:column property="preco_unit" format="R$ {0, number, #,##0.00}" title="Preço" sortable="true"/>
    <display:column property="quantidade" title="Qtd" sortable="true"/>
    <display:column title="Sub Total" sortable="true"> <fmt:formatNumber type="currency" value="${item.preco_unit * item.quantidade}"/></display:column>
        <display:column title="Empresa" sortable="true"><a href="<c:url value="/produtoEmpresa/loja?id=${item.produtoEmpresa.empresa.id }"/>">${item.produtoEmpresa.empresa.fantasia}</a></display:column>
    </display:table>
	</c:forEach>
<P><a href="<c:url value="/administracao/usuario"/>">Administração</a></P>
<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
</div>
</body>
</html>