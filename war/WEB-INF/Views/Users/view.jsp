<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.entity.*"%>
<%
	Usuario user = (Usuario) request.getAttribute("user");
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<%
	String str = (String) request.getAttribute("url");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuario: <%=user.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../viewEstilo.css">
</head>
<body>
<li class="role">
 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Accesos</h1>
</div>
<nav>
	<ul>
		<li class="actual"><a href="../../index.html"> Inicio </a></li>
		<li><a href="/roles">Roles  </a></li>
		<li><a href="/users"> Usuarios</a></li>
		<li><a href="/access">Accesos  </a></li>
		<li><a href="/resources"> Recursos</a></li>
		<li><a href="/products"> Productos</a></li>
		<li><a href="/users/login"> LogIn </a></li>
		<li><a href="/users/logout"> LogOut </a></li>
	</ul>
</nav>
</header>
	<div id="table">
		<h1 id="id" name="<%=user.getId()%>">Perfil de Usuario:</h1>
		<table>
			<tr>
				<td>ID de usuario</td>
				<td><%=user.getId()%></td>
			</tr>
			<tr>
				<td>Rol</td>
				<td><%=user.getIdRole()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<td>Nacimiento</td>
				<td><%=user.getBirth()%></td>
			</tr>
			<tr>
				<td>Creado</td>
				<td><%=user.getMade()%></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><%=user.isStatus()%></td>
			</tr>
			<tr>
				<td>Genero</td>
				<td>
					<%
						if (user.isGender()) {
					%> Masculino <%
						} else {
					%> Femenino <%
						}
					%>
				</td>
			</tr>
		</table>
	</div>
	<div id="action">
				<a href="/users/edit?id=<%=user.getId() %>" id="volver" >Editar</a>
				<form action="/users/delete" method="GET">
					<input type="hidden" value="<%=user.getId() %>" name="id">
					<input type="submit" value="Eliminar">
				</form>
		</div>
</body>
</html>