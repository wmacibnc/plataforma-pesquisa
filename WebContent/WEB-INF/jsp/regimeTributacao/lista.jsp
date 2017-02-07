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
		<h3>Regime de Tributação Cadastrados</h3>
		<form action="<c:url value="/regimeTributacao/busca"/>">
			<input id="buscaregimeTributacao" name="nome"size="60" />
			<script type="text/javascript">
				$("#buscaregimeTributacao").puts("Busca Regime de Tributação");
				$("#buscaregimeTributacao").autocomplete(
						'<c:url value="/regimeTributacao/busca.json"/>', {
							dataType : "json",
							parse : function(regimeTributacao) {
								return $.map(regimeTributacao, function(regimeTributacao) {
									return {
										data : regimeTributacao,
										value : regimeTributacao.nome,
										result : regimeTributacao.nome
									};
								});
							},
							formatItem : function(regimeTributacao) {
								return regimeTributacao.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="regimeTributacao" export="true" name="${regimeTributacaoList}" pagesize="25" size="resultSize" requestURI="/regimeTributacao">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column title="Editar"><a href="<c:url value="/regimeTributacao/${regimeTributacao.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/regimeTributacao/${regimeTributacao.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/regimeTributacao/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>