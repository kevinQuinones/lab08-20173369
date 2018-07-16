<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="controller.roles.IndexControllerRo"%>
<%@ page import="model.entity.*"%>
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../indexEstilo.css"> 
<title>Lista de Roles</title>
</script>
</head>
<body>
 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Roles</h1>
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
			if (roles.isEmpty()) {
		%>
		<p>No se encuentran roles. Añada rol</p>
		<%
			} else {
		%>
		<table>
			<tr id="head">
				<td>ID</td>
				<td>Nombre</td>
				<td>Creación</td>
				<td>Estado</td>
			</tr>
			<%
				for (Role rl : roles) {
			%>
			<tr class="body">
				<td><a href="/roles/view?id=<%=rl.getId()%>"><%=rl.getId()%></a></td>
				<td><%=rl.getNombre()%></td>
				<td><%=rl.getMade()%></td>
				<td><%=rl.isStatus()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</div>
	<a id="add"href="/roles/add" title="Crear Rol" id="volver">Crear Roles</a>
</body>
</html>