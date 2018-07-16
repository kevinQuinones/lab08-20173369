<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="controller.invoice.IndexController"%>
<%@ page import="model.entity.*"%>
<%List<Invoice> users = (List<Invoice>)request.getAttribute("users");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../indexEstilo.css">
<title>Lista de Usuarios</title>
</head>
<body>
	<header>
	<div class="contenedor">
		<div id="marca">
			<h1>Facturas</h1>
		</div>
	</div>

	<nav>
	<ul>
		<li class="actual"><a href="../index.html"> Inicio </a></li>
		<li><a href="/bills/add">Añadir </a></li>
		<li><a href="/bills"> Mostrar </a></li>
		<li><a href="/users"> Usuarios</a></li>
		<li><a href="/access">Accesos </a></li>
		<li><a href="/users/login"> LogIn </a></li>
		<li><a href="/users/logout"> LogOut </a></li>
	</ul>
	</nav> 
	</header>
	<a id="add" href="/bills/add" title="Añadir Usuario"
		style="color: #ffffff;">Añadir usuarios</a>
	<div id="table">
		<% if (users.isEmpty()){ %>
		<p>No se encuentran usuarios. Añada Usuarios</p>
		<%} else { %>
		<div id="tabla">
			<table>
				<thead>
					<tr>
						<th>Carné de identidad</th>
						<th>Creado</th>
						<th>Costo</th>
						<th>Cantidad</th>
						<th>Costo Total</th>
						<th>Codigo Prod.</th>
						<th>Señor(es)</th>
						<th>Direccion</th>
						<th>RUC</th>
						<th>Numero de factura</th>
					</tr>
				</thead>
				<% for (Invoice us: users){%>
				<tr>
					<td><a href="/bills/view?id=<%=us.getId()%>"><%=us.getId()%></a></td>
					<td><%=us.getMade().toString() %></td>
					<td><%=us.getCost() %></td>
					<td><%=us.getQuant() %></td>
					<td><%=us.getTotal() %></td>
					<td><%=us.getCode() %></td>
					<td><%=us.getName() %></td>
					<td><%=us.getAddress() %></td>
					<td><%=us.getRUC() %></td>
					<td><%=us.getNumber() %></td>
				</tr>
				<%} %>
			</table>
		</div>
		<%} %>
	</div>
</body>
</html>