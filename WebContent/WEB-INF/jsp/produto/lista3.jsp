<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function substituiVirgula(campo) {
campo.value = campo.value.replace(/,/gi, ".");
}
</script>
</head>
<body>
<div id="conteudo">

Empresa: ${empresaWeb.fantasia} Codigo: ${empresaWeb.id} - 

<display:table  class="displaytag.css" id="produto" name="${produtoList}" pagesize="3" size="resultSize" requestURI="/produto/empresa">

<display:column property="subgrupo.nome" title="Departamento" sortable="true"/>
<display:column title="Imagem" sortable="true"><img src="<c:url value="/subgrupo/${produto.subgrupo.id}/imagem"/>" align="left" width="120" height="120"/></display:column>
<display:column property="id" title="Cód" sortable="true"/>
<display:column property="nome" title="Nome - Descrição" sortable="true"/>
<display:column property="fabricante" title="Fabricante" sortable="true"/>
<display:column property="ncmsh" title="NCM_SH" sortable="true"/>
<display:column title="Preço  --- Quant --- Ativo ">
<form action="<c:url value="/produtoEmpresa"/>" method="POST">
Preço
<input type="text" onkeyup="substituiVirgula(this)" align="left" size="4"	name="produtoEmpresa.preco"value="${produtoEmpresa.preco}">
Quantidade
<input type="text" align="right" size="4"	name="produtoEmpresa.quantidade_estoque" value="${produtoEmpresa.quantidade_estoque}">
Ativo
<input type="checkbox" name="produtoEmpresa.ativo" value="1" checked="checked">
<!-- Adicionando o produto a Empresa --> 
<input type="hidden" name="produtoEmpresa.produto.id" value="${produto.id}" />
<input type="hidden" name="produtoEmpresa.empresa.id" value="${empresaWeb.id}" />
<button type="submit">Adicionar</button>
</form>
</display:column>
</display:table>
	</div>
	
	</body>
</html>
	