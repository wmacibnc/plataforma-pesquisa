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
		<form id="codigoFiscalOperacoesPrestacoesForm"
			action="<c:url value="/codigoFiscalOperacoesPrestacoes/${codigoFiscalOperacoesPrestacoes.id }"/>" method="POST">
			
			<fieldset>
				<legend>Editar Código Fiscal de Operações e Prestações</legend>
				
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				
			<label for="nome">Nome:</label> 
					<input id="nome" type="text" name="codigoFiscalOperacoesPrestacoes.nome" value="${codigoFiscalOperacoesPrestacoes.nome}" />
					 
					 	<label for="codigo">Código:</label> 
							<input id="codigo" type="text" name="codigoFiscalOperacoesPrestacoes.codigo" value="${codigoFiscalOperacoesPrestacoes.codigo}" />
						
						<label for="tipo_mov">Tipo de Movimentação:</label>
							<input id="tipo_mov" type="text" name="codigoFiscalOperacoesPrestacoes.tipo_mov" value="${codigoFiscalOperacoesPrestacoes.tipo_mov}" />
							
						<label for="cfop_f">CFOP - F:</label>
							<input id="cfop_f" type="text" name="codigoFiscalOperacoesPrestacoes.cfop_f" value="${codigoFiscalOperacoesPrestacoes.cfop_f}" />
							
						<label for="cfop_3">CFOP - 3:</label>
							<input id="cfop_3" type="text" name="codigoFiscalOperacoesPrestacoes.cfop_3" value="${codigoFiscalOperacoesPrestacoes.cfop_3}" />
									
				<button type="submit" name="_method" value="PUT">Salvar</button>
				<button type="reset">Limpar</button>
				
			</fieldset>
		</form>
		
		<script type="text/javascript">
			$('#codigoFiscalOperacoesPrestacoesForm').validate({
				rules : {
					"codigoFiscalOperacoesPrestacoes.nome" : {
						required : true,
						minlength : 3				
					}
				}
			});
		</script>
	</div>
</body>
</html>