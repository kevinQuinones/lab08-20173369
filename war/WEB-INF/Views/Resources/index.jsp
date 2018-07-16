<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="controller.resources.IndexControllerRe"%>
<%@ page import="model.entity.*"%>
<%
	Usuario log = (Usuario) request.getAttribute("log");
%>
<%
	List<Resource> resources = (List<Resource>) request.getAttribute("resource");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Resources</title>
<link rel="stylesheet" type="text/css" href="../../indexEstilo.css"> 
</head>
<body>
	 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Recursos</h1>
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
	<a id="add"href="/resources/add" title="Crear Acceso" id="volver">Crear Recurso</a>
	<div id="table">
		<%
			if (resources.isEmpty()) {
		%>
		<p>No se encuentran Resources. Añada Resources</p>
		<%
			} else {
		%>
		<table>
			<tr id="head">
				<td>ID</td>
				<td>URL</td>
				<td>Status</td>
				<td>Made</td>
			</tr>
			<%
				for (Resource us : resources) {
			%>
			<tr class="body">
				<td><a href="/resources/view?id=<%=us.getId()%>"><%=us.getId()%></a></td>
				<td><%=us.getNombre()%></td>
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