<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<%
	List<Usuario> users = (List<Usuario>) request.getAttribute("users");
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuarios</title>	
<link rel="stylesheet" type="text/css" href="../../indexEstilo.css"> 
</head>
<body>
 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Usuarios</h1>
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
		<%
			if (users.isEmpty()) {
		%>
		<p>No se encuentran usuarios. Añada Usuarios</p>
		<%
			} else {
		%>
		<table>
			<tr id="head">
				<td>Carné de identidad</td>
				<td>Rol</td>
				<td>Correo electrónico</td>
				<td>Nacimiento</td>
				<td>Género</td>
				<td>Estado</td>
				<td>Creado</td>
			</tr>
			<%
				for (Usuario us : users) {
			%>
			<tr class="body">
				<td><a href="/users/view?id=<%=us.getId()%>"><%=us.getId()%></a></td>
				<td><%=us.getIdRole()%></td>
				<td><%=us.getEmail()%></td>
				<td><%=us.getBirth().toString()%></td>
				<td>
					<%
						if (us.isGender()) {
					%> Masculino <%
						} else {
					%> Femenino <%
						}
					%>
				</td>
				<td><%=us.isStatus()%></td>
				<td><%=us.getMade()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</div>
		<a id="add"href="/users/add" title="Crear Usuario" id="volver">Crear Usuario</a>
</body>
</html>