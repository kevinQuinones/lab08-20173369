 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<%
	Usuario user = (Usuario) request.getAttribute("user");
%>
<%
	Date ayer = (Date) request.getAttribute("date");
%>
<%
	ayer = new Date(ayer.getTime() - 86400000);
	String yester = "" + (1900 + ayer.getYear()) + "-";
	if (ayer.getMonth() < 10)
		yester = yester + "0";
	yester = yester + (ayer.getMonth() + 1) + "-";
	if (ayer.getDate() < 10)
		yester = yester + "0";
	yester = yester + ayer.getDate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuario: <%=user.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../editEstilo.css"> 
</head>
<body>
 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Usuario</h1>
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
		<form action="/users/edit" method="post">
			<h1>Editar Usuario</h1>
			<br> <label>Edite su fecha de Nacimiento</label>
			<%
				Date date = user.getBirth();
				String res = "" + (1900 + date.getYear()) + "-";
				if (date.getMonth() < 10)
					res = res + "0";
				res = res + (date.getMonth() + 1) + "-";
				if (date.getDate() < 10)
					res = res + "0";
				res = res + date.getDate();
				String hc = "", mc = "";
				if (user.isGender())
					hc = "checked";
				else
					mc = "checked";
			%>
			<input type="hidden" name="id" value="<%=user.getId()%>"><br>
			<br> <input type="date" name="date" min="1000-01-01"
				placeholder="Ingrese su fecha de Nacimiento" required
				max="<%=yester%>" value="<%=res%>"> <br> <br> <br>
			<input type="radio" name="gender" id="hombre" value="true" <%=hc%>>
			<label for="hombre">Masculino</label> <input type="radio"
				name="gender" id="mujer" value="false" <%=mc%>> <label
				for="mujer">Femenino</label>><br> <br> <label>Seleccione
				su rol: </label>
			<%
				boolean editrol = ((Boolean) request.getAttribute("editrol")).booleanValue();
				if (editrol) {
			%>
			<select name="role">
				<%
					for (Role rl : roles) {
							String se = "";
							if (rl.getNombre().equalsIgnoreCase(user.getRole())) {
								se = "selected";
							}
				%>
				<option value="<%=rl.getId()%>" <%=se%>><%=rl.getNombre()%></option>
				<%
					}
				} else {
				%>
				<p>*Usted no puede editar su rol debido  a que es el unico usuario</p>
				<%} %>
			</select> <input type="submit" value="Editar">
			<a id="add"href="/users" title="Lista de Usuarios" style="color:#ffffff;"><b>Lista de Usuarios<b> </a>
		</form>
	</div>
</body>
</html>