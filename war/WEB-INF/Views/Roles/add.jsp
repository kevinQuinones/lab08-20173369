<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<%

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir usuario</title>
<link rel="stylesheet" type="text/css" href="../../addEstilo.css"> 
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
		<form action="/roles/add" method="post">
			<h1>Añadir Rol de Usuario</h1>
			<input type="text" name="name" placeholder="Ingrese nombre del rol"
				required> <br> <br> <br> <input type="submit"
				value="Añadir">
				<a id="add"href="/roles" title="Roles"  style="color:#000000;" >Ver todos los Roles</a>
		</form>
	</div>
</body>
</html>