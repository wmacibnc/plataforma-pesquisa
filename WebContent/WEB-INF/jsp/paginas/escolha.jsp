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
<h3>Escolha sua opção de busca</h3>
<p> No CompreSempre você pode fazer a pesquisa em todas as empresas no ramo de atividade escolhido anteriormente,
e localizar o menor preço em sua região. Ou pesquisar somente em uma empresa.
Lembrando que em nossos orçamentos não estão inclusos
o valor do frete. Deve-se consultar a empresa em relação ao mesmo.
</p>
<h4>Buscar em:</h4>
<a href="<c:url value="/menorPreco"/>">Todas as Empresas <img alt="Compre Sempre" src="<c:url value="/imagens/paginas/empresas.jpeg"/>" align="left"></a>

<br></br>
<br></br>
<h3>Ou</h3>
<label>Escolha uma empresa abaixo, selecionamos para você, somente as empresas do ramo de atividade escolhido.</label>
		<form id="Form" action="<c:url value="/empresaEmProgresso"/>" method="get">
			<select name="empresa.id">
				<c:forEach items="${empresaList}" var="empresa">
					<c:if test="${empresa.loja == 1}">
						<c:if test="${empresa.atividade.id==atividadeEmProgresso.atividade.id }">
							<c:if test="${empresa.situacao==1}">
								<c:if test="${empresa.bairro.cidade.id == cidadeWeb.id}">
									<option value="${empresa.id}">${empresa.fantasia}  - ${empresa.endereco} - ${empresa.bairro.nome} - ${empresa.bairro.cidade.estado.sigla}</option>
								</c:if>
							</c:if>
						</c:if>
					</c:if>
				</c:forEach>
			</select>
			<button type="submit">Entrar</button>
		</form>

<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
	</div>
</div>
</body>
</html>