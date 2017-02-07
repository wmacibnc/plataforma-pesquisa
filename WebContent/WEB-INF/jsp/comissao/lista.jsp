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
		<h3>Comissões Cadastradas</h3>
		<form action="<c:url value="/comissao/busca"/>">
			<input id="buscacomissao" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscacomissao").puts("Buscar Comissão");
				$("#buscacomissao").autocomplete(
						'<c:url value="/comissao/busca.json"/>', {
							dataType : "json",
							parse : function(comissao) {
								return $.map(comissao, function(comissao) {
									return {
										data : comissao,
										value : comissao.nome,
										result : comissao.nome
									};
								});
							},
							formatItem : function(comissao) {
								return comissao.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="comissao" export="true" name="${comissaoList}" pagesize="25" size="resultSize" requestURI="/comissao">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="valor" title="Valor" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/comissao/${comissao.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/comissao/${comissao.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/comissao/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>