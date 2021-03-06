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
		<h3>Bairro Cadastrados</h3>
		<form action="<c:url value="/bairro/busca"/>">
			<input id="buscabairro" name="nome" />
			<script type="text/javascript">
				$("#buscabairro").puts("Busca Bairro");
				$("#buscabairro").autocomplete(
						'<c:url value="/bairro/busca.json"/>', {
							dataType : "json",
							parse : function(bairro) {
								return $.map(bairro, function(bairro) {
									return {
										data : bairro,
										value : bairro.nome,
										result : bairro.nome
									};
								});
							},
							formatItem : function(bairro) {
								return bairro.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="bairro" export="true" name="${bairroList}" pagesize="25" size="resultSize" requestURI="/bairro">  
    <display:column property="id"   title="Id"  sortable="true"/>  
    <display:column property="nome" title="Nome" sortable="true"/>
    <display:column property="codigo" title="C�digo" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/bairro/${bairro.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/bairro/${bairro.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/bairro/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>