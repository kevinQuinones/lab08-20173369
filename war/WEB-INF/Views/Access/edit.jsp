<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.Date"%>
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
<title>Editar Accesso: <%=access.getId()%></title>
<link rel="stylesheet" type="text/css" href="../../editEstilo.css"> 
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
		<form action="/access/edit" method="post">
			<h1>Editar Accesso</h1>
			<label>Estado: </label>
			<%
				String[] op = { "", "" };
				if (access.isStatus()) {
					op[0] = "checked";
				} else {
					op[1] = "checked";
				}
			%>
			<input type="radio" name="is" value="true" id="si" <%=op[0]%>><label
				for="si">Si</label> <input type="radio" name="is" value="false"
				id="no" <%=op[1]%>><label for="no">No</label> <input
				type="hidden" name="id" value="<%=access.getId()%>"><br>
			<br> <br> <input type="submit" value="Editar">
				<a id="add"href="/access" title="Lista de Accesos" style="color:#ffffff;"><b>Lista de Accesos<b> </a>
		</form>
	</div>
</body>
</html>