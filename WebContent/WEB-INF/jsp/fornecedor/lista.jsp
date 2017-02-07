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
		<h3>Fornecedores Cadastrados</h3>
		<form action="<c:url value="/fornecedor/busca"/>">
			<input id="buscafornecedor" name="deno_vin" size="60"/>
			<script type="text/javascript">
				$("#buscafornecedor").puts("Busca Fornecedor por nome");
				$("#buscafornecedor").autocomplete(
						'<c:url value="/fornecedor/busca.json"/>', {
							dataType : "json",
							parse : function(fornecedor) {
								return $.map(fornecedor, function(fornecedor) {
									return {
										data : fornecedor,
										value : fornecedor.deno_vin,
										result : fornecedor.deno_vin
									};
								});
							},
							formatItem : function(fornecedor) {
								return fornecedor.deno_vin;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="fornecedor" export="true" name="${fornecedorList}" pagesize="25" size="resultSize" requestURI="/fornecedor">  
    <display:column property="id" title="Id"  sortable="true"/>
    <display:column property="deno_vin" title="Nome" sortable="true"/>  
    <display:column property="endereco" title="Endereço" sortable="true"/>
    <display:column property="bairro.nome" title="Bairro" sortable="true"/>
    <display:column property="telefone" title="Telefone" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/fornecedor/${fornecedor.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/fornecedor/${fornecedor.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/fornecedor/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>