<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="controller.resources.IndexControllerRe"%>
<%@ page import="model.entity.*"%>
<%
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<%
	List<Access> access = (List<Access>) request.getAttribute("access");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Access</title>
<link rel="stylesheet" type="text/css" href="../../indexEstilo.css"> 
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
	<a id="add"href="/access/add" title="Crear " id="volver">Crear Acceso</a><br><br>
		<%
			if (access.isEmpty()) {
		%>
		<p>No se encuentran Access. Añada Access</p>
		<%
			} else {
		%>
		<table>
			<tr id="head">
				<td>ID</td>
				<td>Role</td>
				<td>Resource</td>
				<td>Status</td>
				<td>Made</td>
			</tr>
			<%
				for (Access us : access) {
			%>
			<tr class="body">
				<td><a href="access/view?id=<%=us.getId()%>"><%=us.getId()%></a></td>
				<td><%=us.getRole()%></td>
				<td><%=us.getResource()%></td>
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
</body>
</html>