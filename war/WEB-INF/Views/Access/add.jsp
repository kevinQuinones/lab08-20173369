<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.List"%>
<%
	List<Resource> rs = (List<Resource>) request.getAttribute("rsr");
%>                  
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<%@page import="model.entity.Usuario"%>
<%
	//Usuario log = (Usuario) request.getAttribute("log");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir Access</title>
<link rel="stylesheet" type="text/css" href="../../addEstilo.css"> 
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
		<form action="/access/add" method="post">
			<h1>Añadir Access</h1>
			<label>Seleccionar Funcion: </label> <select name="url">
				<%
					for (Resource r : rs) {
				%>
				<option value="<%=r.getId()%>"><%=r.getNombre()%></option>
				<%
					}
				%>
			</select> <br> <br> <br> <label>Seleccionar Role: </label> <select
				name="rol">
				<%
					for (Role r : roles) {
				%>
				<option value="<%=r.getId()%>"><%=r.getNombre()%></option>
				<%
					}
				%>
			</select> <br> <br> <br> <label>Permitir</label> <input
				type="radio" name="is" value="true" id="si"><label for="si">Si</label>
			<input type="radio" name="is" value="false" id="no" checked><label
				for="no">No</label> <br> <br> <br> <input
				type="submit" value="Añadir">
				<a id="add"href="/access" title="Añadir Usuario"  style="color:#000000;" >Ver todos los Accesos</a>
		</form>
	</div>
</body>
</html>