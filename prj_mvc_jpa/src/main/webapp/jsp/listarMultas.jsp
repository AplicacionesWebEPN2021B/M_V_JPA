<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multas</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
		crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
	<%@include file="../templates/banner_interno.html" %>
	
	<div class="wrapper">
		<h2>Deudas vehículo: ${placa}</h2>
		<div>
			<a href="ListarVehiculosController" class="btn btn-outline-dark m-2">Regresar</a>
			<a href="RegistrarMultaController?idVehiculo=${vehiculo.idVehiculo}"  class="btn btn-primary  m-2">Nueva Multa</a>
		</div>
		<c:if test="${multas.size()==0}">
			<div>
				Este vehículo no tiene multas
			</div>
		</c:if>
		<c:if test="${multas.size()>0}">
			<table class="table m-2">
				<caption>Multas del vehículo con placa: ${vehiculo.placa}</caption>
				<thead class="thead-dark">
					<tr>
						<th>DESCRIPCIÓN DEL RUBRO</th>
						<th>VALOR</th>
						<th>AÑO</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${multas}" var="multa">
						<tr>
							<td>${multa.descripcion}</td>
							<td>${multa.valor}</td>
							<td>${multa.anio}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
		crossorigin="anonymous"></script>
</body>
</html>