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
		<h3>Subgrupo Cadastrados</h3>
		<form action="<c:url value="/subgrupo/busca"/>">
			<input id="buscasubgrupo" name="nome" />
			<script type="text/javascript">
				$("#buscasubgrupo").puts("Busca Subgrupo");
				$("#buscasubgrupo").autocomplete(
						'<c:url value="/subgrupo/busca.json"/>',
						{
							dataType : "json",
							parse : function(subgrupo) {
								return $.map(subgrupo, function(
										subgrupo) {
									return {
										data : subgrupo,
										value : subgrupo.nome,
										result : subgrupo.nome
									};
								});
							},
							formatItem : function(subgrupo) {
								return subgrupo.nome;
							}
						});
			</script>
		</form>
		
	<display:table  class="displaytag.css" id="subgrupo" export="true" name="${subgrupoList}" pagesize="5" size="resultSize" requestURI="/subgrupo">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="grupo.nome" title="Grupo" sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>
    <display:column title="Imagem"> <img src="<c:url value="/subgrupo/${subgrupo.id}/imagem"/>" width="120" height="120" /> </display:column>
    <display:column title="Editar"><a href="<c:url value="/subgrupo/${subgrupo.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/subgrupo/${subgrupo.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/subgrupo/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
	
</body>
</html>