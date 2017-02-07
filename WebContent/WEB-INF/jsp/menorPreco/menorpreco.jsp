<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="JavaScript">
var var_ExibeFiltros = 0;
function ExibirFiltros(){
  if (var_ExibeFiltros == 1){
    var_ExibeFiltros = 0;
    document.getElementById('linkExibir').innerHTML="Adicionar Bairro a pesquisa";
    document.getElementById('divPrompt').style.display="none";
  } else {
    var_ExibeFiltros = 1;
    document.getElementById('linkExibir').innerHTML="Pesquisar por cidade";
    document.getElementById('divPrompt').style.display="";
  }
}
</script>
</head>
<body>
	<div id="conteudo">
	<c:if test="${cidadeWeb==null }">
	Você precisa entrar com sua locidade.
	<a href="<c:url value="/"/>">Página Inicial</a>
	</c:if>
	
	
	<c:if test="${cidadeWeb!=null }">
		<h3>Buscar o menor preço</h3>
			<img alt="Compre Sempre"src="<c:url value="/imagens/paginas/procurar.gif"/>" align="left">
		<c:if test="${bairroWeb==null }">
			<a href="JavaScript:ExibirFiltros()" id="linkExibir">Adicionar
				Bairro a pesquisa?</a>
			<div id="divPrompt" style="display: none">
				<form action="<c:url value="/bairro/login"/>" method="Post"
					name="form1">
					<label for="bairro">Bairro:</label>
					 <select name="bairro.nome">
						<c:forEach items="${bairroList}" var="bairro">
						<c:if test="${bairro.cidade.id==cidadeWeb.id}">
						<option value="${bairro.nome}">${bairro.nome}</option>
						</c:if>
						</c:forEach>
					</select>
					<button type="submit">Selecionar Bairro.</button>
				</form>
			</div>
		</c:if>
		<h4>Entre com o nome do Produto</h4>
		<c:if test="${orcamentoEmProgresso.orcamento.id!= null}">
			<h3>Orçamento Número : ${orcamentoEmProgresso.orcamento.id}</h3>
		</c:if>
		<form action="<c:url value="/produto/busca2"/>">
			<input id="buscaproduto" name="nome" size="40"/>
			<script type="text/javascript">
				$("#buscaproduto").puts("Busca produtos por nome");
				$("#buscaproduto").autocomplete(
						'<c:url value="/produto/busca2.json"/>', {
							dataType : "json",
							parse : function(produto) {
								return $.map(produto, function(produto) {
									return {
										data : produto,
										value : produto.nome,
										result : produto.nome
									};
								});
							},
							formatItem : function(produto) {
								return produto.nome;
							}
						});
			</script>
			<button>Pesquisar</button>
		</form>
		</c:if>
		<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
	</div>
</body>
</html>