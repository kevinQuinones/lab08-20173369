<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<%

%>
<%
	List<Access> access = (List<Access>) request.getAttribute("access");
	Role role = (Role) request.getAttribute("role");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Resource</title>
<link rel="stylesheet" type="text/css" href="../../editEstilo.css"> 
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
		<h1>Editar accesos del Rol</h1>
		<form action="/roles/edit" method="post">
			<%
				for (Access ac : access) {
			%>
			<label><%=ac.getIdResource()%> </label>
			<%
				String[] op = { "", "" };
					if (ac.isStatus()) {
						op[0] = "checked";
					} else {
						op[1] = "checked";
					}
			%>
			<input type="radio" name="<%=ac.getId()%>" value="true" id="si"
				<%=op[0]%>><label for="si">Si</label> <input type="radio"
				name="<%=ac.getId()%>" value="false" id="no" <%=op[1]%>><label
				for="no">No</label> <br> <br> <br>
			<%
				}
			%>
			<input type="hidden" value="<%=role.getId()%>" name="id"> 
			<label for="nombre">Ingrese su nuevo nombre </label>
			<input type="text" value="<%=role.getNombre()%>"name="nombre"  id="nombre" required><br><br>
			<input type="submit" value="Editar">
		</form>
	</div>
	<a id="add"href="/roles" title="Lista de Roles" style="color:#ffffff;"><b>Lista de Roles<b> </a>
</body>
</html>