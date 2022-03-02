<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Vehículo</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">

</head>
<body>
	<%@include file="../templates/banner_interno.html" %>
	<div class="container-fluid" style="width: 500px; margin-top: 25px">
		<h2>Registrar Vehículo</h2>
	
		<form method="POST" action="RegistrarVehiculoController">
			<fieldset>
				<label for="txtPlaca">PLACA:</label>
				<input type="text" name="txtPlaca" required class="form-control">
				<br>
				<label for="txtMarca">MARCA:</label>
				<input type="text" name="txtMarca" required class="form-control">
				<br>
				<label for="txtAnio">AÑO:</label>
				<input type="text" name="txtAnio" pattern="\d{4}$" required class="form-control">
				<br>
				<label for="txtModelo">MODELO:</label>
				<input type="text" name="txtModelo" required class="form-control">
				<br>
				<label for="txtChasis">CHASIS:</label>
				<input type="text" name="txtChasis" required class="form-control">
				<br>
				<label for="txtPropietario">PROPIETARIO:</label>
				<input type="text" name="txtPropietario" required class="form-control">
				<br>			
				<input type="submit" value="Registrar Vehículo" class="btn btn-primary">
			</fieldset>				
	</form>
	</div>
	
	
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	
</body>
</html>