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
		<h3>Descontos Cadastrados</h3>
		<form action="<c:url value="/desconto/busca"/>">
			<input id="buscadesconto" name="nome" />
			<script type="text/javascript">
				$("#buscadesconto").puts("Busca Desconto");
				$("#buscadesconto").autocomplete(
						'<c:url value="/desconto/busca.json"/>', {
							dataType : "json",
							parse : function(desconto) {
								return $.map(desconto, function(desconto) {
									return {
										data : desconto,
										value : desconto.nome,
										result : desconto.nome
									};
								});
							},
							formatItem : function(desconto) {
								return desconto.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="desconto" export="true" name="${descontoList}" pagesize="25" size="resultSize" requestURI="/desconto">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="valor" title="Valor" sortable="true"/>
    <display:column property="empresa.fantasia" title="Empresa" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/desconto/${desconto.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/desconto/${desconto.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/desconto/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>