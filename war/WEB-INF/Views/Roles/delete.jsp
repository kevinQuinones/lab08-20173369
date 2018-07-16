<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.List"%>
<%
	Role role = (Role) request.getAttribute("role");
%>
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rol: <%=role.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../delete.css"> 
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
		<form action="/roles/delete" method="post">
			<label>Seleccionar Futuro Rol a asignar</label> <select name="rol">
				<%
					for (Role a : roles) {
						if (a.getId() != role.getId()) {
				%>
				<option value="<%=a.getId()%>"><%=a.getNombre()%></option>
				<%
					}
					}
				%>
			</select> <input type="hidden" name="id" value="<%=role.getId()%>"><br>
			<br> <br> <input type="submit"
				value="Eliminar y Reemplazar">
		</form>
		<p>
			<b>Importante</b> Si se borra un rol todos sus accesos tambien seran
			eliminados. <br>Tambien debera de asignar un nuevo rol a los
			usuarios con dicho rol
		</p>
	</div>
</body>
</html>