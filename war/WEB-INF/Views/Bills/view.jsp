<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import ="model.entity.*" %>
	<%Invoice user = (Invoice)request.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" type="text/css" href="../../viewEstilo.css"> 
		<title>Invoice: <%=user.getId() %></title>
		
	</head>
	<body>
	 <header>
<div class="contenedor">
	<div id="marca">
		<h1> Facturas </h1>
</div>
<nav>
	<ul>
		<li class="actual"><a href="../index.html"> Inicio </a></li>
		<li><a href="/bills/add">Añadir  </a></li>
		<li><a href="/bills"> Mostrar </a></li>
		<li><a href="/users"> Usuarios</a></li>
		<li><a href="/access">Accesos  </a></li>
		<li><a href="/users/login"> LogIn </a></li>
		<li><a href="/users/logout"> LogOut </a></li>
	</ul>
</nav>
</header>
		<a id="add"href="/bills" title="Añadir Usuario" id="volver"></a>
		<div id="table">
			<h1 id="id" name="<%=user.getId() %>">Perfil de Usuario: </h1>
			<table>
				<tr>
					<td>ID de usuario</td>
					<td><%=user.getId() %></td>
				</tr>
				<tr>
					<td>Fecha de creacion</td>
					<td><%=user.getMade() %></td>
				</tr>
				<tr>
					<td>Costo Unitario</td>
					<td><%=user.getCost() %></td>
				</tr>
				<tr>
					<td>Cantidad</td>
					<td><%=user.getQuant() %></td>
				</tr>
				<tr>
					<td>Costo total</td>
					<td><%=user.getTotal() %></td>
				</tr>
				
				<tr>
					<td>Nombre del Señor(es)</td>
					<td><%=user.getName() %></td>
				</tr>
				<tr>
					<td>Dirección</td>
					<td><%=user.getAddress() %></td>
				</tr>
				<tr>
					<td>Código</td>
					<td><%=user.getCode() %></td>
				</tr>
				<tr>
					<td>RUC</td>
					<td><%=user.getRUC() %></td>
				</tr>
				<tr>
					<td>Número de factura</td>
					<td><%=user.getNumber() %></td>
				</tr>
				
			</table>
		</div>
		<div id="action">
				<a href="/bills/edit?id=<%=user.getId() %>" >Editar</a>
				-----
				<form action="/bills/delete" method="post">
					<input type="hidden" value="<%=user.getId() %>" name="id">
					<input type="submit" value="Eliminar">
				</form>
		</div>
	</body>
</html>