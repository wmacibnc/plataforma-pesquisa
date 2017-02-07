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
		<form id="fornecedorForm" action="<c:url value="/fornecedor"/>"	method="POST">
			<fieldset>
				<legend>Adicionar Fornecedor</legend>
				<img width="400" height="200" alt="novo" src="<c:url value="/imagens/paginas/formulario.gif"/>">
				<p></p>
				
				<table align="left">
					<tr>
						<td>
							<label><b>Dados da Empresa</b></label>
						</td>
					</tr>
					
					<tr>
					<td>
						<label for="deno_qua">Razão Social:</label> 
					</td>
					<td>
						<input id="deno_qua" type="text" name="fornecedor.deno_qua" value="${fornecedor.deno_qua}" />
					</td>
					</tr>
					<tr>
						<td>
							<label for="deno_vin">Nome Fantasia:</label> 
						</td>
						<td>
							<input id="deno_vin" type="text" name="fornecedor.deno_vin" value="${fornecedor.deno_vin}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="icms">ICMS:</label> 
						</td>
						<td>
							<input id="icms" type="text" name="fornecedor.icms" value="${fornecedor.icms}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="www">Site:</label> 
						</td>
						<td>
							<input id="www" type="text" name="fornecedor.www" value="${fornecedor.www}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="e_mail">E-Mail:</label>
						</td>
						<td>
							<input id="e_mail" type="text" name="fornecedor.e_mail" value="${fornecedor.e_mail}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="grupo">Grupo do Fornecedor:</label>
						</td>
						<td>
							<select name="fornecedor.grupoFornecedor.id">
								<c:forEach items="${grupoFornecedorList}" var="grupoFornecedor">
									<option value="${grupoFornecedor.id}">${grupoFornecedor.nome}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for="vendedor">Vendedor:</label> 
						</td>
						<td>
							<input id="vendedor" type="text" name="fornecedor.vendedor" value="${fornecedor.vendedor}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="dt_ult_compra">Data da Última Compra:</label> 
						</td>
						<td>
							<input id="dt_ult_compra" type="text" name="fornecedor.dt_ult_compra" value="${fornecedor.dt_ult_compra}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="endereco">Endereço:</label> 
						</td>
						<td>
							<input id="endereco" type="text" name="fornecedor.endereco" value="${fornecedor.endereco}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cep">CEP:</label> 
						</td>
						<td>
							<input id="cep" type="text" name="fornecedor.cep" value="${fornecedor.cep}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="bairro">Bairro:</label> 
						</td>
						<td>
							<select name="fornecedor.bairro.id">
								<c:forEach items="${bairroList}" var="bairro">
									<option value="${bairro.id}">${bairro.nome}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
						<tr>
						<td>
							<label for="ddd">DD:</label> 
						</td>
						<td>
							<input id="ddd" type="text" name="fornecedor.ddd" value="${fornecedor.ddd}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="telefone">Telefone - 1:</label>
						</td>
						<td>
							<input id="telefone" type="text" name="fornecedor.telefone" value="${fornecedor.telefone}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="telefone2">Telefone - 2:</label> 
						</td>
						<td>
							<input id="telefone2" type="text" name="fornecedor.telefone2" value="${fornecedor.telefone2}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="telex">Telefone - 3:</label>
						</td>
						<td>
							<input id="telex" type="text" name="fornecedor.telex" value="${fornecedor.telex}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="fax">Fax:</label>
						</td>
						<td>
							<input id="fax" type="text" name="fornecedor.fax" value="${fornecedor.fax}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cod_sit">Ativo:</label>
						</td>
						<td>
							<input type="checkbox" name="fornecedor.cod_sit" value="1" checked="checked">
						</td>
					</tr>
					<tr>
						<td>
							<label for="fabricante">Fabricante:</label> 
						</td>
						<td>
							<input id="fabricante" type="text" name="fornecedor.fabricante" value="${fornecedor.fabricante}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cgc">CGC:</label> 
						</td>
						<td>
							<input id="cgc" type="text" name="fornecedor.cgc" value="${fornecedor.cgc}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="ins_est">Inscrição Estadual:</label> 
						</td>
						<td>
							<input id="ins_est" type="text" name="fornecedor.ins_est" value="${fornecedor.ins_est}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="contato">Contato:</label> 
						</td>
						<td>
							<input id="contato" type="text" name="fornecedor.contato" value="${fornecedor.contato}" />
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="cx_postal_end">Caixa Postal:</label> 
						</td>
						<td>
							<input id="cx_postal_end" type="text" name="fornecedor.cx_postal_end" value="${fornecedor.cx_postal_end}" />
						</td>
					</tr>
				</table>
				
				
				<table align="center">
					<tr>
						<td>
							<label><b>Dados para Pagamentos</b></label>
						</td>
					</tr>
						<tr>
						<td>
							<label for="rua_pgto">Rua:</label> 
						</td>
						<td>
							<input id="rua_pgto" type="text" name="fornecedor.rua_pgto" value="${fornecedor.rua_pgto}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="bairro_pgto">Bairro:</label> 
						</td>
						<td>
							<input id="bairro_pgto" type="text" name="fornecedor.bairro_pgto" value="${fornecedor.bairro_pgto}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cidade_pgto">Cidade:</label> 
						</td>
						<td>	
							<input id="cidade_pgto" type="text" name="fornecedor.cidade_pgto" value="${fornecedor.cidade_pgto}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cx_postal_pgto">Caixa Postal:</label> 
						</td>
						<td>
							<input id="cx_postal_pgto" type="text" name="fornecedor.cx_postal_pgto" value="${fornecedor.cx_postal_pgto}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="cep_pgto">CEP:</label> 
						</td>
						<td>
							<input id="cep_pgto" type="text" name="fornecedor.cep_pgto" value="${fornecedor.cep_pgto}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="fone1_pgto">Telefone - 1:</label> 
						</td>
						<td>
							<input id="fone1_pgto" type="text" name="fornecedor.fone1_pgto" value="${fornecedor.fone1_pgto}" />	
						</td>
					</tr>
					<tr>
						<td>
							<label for="fone2_pgto">Telefone - 2:</label> 
						</td>
						<td>
							<input id="fone2_pgto" type="text" name="fornecedor.fone2_pgto" value="${fornecedor.fone2_pgto}" />	
						</td>
					</tr>
					<tr>
						<td>
							<label for="telex_pgto">Telefone - 3:</label> 
						</td>
						<td>
							<input id="telex_pgto" type="text" name="fornecedor.telex_pgto" value="${fornecedor.telex_pgto}" />	
						</td>
					</tr>
					<tr>
						<td>
							<label for="fac_pgto">Fax:</label> 
						</td>
						<td>
							<input id="fac_pgto" type="text" name="fornecedor.fac_pgto" value="${fornecedor.fac_pgto}" />	
						</td>
					</tr>
				</table>
													 
				<table align="center"> 
					<tr>
						<td>
							<label><b>Dados Bancários</b></label>
						</td>
					</tr>
					<tr>
						<td>
							<label for="banco">Banco:</label>
						</td>
						<td>
							<input id="banco" type="text" name="fornecedor.banco" value="${fornecedor.banco}" />
					</td>
					</tr>
						<tr>
						<td>
							<label for="agencia">Agência:</label>
						</td>
					<td>
							<input id="agencia" type="text" name="fornecedor.agencia" value="${fornecedor.agencia}" />
						</td>
					</tr>
					<tr>
						<td>
							<label for="conta_corrente">Conta Corrente:</label> 
						</td>
						<td>
							<input id="conta_corrente" type="text" name="fornecedor.conta_corrente" value="${fornecedor.conta_corrente}" />
						</td>
					</tr>
					
					<tr>
						<td>
							<button type="submit">Salvar</button>
						</td>
						<td>
							<button type="reset">Limpar</button>
						</td>
						</tr>
				</table>
					
			</fieldset>
			
		</form>
		<script type="text/javascript">
			$('#fornecedorForm').validate({
				rules : {
					"fornecedor.deno_vin" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>