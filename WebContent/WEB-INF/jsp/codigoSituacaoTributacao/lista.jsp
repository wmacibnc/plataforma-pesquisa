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
		<h3>Código de Situação Tributação Cadastrados</h3>
		
		<form action="<c:url value="/desconto/busca"/>">
			<input id="buscacodigoSituacaoTributacao" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscacodigoSituacaoTributacao").puts("Busca Código de Situacao de Tributação");
				$("#buscacodigoSituacaoTributacao").autocomplete(
						'<c:url value="/codigoSituacaoTributacao/busca.json"/>', {
							dataType : "json",
							parse : function(codigoSituacaoTributacao) {
								return $.map(codigoSituacaoTributacao, function(codigoSituacaoTributacao) {
									return {
										data : codigoSituacaoTributacao,
										value : codigoSituacaoTributacao.nome,
										result : codigoSituacaoTributacao.nome
									};
								});
							},
							formatItem : function(codigoSituacaoTributacao) {
								return codigoSituacaoTributacao.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
		
	<display:table  class="displaytag.css" id="codigoSituacaoTributacao" export="true" name="${codigoSituacaoTributacaoList}" pagesize="25" size="resultSize" requestURI="/codigoSituacaoTributacao">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="codigo" title="Código" sortable="true"/>
    <display:column property="regimeTributacao.nome" title="Regime de Tributação" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/codigoSituacaoTributacao/${codigoSituacaoTributacao.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/codigoSituacaoTributacao/${codigoSituacaoTributacao.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/codigoSituacaoTributacao/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>