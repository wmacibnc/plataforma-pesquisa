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
		<h3>Estados Cadastrados</h3>
		<form action="<c:url value="/estado/busca"/>">
			<input id="buscaestado" name="nome" />
			<script type="text/javascript">
				$("#buscaestado").puts("Busca Estado");
				$("#buscaestado").autocomplete(
						'<c:url value="/estado/busca.json"/>', {
							dataType : "json",
							parse : function(estado) {
								return $.map(estado, function(estado) {
									return {
										data : estado,
										value : estado.nome,
										result : estado.nome
									};
								});
							},
							formatItem : function(estado) {
								return estado.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="estado" export="true" name="${estadoList}" pagesize="25" size="resultSize" requestURI="/estado">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="sigla" title="Sigla" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/estado/${estado.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/estado/${estado.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/estado/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>