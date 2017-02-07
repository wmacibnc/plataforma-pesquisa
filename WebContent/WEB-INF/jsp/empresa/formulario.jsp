<%@page import="org.jfree.data.time.Hour"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	<p>Entre com a localidade primeiro!</p>
	<p><a href="<c:url value="/" />">Página Inicial</a></p>
	</c:if>
	<c:if test="${cidadeWeb !=null}">
		<form id="empresaForm" action="<c:url value="/empresa"/>"
			method="POST">
			<fieldset>
				<legend>Adicionar Empresa</legend>
				
				<img width="400" height="200" alt="edita" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				
				<%
					Date dataAtual = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String dataStr = sdf.format(dataAtual);
				%>
				
					<input type="hidden" name="empresa.data_cadastro" value="<%=dataStr%>" /> 
					<label for="data">Data do Cadastro:	<%=dataStr%> </label>
				<%
					Date horaAtual = new Date();
					SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
					String horaStr = sdf2.format(horaAtual);
				%>
				
					<input type="hidden" name="empresa.hora_cadastro" value="<%=horaStr%>" /> 
					<label for="data">Hora do Cadastro: <%=horaStr%></label>
					
					 
					<label for="fantasia">Nome Fantasia:</label> 
						<input type="text" name="empresa.fantasia" value="${empresa.fantasia}" />
					
						<label for="razao">Razão Social:</label> 
							<input type="text"	name="empresa.razao" value="${empresa.razao}" />
							 
								<label for="cnpj">C.N.P.J:</label>
									<input type="text" name="empresa.cnpj" value="${empresa.cnpj}" /> 
									
									<label for="inscricao">Inscrição Estadual:</label> 
										<input type="text" name="empresa.inscricao_estadual" value="${empresa.inscricao_estadual}" /> 
										
											<label for="atividade">Ramo de Atividade:</label> 
												<select name="empresa.atividade.id">
												 	<c:forEach items="${atividadeList}" var="atividade">
														<option value="${atividade.id}">${atividade.nome}</option>
													</c:forEach>
												</select>
												 
												<label for="proprietario">Proprietário:</label>
												 	<input type="text" name="empresa.proprietario" value="${empresa.proprietario}" />
												 	 
														<label for="login">Login:</label>
															<input type="text" name="empresa.login"	value="${empresa.login}" />
															 
																<label for="senha">Senha:</label> 
																	<input type="password" name="empresa.senha" value="${empresa.senha}" />
																	 
																		<label for="situacao">Situação:</label>
																			<input type="radio"	name="empresa.situacao" value="1"> Sim 
																			<input type="radio" name="empresa.situacao" value="0"> Não
																			
																			<label for="loja">Loja virtual ativa:</label>
																				<input type="radio"	name="empresa.loja" value="1" checked="checked"> Sim 
																				<input type="radio" name="empresa.loja" value="0"> Não
																			
																			
																			<label for="endereco">Endereço:</label>
																				<input type="text" name="empresa.endereco" value="${empresa.endereco}" />
																				 
																					<label for="cep">CEP:</label>
																						<input type="text" name="empresa.cep" value="${empresa.cep}" />
																						
																						<label for="bairro">bairro:</label>
																							<select name="empresa.bairro.id">
																								<c:forEach items="${bairroList}" var="bairro">
																									<c:if test="${bairro.cidade.id == cidadeWeb.id }">
																										<option value="${bairro.id}">${bairro.nome}</option>
																									</c:if>
																								</c:forEach>
																							</select>
																									<label for="telefone1">Telefone 1:</label>
																										<input type="text" name="empresa.telefone1" value="${empresa.telefone1}" />
																										 
																											<label for="telefone2">Telefone 2:</label> 
																												<input type="text" name="empresa.telefone2" value="${empresa.telefone2}" />
																												 
																													<label for="telefone3">Telefone 3:</label> 
																														<input type="text" name="empresa.telefone3" value="${empresa.telefone3}" />
																														 
																															<label for="fax">Fax:</label> 
																																<input type="text" name="empresa.fax" value="${empresa.fax}" />
																																 
																																	<label for="email">E-mail:</label> 
																																		<input type="text" name="empresa.email" value="${empresa.email}" />
																																		 
																																			<label for="site">Site:</label> 
																																				<input type="text" name="empresa.site" value="${empresa.site}" />
																																				
																																						<button type="submit">Salvar</button>
																																							<button type="reset">Limpar</button>
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
		</c:if>
	</div>
</body>
</html>