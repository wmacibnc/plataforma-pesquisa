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
	<h3> Empresa Administra��o - Softsol</h3>
	
	<h4>${empresaWeb.fantasia}</h4>
	
	
	<table cellspacing="40">
	<tr>
		<td>
		<a href="<c:url value="/produto/softsol/empresa"/>"> <img alt="Adicionar Produtos" src="<c:url value="/imagens/paginas/adicionar.gif" />"></a>
		<p />
		<a href="<c:url value="/produto/empresa"/>"> Adicionar Produtos - Softsol</a>
		</td>
		
		<td>
		<a href="<c:url value="/produtoEmpresa/softsol/empresa?id=${empresaWeb.id}"/>"> <img alt="Gerenciar Produtos" src="<c:url value="/imagens/paginas/gerenciar.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/produtoEmpresa/softsol/empresa?id=${empresaWeb.id}"/>"> Gerenciar Produtos - Softsol</a>
		</td>
		
		<td>
		<a href="<c:url value="/comissao"/>"> <img alt="Comiss�o" src="<c:url value="/imagens/paginas/comissao.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/comissao"/>"> Comiss�o</a>
		</td>
		
		<td>
		<a href="<c:url value="/codigoFiscalOperacoesPrestacoes"/>"> <img alt="C�digo Fiscal de Opera��es e Tributa��es- CFOP" src="<c:url value="/imagens/paginas/cfop.gif"/>" align="top"></a>
		<p /><br />
		<a href="<c:url value="/codigoFiscalOperacoesPrestacoes"/>"> C�digo Fical de Opera��es e Presta��es</a>
		<p align="center">CFOP</p>
		</td>
		</tr>
</table>
		
<table cellspacing="40">
	<tr>
		
		<td>
		<a href="<c:url value="/codigoSituacaoTributacao"/>"> <img alt="C�digo de Situa��o de Tributa��o" src="<c:url value="/imagens/paginas/cst.gif"/>" align="top"></a>
		<p /><p />
		<a href="<c:url value="/codigoSituacaoTributacao"/>"> C�digo de Situa��o de Tributa��o</a>
		</td>
		
	
		<td>
		<a href="<c:url value="/fornecedor"/>"> <img alt="Gerenciar Produtos" src="<c:url value="/imagens/paginas/fornecedor.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/fornecedor"/>"> Fornecedor</a>
		</td>
		
		<td>
		<a href="<c:url value="/grupoFornecedor"/>"> <img alt="Grupo Fornecedor" src="<c:url value="/imagens/paginas/grupofornecedor.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/grupoFornecedor"/>"> Grupo Fornecedor</a>
		</td>
		
		<td>
		<a href="<c:url value="/regimeTributacao"/>"> <img alt="Regime de Tributa��o" src="<c:url value="/imagens/paginas/regime.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/regimeTributacao"/>"> Regime de Tributa��o</a>
		</td>
		
		</tr>
</table>
		
<table cellspacing="40">
	<tr>
	
		<td>
		<a href="<c:url value="/tipoProduto"/>"> <img alt="Tipo de Produto" src="<c:url value="/imagens/paginas/tipo.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/tipoProduto"/>"> Tipo de Produto</a>
		</td>
		
		<td>
		<a href="<c:url value="/unidadeEstoque"/>"> <img alt="Unidades de Estoque" src="<c:url value="/imagens/paginas/unidade.gif"/>" align="left"></a>
		<p />
		<a href="<c:url value="/unidadeEstoque"/>"> Unidades de Estoque</a>
		</td>
		
	</tr>
	</table>
	</div>
	
</body>
</html>