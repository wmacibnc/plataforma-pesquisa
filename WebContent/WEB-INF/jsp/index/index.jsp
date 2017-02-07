<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns:og="http://opengraphprotocol.org/schema/">
<head>
<link rel="image_src" href="http://www.compresempre.com.br/imagens/logo.png" />
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-37937147-1']);
  _gaq.push(['_setDomainName', 'compresempre.com.br']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<title>VRaptor Blank Project</title>
<style type="text/css">

<style type="text/css">
/* cria a div pop-up*/
#popup{
position: absolute; /*Define a posição absoluta da pop-up*/
top: 30%; /*Distancia da margem superior da página */
left: 30%; /*Distancia da margem esquerda da página */
width: 300px; /*Largura da pop-up*/
height: 100px; /*Altura da pop-up*/
padding: 20px 20px 20px 20px; /*Margem interna da pop-up*/
border-width: 1px; /*Largura da borda da pop-up*/
border-style: solid; /*Estilo da borda da pop-up*/
background: #DCDCDC; /*Cor de fundo da pop-up*/
color: #000066; /*Cor do texto da pop-up*/
display: none; /* Estilo da pop-up*/
/*fim pop-up*/
}
</style>

<script language="javascript">
// Função que fecha o pop-up ao clicar no botao fechar
function fechar(){
document.getElementById('popup').style.display = 'none';
}
// Aqui definimos o tempo para fechar o pop-up automaticamente
function abrir(){
document.getElementById('popup').style.display = 'block';
setTimeout ("fechar()", 3000);
}
</script>
</head>

<body>

	<div id="conteudo">   
			<div id="popup" class="popup" align="center">
		<a href="<c:url value="/"/>"> <img alt="Compre Sempre"
			src="<c:url value="/imagens/aviso.png"/>" ></a>
			<p />
		<small><a href="javascript: fechar();"> <h4> Fechar Aviso!</h4> </a></small>
		</div>

		<div id="fundo">
	
	<a href="<c:url value="/"/>"> <img alt="Compre Sempre" src="<c:url value="/imagens/logo.png"/>" align="left"></a>
	<h4><font color="orange" size="30px">Compre</font><font color="#6E6F73" size="30px">Sempre</font></h4>
		<label>Entre com o seu estado.</label>
		<form id="Form" action="<c:url value="/estado/cidade"/>" method="get">
			<select name="id">
				<c:forEach items="${estadoList}" var="estado">
					<option value="${estado.id}">${estado.nome}</option>
				</c:forEach>
			</select>
			<button type="submit">Entrar</button>
		</form>
	</div>
	
	<div id="compartilhar">
	<a href="http://www.facebook.com/sharer.php?u=http://www.compresempre.com.br"><img alt="Compre Sempre"
			src="<c:url value="/imagens/compartilhar.png"/>" align="left"></a>
				</div>
	</div>
		
	
	</body>
	</html>
