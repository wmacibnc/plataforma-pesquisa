<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="conteudo" align="center">
<h3>Fale Conosco</h3>
<p> Encontre-nos nas redes socias<p>

<h4> Envie-nos uma mensagem</h4>

<form action="<c:url value="/faleconosco/email"/>">
 <label>Nome: </label>
 <input name="contato.nome" value="${contato.nome}">
 <label>E-mail: </label>
 <input name="contato.email" value="${contato.email}">
 <label>Assunto: </label>
 <input name="contato.assunto" value="${contato.assunto}">
 <label>Mensagem: </label>
 <textarea rows="4" cols="35" name="contato.mensagem"> Deixe sua mensagem</textarea>
 
 <!-- <input type="text" name="contato.mensagem" value="${contato.mensagem}">-->
 <button>Enviar</button>
 <label>*Você receberá uma cópia dessa mensagem no seu e-mail</label> 
 </form>
</div>
</body>
</html>