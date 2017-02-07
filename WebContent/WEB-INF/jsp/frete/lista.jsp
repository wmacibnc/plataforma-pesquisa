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
		<h3>Fretes Cadastrados</h3>
		<form action="<c:url value="/frete/busca"/>">
			<input id="buscafrete" name="nome" />
			<script type="text/javascript">
				$("#buscafrete").puts("Busca Frete");
				$("#buscafrete").autocomplete(
						'<c:url value="/frete/busca.json"/>', {
							dataType : "json",
							parse : function(frete) {
								return $.map(frete, function(frete) {
									return {
										data : frete,
										value : frete.nome,
										result : frete.nome
									};
								});
							},
							formatItem : function(frete) {
								return frete.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="frete" export="true" name="${freteList}" pagesize="25" size="resultSize" requestURI="/frete">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="valor" title="Valor" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/frete/${frete.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/frete/${frete.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/frete/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>