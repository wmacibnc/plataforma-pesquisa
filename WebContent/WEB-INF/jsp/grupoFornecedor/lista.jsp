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
		<h3>Grupo de Fornecedores Cadastrados</h3>
		<form action="<c:url value="/grupoFornecedor/busca"/>">
			<input id="buscagrupoFornecedor" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscagrupoFornecedor").puts("Busca Grupo de Fornecedores");
				$("#buscagrupoFornecedor").autocomplete(
						'<c:url value="/grupoFornecedor/busca.json"/>', {
							dataType : "json",
							parse : function(grupoFornecedor) {
								return $.map(grupoFornecedor, function(grupoFornecedor) {
									return {
										data : grupoFornecedor,
										value : grupoFornecedor.nome,
										result : grupoFornecedor.nome
									};
								});
							},
							formatItem : function(grupoFornecedor) {
								return grupoFornecedor.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="grupoFornecedor" export="true" name="${grupoFornecedorList}" pagesize="25" size="resultSize" requestURI="/grupoFornecedor">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column title="Editar"><a href="<c:url value="/grupoFornecedor/${grupoFornecedor.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/grupoFornecedor/${grupoFornecedor.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/grupoFornecedor/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>