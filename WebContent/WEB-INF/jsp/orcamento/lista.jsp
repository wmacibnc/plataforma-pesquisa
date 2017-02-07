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
		<h3>Orçamentos Cadastrados</h3>
		<form action="<c:url value="/orcamento/busca"/>">
			<input id="buscaorcamento" name="id" />
			<script type="text/javascript">
				$("#buscaorcamento").puts("Busca Orçamento");
				$("#buscaorcamento").autocomplete(
						'<c:url value="/orcamento/busca.json"/>', {
							dataType : "json",
							parse : function(orcamento) {
								return $.map(orcamento, function(orcamento) {
									return {
										data : orcamento,
										value : orcamento.id,
										result : orcamento.id
									};
								});
							},
							formatItem : function(orcamento) {
								return orcamento.id;
							}
						});
			</script>
		</form>
		<display:table class="displaytag.css" id="orcamento" export="true"
			name="${orcamentoList}" pagesize="25" size="resultSize"
			requestURI="/orcamento">
			<display:column property="id" title="Id" sortable="true" />
			<display:column property="data_cadastro" title="Data" sortable="true" />
			<display:column property="hora_cadastro" title="Hora" sortable="true" />
			<display:column property="usuario.nome" title="Usuário"sortable="true" />
			<display:column title="Editar">	<a href="<c:url value="/orcamento/${orcamento.id}"/>">Editar</a></display:column>
			<display:column title="Remover"> <form action="<c:url value="/orcamento/${orcamento.id}"/>"	method="POST"> <button class="link" name="_method" value="DELETE">Remover</button></form></display:column>
			<display:footer><a href="<c:url value="/orcamento/novo"/>">Adicionar</a></display:footer>
		</display:table>
	</div>
</body>
</html>