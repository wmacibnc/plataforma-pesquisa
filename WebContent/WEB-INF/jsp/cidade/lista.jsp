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

		<h3>Cidades Cadastrados</h3>
		<form action="<c:url value="/cidade/busca"/>">
			<input id="buscacidade" name="nome" />
			<script type="text/javascript">
				$("#buscacidade").puts("Busca Cidade");
				$("#buscacidade").autocomplete(
						'<c:url value="/cidade/busca.json"/>', {
							dataType : "json",
							parse : function(cidade) {
								return $.map(cidade, function(cidade) {
									return {
										data : cidade,
										value : cidade.nome,
										result : cidade.nome
									};
								});
							},
							formatItem : function(cidade) {
								return cidade.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="cidade" export="true" name="${cidadeList}" pagesize="25" size="resultSize" requestURI="/cidade">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="estado.nome" title="Estado" sortable="true"/>  
    <display:column property="nome" title="Nome" sortable="true"/>
    <display:column property="codigo" title="Código" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/cidade/${cidade.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/cidade/${cidade.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/cidade/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>