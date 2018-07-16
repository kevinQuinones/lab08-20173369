<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<%
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<%
	Resource rsr = (Resource) request.getAttribute("rsr");
%>
<%
	List<Access> access = (List<Access>) request.getAttribute("acc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../viewEstilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recurso: <%=rsr.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../viewEstilo.css">
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
	<div id="table">
		<h1 id="id" name="<%=rsr.getId()%>">Datos del Resource:</h1>
		<table>
			<tr>
				<td>ID</td>
				<td><%=rsr.getId()%></td>
			</tr>
			<tr>
				<td>URL</td>
				<td><%=rsr.getNombre()%></td>
			</tr>
			<tr>
				<td>Creado</td>
				<td><%=rsr.getMade()%></td>
			</tr>
			<tr>
				<td><b>Accesos</b></td>
			</tr>
			</table><br><br>
			<table>
			<%
				for (Access a : access) {
			%>
			<tr>
				<td><%=a.getIdRole()%></td>
				<td><%=a.isStatus()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<b>Importante</b> Si se borra un resource no se podra hacer su
			respectiva funcion hasta que se vuelva a crear
		</p>
	</div>
	<div id="action">
				<a href="/resources/edit?id=<%=rsr.getId() %>" id="volver" >Editar</a>
				<form action="/resources/delete" method="GET">
					<input type="hidden" value="<%=rsr.getId() %>" name="id">
					<input type="submit" value="Eliminar">
				</form>
		</div>
</body>
</html>