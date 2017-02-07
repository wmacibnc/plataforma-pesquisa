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
		<form id="itemForm" action="<c:url value="/item/${item.id }"/>"
			method="POST">
			<fieldset>
				<legend>Editar Item</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				
				
				<label for="precoUnit">Preço Unitário:</label>
				<label for="precoUnit"><fmt:formatNumber type="currency" value="${item.preco_unit}"/></label>
				<input type="hidden" name="item.preco_unit" value="${item.preco_unit}" />
				 
				<label for="preco_total">Preço Total:</label> 
				<label for="preco_total"><fmt:formatNumber type="currency" value="${item.preco_unit * item.quantidade }"/></label>
				<input type="hidden" name="item.preco_total" value="${item.preco_total}" />
				
				<label for="qtd">Quantidade:</label> 
				<input type="text" name="item.quantidade" value="${item.quantidade}" />
				 
				<label for="produtoEmpresa">Produto:</label> 
				<label for="preco_total">${item.produtoEmpresa.produto.nome}</label>
				<input type="hidden" name="item.produtoEmpresa.id" value="${item.produtoEmpresa.id}" />
				 
				<label for="orcamento">Orçamento nº</label>
				<label for="orcamento">${item.orcamento.id}</label>
				<input type="hidden" name="item.orcamento.id" value="${item.orcamento.id}" />
				
				<button type="submit" name="_method" value="PUT">Salvar</button>
				
			</fieldset>
		</form>
		<script type="text/javascript">
			$('#itemForm').validate({
				rules : {
					"item.quantidade" : {
						required : true,
								
					},
					"item.preco_unit" : {
						required : true,
						number: true				
					},"item.preco_total" : {
						required : true,
						number: true				
					}
				}
			});
		</script>
	</div>
</body>
</html>