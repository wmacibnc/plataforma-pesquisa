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
		<form id="empresaForm"
			action="<c:url value="/empresa/${empresa.id }"/>" method="POST">
			<fieldset>
				<legend>Editar Empresa</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				
					<input type="hidden" name="empresa.data_cadastro" value="${empresa.data_cadastro}" />
					<input type="hidden" name="empresa.hora_cadastro" value="${empresa.hora_cadastro}" /> 
					<input type="hidden" name="empresa.atividade.id" value="${empresa.atividade.id}" />
					<input type="hidden" name="empresa.bairro.id" value="${empresa.bairro.id}" />
					
					 
					<label for="data">Data do Cadastro: ${empresa.data_cadastro}</label>
					<label for="hora">Hora do Cadastro: ${empresa.hora_cadastro}</label>
					
					<label for="fantasia">Nome Fantasia:</label>
					<input type="text"	name="empresa.fantasia" value="${empresa.fantasia}" />
					
					<label for="razao">Razão Social:</label>
					<input type="text" name="empresa.razao" value="${empresa.razao}" />
					 
					<label for="cnpj">C.N.P.J:</label>
					<input type="text" name="empresa.cnpj" value="${empresa.cnpj}" />
					 
					<label for="inscricao">Inscrição Estadual:</label> 
					<input type="text" name="empresa.inscricao_estadual" value="${empresa.inscricao_estadual}"/>
					
					<label for="atividade">Ramo de Atividade: </label> <label for="atividade">${empresa.atividade.nome}</label>
					
					<label for="proprietario">Proprietário:</label>
					<input type="text" name="empresa.proprietario" value="${empresa.proprietario}" />
					 
					<label for="login">Login:</label>
					<input type="text" name="empresa.login" value="${empresa.login}" />
					
					<label for="senha">Senha:</label>
					<input type="password" name="empresa.senha" value="${empresa.senha}" />
					
					<label for="situacao">Situação (ativo):</label>
					<input type="radio" name="empresa.situacao" value="1"> Sim 
					<input type="radio" name="empresa.situacao" value="0"> Não
					
					<label for="loja">Loja virtual ativa:</label>
					<input type="radio"	name="empresa.loja" value="1" checked="checked"> Sim 
					<input type="radio" name="empresa.loja" value="0"> Não
					 
					<label for="endereco">Endereço:</label> 
					<input type="text" name="empresa.endereco" value="${empresa.endereco}" />
					 
					<label for="cep">CEP:</label>
					<input type="text" name="empresa.cep" value="${empresa.cep}" /> 
					
					<label for="bairro">Municipio:</label> 
					<label for="bairro">${empresa.bairro.nome}</label>
					
					<label for="telefone1">Telefone 1: </label>
					<input type="text" name="empresa.telefone1" value="${empresa.telefone1}" />
					
					<label for="telefone2">Telefone 2: </label>
					<input type="text" name="empresa.telefone2" value="${empresa.telefone2}" />
					 
					<label for="telefone3">Telefone 3:</label>
					<input type="text" name="empresa.telefone3"	value="${empresa.telefone3}" />
					
					<label for="fax">Fax:</label> 
					<input type="text" name="empresa.fax" value="${empresa.fax}" />
					 
					<label for="email">E-mail:</label> 
					<input type="text" name="empresa.email" value="${empresa.email}" />
					 
					<label for="site">Site:</label>
					<input type="text" name="empresa.site" value="${empresa.site}" />
					
					<label for="porcentagemloja">Porcentagem Loja:</label>
					<input type="text" name="empresa.porcentagemloja" value="${empresa.porcentagemloja}" />
					
				<button type="submit" name="_method" value="PUT">Salvar</button>
				
			</fieldset>
			
		</form>
			<script type="text/javascript">
			$('#empresaForm').validate({
				rules : {
					"empresa.fantasia" : {
						required : true,
						minlength : 3				
					},
					"empresa.razao" : {
						required : true,
						minlength : 3				
					}
					,
					"empresa.login" : {
						required : true,
						minlength : 3				
					}
					,
					"empresa.senha" : {
						required : true,
						minlength : 3				
					}
					,
					"empresa.email" : {
						required : true,
						minlength : 3,
						email: true
					}					
				}
			});
		</script>
	</div>
</body>
</html>