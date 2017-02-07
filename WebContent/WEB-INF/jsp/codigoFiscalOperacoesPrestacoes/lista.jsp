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
		<h3>Código Fiscal de Operações e Prestações</h3>
		
		<form action="<c:url value="/codigoFiscalOperacoesPrestacoes/busca"/>">
			<input id="buscacodigoFiscalOperacoesPrestacoes" name="nome" size="60"/>
			<script type="text/javascript">
				$("#buscacodigoFiscalOperacoesPrestacoes").puts("Busca CFOP");
				$("#buscacodigoFiscalOperacoesPrestacoes").autocomplete(
						'<c:url value="/codigoFiscalOperacoesPrestacoes/busca.json"/>', {
							dataType : "json",
							parse : function(codigoFiscalOperacoesPrestacoes) {
								return $.map(codigoFiscalOperacoesPrestacoes, function(codigoFiscalOperacoesPrestacoes) {
									return {
										data : codigoFiscalOperacoesPrestacoes,
										value : codigoFiscalOperacoesPrestacoes.nome,
										result : codigoFiscalOperacoesPrestacoes.nome
									};
								});
							},
							formatItem : function(codigoFiscalOperacoesPrestacoes) {
								return codigoFiscalOperacoesPrestacoes.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
	<display:table  class="displaytag.css" id="codigoFiscalOperacoesPrestacoes" export="true" name="${codigoFiscalOperacoesPrestacoesList}" pagesize="25" size="resultSize" requestURI="/codigoFiscalOperacoesPrestacoes">  
    <display:column property="id"   title="Id"  sortable="true"/>
    <display:column property="nome" title="Nome" sortable="true"/>  
    <display:column property="cfop_f" title="CFOP - F" sortable="true"/>  
    <display:column property="cfop_3" title="CFOP - 3" sortable="true"/>  
    <display:column property="tipo_mov" title="Tipo Mov" sortable="true"/>  
    <display:column property="codigo" title="Código" sortable="true"/>
    <display:column title="Editar"><a href="<c:url value="/codigoFiscalOperacoesPrestacoes/${codigoFiscalOperacoesPrestacoes.id}"/>">Editar</a></display:column>
    <display:column title="Remover"><form action="<c:url value="/codigoFiscalOperacoesPrestacoes/${codigoFiscalOperacoesPrestacoes.id}"/>" method="POST"> <button class="link" name="_method" value="DELETE">Remover</button> </form></display:column>
    <display:footer><a href="<c:url value="/codigoFiscalOperacoesPrestacoes/novo"/>">Adicionar</a></display:footer>  
    </display:table>
	</div>
</body>
</html>