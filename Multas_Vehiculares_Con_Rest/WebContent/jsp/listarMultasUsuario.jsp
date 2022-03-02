<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Multas</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
		crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar_style.css">
</head>
<body>
	<%@include file="../templates/banner_login.html" %>
	
	<div class="content-login w-100 d-flex flex-column justify-content-center align-items-center">
		<br><br>
		<h1>Informaci&oacute;n del veh&iacute;culo</h1>
		<form method="POST" action="ConsultarMultasUsuarioController">
			<div class="container mt-5">
			    <div class="row d-flex justify-content-center ">
			        <div class="w-100 col-md-6">
			            <div class="card px-5 py-5" id="form1">
			                <div class="form-data">
			                    <div class="forms-inputs mb-4"> 
			                    	<br>
			                    	<h4>Placa: ${usuario.placa}</h4><br>
									<h4>A&ntilde;o: ${usuario.anio}</h4>
			                    </div>
			                    <div class="forms-inputs mb-4"> 
									<h4>Marca: ${usuario.marca}</h4><br>
									<h4>Modelo: ${usuario.modelo}</h4><br>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
		</form>
	</div>
	
	<div class="wrapper">
		<h2>Multas</h2>
		<c:if test="${multasUsuario.size()==0}">
			<div>
				Este vehículo no tiene multas
			</div>
		</c:if>
		<c:if test="${multasUsuario.size()>0}">
			<table class="table m-2">
				<caption>Multas del vehículo con placa: ${usuario.placa}</caption>
				<thead class="thead-dark">
					<tr>
						<th>DESCRIPCIÓN DEL RUBRO</th>
						<th>VALOR</th>
						<th>AÑO</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${multasUsuario}" var="multa">
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