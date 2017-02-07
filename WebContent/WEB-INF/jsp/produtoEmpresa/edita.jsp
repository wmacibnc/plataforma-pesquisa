<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function substituiVirgula(campo) {
campo.value = campo.value.replace(/,/gi, ".");
}
</script>
</head>
<body>
	<div id="conteudo">
		<form id="produtoEmpresaForm"
			action="<c:url value="/produtoEmpresa/${produtoEmpresa.id }"/>"
			method="POST">
			<fieldset>
				<legend>Editar Produto da Empresa</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="produto">Produto:</label> <label for="name">${produtoEmpresa.produto.nome}</label>
				<input type="hidden" name="produtoEmpresa.produto.id"
					value="${produtoEmpresa.produto.id}"> <input type="hidden"
					name="produtoEmpresa.empresa.id"
					value="${produtoEmpresa.empresa.id}"> 
					<label	for="quantidade">Quantidade:</label> 
					<input type="text"		name="produtoEmpresa.quantidade_estoque"
					value="${produtoEmpresa.quantidade_estoque}" /> <label for="preco">Preço:</label>
				<input type="text" onkeyup="substituiVirgula(this)" name="produtoEmpresa.preco"
					value="${produtoEmpresa.preco}" /> 
					Ativo <input type="checkbox" name="produtoEmpresa.ativo" value="1" checked="checked">
				<button type="submit" name="_method" value="PUT">Salvar</button>
			</fieldset>
		</form>
	</div>
</body>
</html>