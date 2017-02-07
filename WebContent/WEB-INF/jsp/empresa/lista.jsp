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
		<h3>Empresas Cadastradas</h3>
		<form action="<c:url value="/empresa/busca"/>">
			<input id="buscaempresa" name="fantasia" />
			<script type="text/javascript">
				$("#buscaempresa").puts("Busca Empresa por nome");
				$("#buscaempresa").autocomplete(
						'<c:url value="/empresa/busca.json"/>', {
							dataType : "json",
							parse : function(empresa) {
								return $.map(empresa, function(empresa) {
									return {
										data : empresa,
										value : empresa.fantasia,
										result : empresa.fantasia
									};
								});
							},
							formatItem : function(empresa) {
								return empresa.fantasia;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="empresa" export="true" name="${empresaList}" pagesize="18" size="resultSize" requestURI="/empresa">  
    <display:column property="fantasia" title="Nome Fantasia" sortable="true"/>  
    <display:column property="proprietario" title="Proprietário" sortable="true"/>
    <display:column property="endereco" title="Endereço" sortable="true"/>
        <display:column property="bairro.nome" title="Bairro" sortable="true"/>
        <display:column property="telefone1" title="Telefone Residencial" sortable="true"/>
        <display:column property="email" title="E-mail" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/empresa/${empresa.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/empresa/${empresa.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/empresa/novo"/>">Adicionar</a></display:footer>  
    </display:table>
    </div>
</body>
</html>