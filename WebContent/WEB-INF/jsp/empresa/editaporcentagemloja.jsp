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
		<form id="empresaForm"
			action="<c:url value="/empresa/porcentagem/edita/${empresa.id}"/>" method="POST">
			<fieldset>
				<legend>Porcentagem - Loja</legend>
				<img alt="Porcentagem - Loja" src="<c:url value="/imagens/paginas/desconto.gif"/>">
				<p></p>
		
<input type="hidden" name="empresa.fantasia" value="${empresa.fantasia}" />
<input type="hidden" name="empresa.razao" value="${empresa.razao}" />
<input type="hidden" name="empresa.inscricao_estadual" value="${empresa.inscricao_estadual}" />
<input type="hidden" name="empresa.login" value="${empresa.login}" />
<input type="hidden" name="empresa.senha" value="${empresa.senha}" />
<input type="hidden" name="empresa.cnpj" value="${empresa.cnpj}" />
<input type="hidden" name="empresa.proprietario" value="${empresa.proprietario}" />
<input type="hidden" name="empresa.situacao" value="${empresa.situacao}" />
<input type="hidden" name="empresa.data_cadastro" value="${empresa.data_cadastro}" />
<input type="hidden" name="empresa.hora_cadastro" value="${empresa.hora_cadastro}" />
<input type="hidden" name="empresa.endereco" value="${empresa.endereco}" />					
<input type="hidden" name="empresa.cep" value="${empresa.cep}" />	
<input type="hidden" name="empresa.telefone1" value="${empresa.telefone1}" />
<input type="hidden" name="empresa.telefone2" value="${empresa.telefone2}" />
<input type="hidden" name="empresa.telefone3" value="${empresa.telefone3}" />
<input type="hidden" name="empresa.fax" value="${empresa.fax}" />
<input type="hidden" name="empresa.email" value="${empresa.email}" />
<input type="hidden" name="empresa.site" value="${empresa.site}" />
<input type="hidden" name="empresa.atividade.id" value="${empresa.atividade.id}" />
<input type="hidden" name="empresa.bairro.id" value="${empresa.bairro.id}" />
<input type="hidden" name="empresa.loja" value="${empresa.loja}" />
				
					
						<h4>Entre com a porcentagem em que os produtos devem ser mostrados.</h4>
						<input type="text" onkeyup="substituiVirgula(this)" name="empresa.porcentagemloja" value="${empresa.porcentagemloja}" />
						<p> * Seus produtos terão um acréscimo ou descrescimo nas pesquisas do sistema. Mas continuará com o mesmo preço.</p>
						<p> Por favor, Não coloque (%) somente números.</p>
						<p> Você pode utilizar o sinal (-) para dar descontos.</p>
						<p> Em caso de reajuste, não precisa colocar o sinal (+) para aumentar seus preços.</p>
					
				<button type="submit" name="_method" value="PUT">Salvar</button>
				
			</fieldset>
			
		</form>
	</div>
</body>
</html>