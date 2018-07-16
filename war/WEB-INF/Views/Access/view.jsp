<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<%
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<%
	Access access = (Access) request.getAttribute("access");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceso: <%=access.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../viewEstilo.css">
</head>
<body>
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
		<h1 id="id" name="<%=access.getId()%>">Datos del Acceso:</h1>
		<table>
			<tr>
				<td>ID</td>
				<td><%=access.getId()%></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><a href="/roles/view?id=<%=access.getIdRole()%>"><%=access.getIdRole()%></a></td>
			</tr>
			</table><br><br>
			<table>
			<tr>
				<td>Resource</td>
				<td><a href="/resources/view?id=<%=access.getIdResource()%>"><%=access.getIdResource()%></a></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><%=access.isStatus()%></td>
			</tr>
			<tr>
				<td>Creado</td>
				<td><%=access.getMade()%></td>
			</tr>
		</table>
		<p>
			<b>Importante</b> Si se borra un acceso el rol afectado no podra
			afectuar la funcion eliminada hasta que se cree otro acceso para eso
		</p>
	</div>
	<div id="action">
				<a href="/access/edit?id=<%=access.getId() %>" id="volver" >Editar</a>
				<form action="/access/delete" method="GET">
					<input type="hidden" value="<%=access.getId() %>" name="id">
					<input type="submit" value="Eliminar">
				</form>
		</div>
</body>
</html>