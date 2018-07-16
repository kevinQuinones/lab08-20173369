<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import ="model.entity.*" %>
	<%@page import ="java.util.Date" %>
	<%Invoice invoice = (Invoice)request.getAttribute("invoice"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Editar Usuario: <%=invoice.getId() %></title>
		<link rel="stylesheet" type="text/css" href="../../editEstilo.css"> 
			
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
		<a id="add"href="/bills" title="Lista de Usuarios" style="color:#ffffff;"><b>Lista de Facturas<b> </a>
		<div id="table">
			<form action="/bills/edit" method="post">
				<h1>Editar Usuario</h1>
				<label>Edite el costo . </label>
				<input type="number" name="cost" placeholder="Ingrese el costo" value="<%=invoice.getCost() %>" required> <br><br><br>
				<label>Edite la fecha de compra</label>
				<%Date date = invoice.getMade();
				String res =""+ (1900+date.getYear())+"-";
				if (date.getMonth()<10) res=res+"0";
				res=res+(date.getMonth()+1)+"-";
				if (date.getDate()<10) res=res+"0";
				res=res+date.getDate();
				%>
				<input type="hidden" name="id" value="<%=invoice.getId() %>">
				<input type="date" name="date" placeholder="Edite la fecha de compra" required value="<%=res %>"> <br><br><br>
			    <label>Edite el codigo . </label><input type="number" name="code" placeholder="Edite el codigo" value="<%=invoice.getCode() %>" required> <br><br><br>
			    <label>Edite la cantidad . </label><input type="number" name="quant" placeholder="Edite la cantidad" value="<%=invoice.getQuant() %>" required> <br><br><br>
			    <label>Edite el nombre de la empresa . </label><input type="text" name="name" placeholder="Edite el nombre del Señor(es)" value="<%=invoice.getName() %>" required> <br><br><br>
			    <label>Edite la direccion . </label><input type="text" name="address" placeholder="Edite la direccion" value="<%=invoice.getAddress() %>" required> <br><br><br>
			    <label>Edite el RUC . </label><input type="number" name="ruc" placeholder="Edite el RUC" value="<%=invoice.getRUC() %>" required> <br><br><br>
				<input type="submit" value="Editar">
			</form>
		</div>
	</body>
</html>