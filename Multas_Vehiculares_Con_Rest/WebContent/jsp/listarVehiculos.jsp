<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Vehiculos</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<body>	
	<%@include file="../templates/banner_interno.html" %>

	<div class="wrapper">
		<h1>Listado de Vehículos</h1>
		<div>
			<a href="RegistrarVehiculoController"class="btn btn-primary m-2">Nuevo Vehículo</a>
		</div>
		<table class="table m-2">
			<caption>Vehículos registrados</caption>
			<thead>
	            <tr>            
	                <th>PLACA</th>
	                <th>MARCA</th>
	                <th>AÑO</th>
	                <th>MODELO</th>
	                <th>CHASIS</th>
	                <th>PROPIETARIO</th>
	                <th>ACCIONES</th>
	            </tr>          	
	       </thead>
	        <c:forEach items="${listaVehiculos}" var="vehiculo">
	         <tr>          
                <td>${vehiculo.placa}</td>	
                <td>${vehiculo.marca}</td>	
                <td>${vehiculo.anio}</td>	
                <td>${vehiculo.modelo}</td>	
                <td>${vehiculo.chasis}</td>	
                <td>${vehiculo.propietario}</td>	
                <td> 
                	<a class="btn btn-outline-info btn-sm" href="ListarMultasController?idVehiculo=${vehiculo.idVehiculo}">Ver multas</a> | 
                	<a class="btn btn-outline-warning btn-sm" href="ActualizarVehiculoController?idVehiculo=${vehiculo.idVehiculo}">Actualizar</a> | 
                	<a class="btn btn-outline-danger btn-sm" href="EliminarVehiculoController?idVehiculo=${vehiculo.idVehiculo}">Eliminar</a>
                </td>
             </tr>
	        </c:forEach>                      
			
        </table>        
	</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
</body>
</html>