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
		<h3>Grupos Cadastrados</h3>
		<form action="<c:url value="/grupo/busca"/>">
			<input id="buscagrupo" name="nome" />
			<script type="text/javascript">
				$("#buscagrupo").puts("Busca Grupo por nome");
				$("#buscagrupo").autocomplete(
						'<c:url value="/grupo/busca.json"/>', {
							dataType : "json",
							parse : function(grupo) {
								return $.map(grupo, function(grupo) {
									return {
										data : grupo,
										value : grupo.nome,
										result : grupo.nome
									};
								});
							},
							formatItem : function(grupo) {
								return grupo.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="grupo" export="true" name="${grupoList}" pagesize="25" size="resultSize" requestURI="/grupo">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column title="Editar"><a href="<c:url value="/grupo/${grupo.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/grupo/${grupo.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/grupo/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>