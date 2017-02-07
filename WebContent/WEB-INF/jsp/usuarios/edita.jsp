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
	
	<c:if test="${cidadeWeb ==null}">
	<p>Entre com sua localidade primeiro!</p>
	<p><a href="<c:url value="/" />">Página Inicial</a></p>
	</c:if>
	
	<c:if test="${cidadeWeb !=null}">
	
	<div id="formulario" align="center">
		<form id="usuariosForm"	action="<c:url value="/usuarios/${usuario.id }"/>" method="POST">
			<fieldset>
			<legend>Editar Usuário</legend>
			
				<p></p>
				<label for="nome">Nome:</label> 
				<input id="nome" type="text" name="usuario.nome" value="${usuario.nome}" /> 
				
				<label for="datanasc">Data Nascimento:</label> 
				<input id="datanasc" type="text" name="usuario.datanasc" value="${usuario.datanasc}" />
				
				<label for="rg">RG:</label> 
				<input id="rg" type="text" name="usuario.rg" value="${usuario.rg}" />
				 
				<label for="cpf">C.P.F:</label>
				<input id="cpf" type="text" name="usuario.cpf" value="${usuario.cpf}" />
				 
				<label for="endereco">Endereço:</label>
				<input id="endereco" type="text" name="usuario.endereço" value="${usuario.endereço}" />
				 
				<label for="cep">CEP:</label> 
				<input id="cep" type="text" name="usuario.cep" value="${usuario.cep}" />
				
				<label for="bairro">bairro:</label> 
				<select name="usuario.bairro.id">
					<c:forEach items="${bairroList}" var="bairro">
						<c:if test="${bairro.cidade.id == cidadeWeb.id }">
						<option value="${bairro.id}">${bairro.nome}</option>
						</c:if>
					</c:forEach>
					
				</select>
				
				<label for="email">E-mail:</label> 
				<input id="email" type="text" name="usuario.email" value="${usuario.email}" />
				 
				<label for="telefoneResidencial">Telefone Residencial:</label> 
				<input id="telefoneResidencial" type="text" name="usuario.telefoneResidencial" value="${usuario.telefoneResidencial}" />
				 
				<label for="telefoneCelular">Telefone Celular:</label> 
				<input id="telefoneCelular" type="text" name="usuario.telefoneCelular" value="${usuario.telefoneCelular}" />
				 
				<label for="telefoneComercial">Telefone Comercial:</label> 
				<input id="telefoneComercial" type="text" name="usuario.telefoneComercial" value="${usuario.telefoneComercial}" />
				 
				<label for="fax">Fax:</label>
				<input id="fax" type="text" name="usuario.fax"	value="${usuario.fax}" />
				
				<label for="login">Login:</label> 
				<input id="login" class="required" type="text" name="usuario.login" value="${usuario.login }" />
				 
				<label for="senha">Senha:</label> 
				<input id="senha" class="required" type="password" name="usuario.senha" value ="${usuario.senha}" />
				 
				<label for="confirmacao">Confirme a senha:</label>
				<input id="confirmacao" equalTo="#senha" type="password" value ="${usuario.senha}"/>
				
				<button type="submit" name="_method" value="PUT">Salvar</button>
				
			</fieldset>
		</form>
		</div>
		</c:if>
	</div>
</body>
</html>