<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>

<html>
<head>
<%		
	@SuppressWarnings("unchecked")
	ArrayList<model.Usuario> lista = (ArrayList<model.Usuario>) request.getAttribute("listaUsuario");
%>

<meta charset="UTF-8">
<title>.: Sucesso :.</title>
</head>
<body>
 <h1> Usuário encontrado com sucesso! </h1>
 <hr> 
     <% for (model.Usuario elemento : lista) { %>
  		<% out.println(elemento.getId()); %> - <% out.println(elemento.getNome()); %> - <% out.println(elemento.getEmail()); %><br>  		
	<% } %>   
</body>
</html>