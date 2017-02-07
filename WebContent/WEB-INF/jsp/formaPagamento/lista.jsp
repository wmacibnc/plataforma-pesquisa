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
		<h3>Forma de Pagamentos Cadastradas</h3>
		<form action="<c:url value="/formaPagamento/busca"/>">
			<input id="buscaformaPagamento" name="nome" />
			<script type="text/javascript">
				$("#buscaformaPagamento").puts("Busca Formas de Pagamentos");
				$("#buscaformaPagamento").autocomplete(
						'<c:url value="/formaPagamento/busca.json"/>',
						{
							dataType : "json",
							parse : function(formaPagamento) {
								return $.map(formaPagamento, function(
										formaPagamento) {
									return {
										data : formaPagamento,
										value : formaPagamento.nome,
										result : formaPagamento.nome
									};
								});
							},
							formatItem : function(formaPagamento) {
								return formaPagamento.nome;
							}
						});
			</script>
		</form>
	<display:table  class="displaytag.css" id="formaPagamento" export="true" name="${formaPagamentoList}" pagesize="25" size="resultSize" requestURI="/formaPagamento">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="parcelas_semjuros" title="Parcelas sem Juros" sortable="true"/>
    <display:column property="parcelas_comjuros" title="Parcelas com Juros" sortable="true"/>
    <display:column property="porcetagem" title="Porcetagem" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/formaPagamento/${formaPagamento.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/formaPagamento/${formaPagamento.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/formaPagamento/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>