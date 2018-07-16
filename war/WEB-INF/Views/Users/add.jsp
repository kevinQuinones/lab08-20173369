
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<%
	Date date = (Date) request.getAttribute("date");
%>
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
	// Usuario log = (Usuario) request.getAttribute("log");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../addEstilo.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir usuario</title>
<link rel="stylesheet" type="text/css" href="../estilos/users.css">
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
		<form action="/users/add" method="post">
			<h1>Añadir Usuario</h1>
			 <input type="email" name="email"
				placeholder="Ingrese su correo electronico" required> <br>
			<br> <br> <label>Ingrese su fecha de Nacimiento</label><br>
			<%
				date = new Date(date.getTime() - 86400000);
				String res = "" + (1900 + date.getYear()) + "-";
				if (date.getMonth() < 10)
					res = res + "0";
				res = res + (date.getMonth() + 1) + "-";
				if (date.getDate() < 10)
					res = res + "0";
				res = res + date.getDate();
			%>
			<br> <input type="date" name="date" min="1000-01-01"
				max="<%=res%>" placeholder="Ingrese su fecha de Nacimiento"
				required> <br> <br> <br> <input type="radio"
				name="gender" id="hombre" value="true" checked> <label
				for="hombre">Masculino</label> <input type="radio" name="gender"
				id="mujer" value="false"> <label for="mujer">Femenino</label><br>
			<label>Seleccione su rol: </label> <select name="role">
				<%
					for (Role rl : roles) {
				%>
				<option value="<%=rl.getId()%>"><%=rl.getNombre()%></option>
				<%
					}	
				%>
			</select> <br> <input type="submit" value="Añadir">
			<a id="add"href="/users" title="Añadir Usuario"  style="color:#000000;" >Ver todos los Usuarios</a>
		</form>
	</div>
</body>
</html>