<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir usuario</title>
<link rel="stylesheet" type="text/css" href="../../addEstilo.css">
<script>
	function comprobar() {

		var ruc = document.formu.ruc.value;

		if (ruc.length != 11) {
			alert("No es un RUC valido!!");
			return false;
		} else {
			document.forms['formu']['Enviar'].disabled = true;
		}
		return true;
	}
</script>
</head>
<body>
	<header>
		<div class="contenedor">
			<div id="marca">
				<h1>Facturas</h1>
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
		</div>

	</header>
	<a id="add" href="/bills" title="Ver Factura"
		style="color: #26A246;">Añadir</a>
	<div id="table">
		<h1>Añadir Factura</h1>
		<h2>Ingrese:</h2>
		<form action="/bills/add" method="post" name="formu" id="formu" onsubmit="return comprobar()">
			<input type="number" name="code" placeholder="Código" required>
			<br> <br> <br> <input type="number" name="cost"
				placeholder="Costo del producto" required> <br> <br>
			<br> <input type="number" name="quant" placeholder="Cantidad"
				required> <br> <br> <br> <input type="text"
				name="name" placeholder="Nombre de la entidad" required> <br>
			<br> <br> <input type="text" name="address"
				placeholder="Dirección de la entidad" required> <br> <br>
			<br> <input type="number" name="ruc" maxlength="11"
				placeholder="RUC" required> <br> <br> <br> <input
				type="submit" value="Enviar" name="Enviar">
		</form>
	</div>
</body>
</html>