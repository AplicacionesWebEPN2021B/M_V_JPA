<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
		crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
<title>Login</title>
</head>
<body class="bg-light">
	<%@include file="../templates/banner_interno.html" %>
	
	<div class="content-login w-100 d-flex flex-column justify-content-center align-items-center">
		<h1>Ingreso</h1>
		<form method="POST" action="LoginController" class="needs-validation" novalidate>
			<div class="container mt-5">
			    <div class="row d-flex justify-content-center ">
			        <div class="w-100 col-md-6">
			            <div class="card px-5 py-5" id="form1">
			                <div class="form-data">
			                    <div class="forms-inputs mb-4">
			                    	<label for="validation01 " class="h3">Usuario</label>
			                    	<br>
			                    	<input type="text" name="usuario" class="form-control" id="validation01" placeholder="Nombre de Usuario" required>
							      	<div class="invalid-feedback">
							        	Ingrese un Usuario.
							      	</div>
			                    </div>
			                    <div class="forms-inputs mb-4"> 
			                    	<label for="validation02" class="h3">Clave</label>
			                    	<br>
			                    	<input type="password" name="password" class="form-control" id="validation02" placeholder="" required>
			                    	<div class="invalid-feedback">
							        	Ingrese una Clave.
							      	</div>
							      	
			                    </div>
			                    <div class="mb-3"> 
			                    	<input type="submit" value="Ingresar" class="btn btn-primary w-100"></input> 
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
		</form>
	</div>
	
	<script>
	(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();
	</script>
</body>
</html>
