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
		<form id="subgrupoForm"
			action="<c:url value="/subgrupo/${subgrupo.id }"/>" method="POST">
			<fieldset>
				<legend>Editar Subgrupo</legend>
				<img width="134" height="200" alt="edita" src="<c:url value="/imagens/paginas/edita.gif"/>">
				<p></p>
				<label for="nome">Nome:</label> <input type="text"
					name="subgrupo.nome" value="${subgrupo.nome}" />
				<button type="submit" name="_method" value="PUT">Enviar</button>
			</fieldset>
		</form>
		<form id ="fileupload" action="<c:url value="/subgrupo/${subgrupo.id}/imagem"/>"
			method="POST" enctype="multipart/form-data">
			<fieldset>
				<legend>Upload de Imagem</legend>
				<input type="file" name="imagem" />
				<button type="submit">Enviar</button>
				<img src="<c:url value="/subgrupo/${subgrupo.id}/imagem"/>"
					width="120" height="120" />
			</fieldset>
		</form>
		<script type="text/javascript">
		$('#fileupload').fileupload({
	  	progressall : function(e, data) {
	    var progress = parseInt(data.loaded / data.total * 100, 10);
	    $("#progress .bar").css('width', progress + '%');
	  	}
		});
		</script>
			<div id="progress">
		  		<div class='bar' style='width: 0%'></div>
			</div>
	</div>
</body>
</html>