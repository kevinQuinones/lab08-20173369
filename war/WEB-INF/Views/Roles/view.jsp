<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<%
	Role role = (Role) request.getAttribute("role");
%>
<%
	List<Access> access = (List<Access>) request.getAttribute("acc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rol: <%=role.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../viewEstilo.css">
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
		<h1 id="id" name="<%=role.getId()%>">Datos del Role:</h1>
		<table>
			<tr>
				<td>ID</td>
				<td><%=role.getId()%></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><%=role.getNombre()%></td>
			</tr>
			<tr>
				<td>Creado</td>
				<td><%=role.getMade()%></td>
			</tr>
			</table><br><<br>
			<table>
			<tr>
				<td><b>Accesos</b></td>
			</tr>
			<%
				for (Access a : access) {
			%>
			<tr>
				<td><%=a.getIdResource()%></td>
				<td><%=a.isStatus()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<b>Importante</b> Si se borra un rol todos sus accesos tambien seran
			eliminados. <br>Tambien debera de asignar un nuevo rol a los
			usuarios con dicho rol
		</p>
	</div>
		<div id="action">
				<a href="/roles/edit?id=<%=role.getId() %>" id="volver" >Editar</a>
				<form action="/roles/delete" method="GET">
					<input type="hidden" value="<%=role.getId() %>" name="id">
					<input type="submit" value="Eliminar">
				</form>
		</div>
</body>
</html>