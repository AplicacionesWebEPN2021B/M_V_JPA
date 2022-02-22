<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Multa</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
		crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<%@include file="../templates/banner_interno.html" %>
<div class="container-fluid" style="width: 500px; margin-top: 100px">
<h2>Ingreso Valores a Pagar</h2>
	<form action="RegistrarMultaController?idVehiculo=${vehiculo.idVehiculo}" method="POST">
		<label for="txtPlaca">PLACA: </label>
		<input type="text" name="txtPlaca" value="${vehiculo.placa}" readonly="readonly" class="form-control"><br>
		<label for="txtDescripcion">DESCRIPCIÓN DEL RUBRO:</label>
		<input type="text" name="txtDescripcion" required="required" class="form-control" placeholder="Ej. Licencia Caducada"><br>
		<label for="txtValor">VALOR:</label>
		<input type="number" name="txtValor" required="required" class="form-control" placeholder="Ej. 460"><br>
		<label for="txtAnio">AÑO</label>
		<input type="text" name="txtAnio" required="required" class="form-control" placeholder="Ej. 2022"><br>
		<input type="submit" value="Registrar Multa" class="btn btn-primary">
	</form>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
		crossorigin="anonymous"></script>
</body>
</html>