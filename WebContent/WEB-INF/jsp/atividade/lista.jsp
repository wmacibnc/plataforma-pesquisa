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
		<h3>Atividades Cadastradas</h3>
		<h4>Busca Atividades</h4>
		
		<form action="<c:url value="/atividade/busca"/>">
			<input id="buscaatividade" name="nome" />
			<script type="text/javascript">
				$("#buscaatividade").puts("Busca Atividade");
				$("#buscaatividade").autocomplete(
						'<c:url value="/atividade/busca.json"/>', {
							dataType : "json",
							parse : function(atividade) {
								return $.map(atividade, function(atividade) {
									return {
										data : atividade,
										value : atividade.nome,
										result : atividade.nome
									};
								});
							},
							formatItem : function(atividade) {
								return atividade.nome;
							}
						});
			</script>
			</form>
		<p></p>
	<display:table  class="displaytag.css" id="atividade" export="true" name="${atividadeList}" pagesize="25" size="resultSize" requestURI="/atividade">  
    <display:column property="id"   title="Cód"  sortable="true"/>  
    <display:column property="nome" title="Nome" sortable="true"/>
    <display:column title="Editar"> <a href="<c:url value="/atividade/${atividade.id}"/>">Editar</a></display:column>
    <display:column title="Remover"> <form action="<c:url value="/atividade/${atividade.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/atividade/novo"/>">Adicionar</a></display:footer>  
    </display:table>
    </div>
</body>
</html>