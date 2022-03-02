<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar_style.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">


            <title>Consulta de multas</title>
        </head>

        <body>

            <%@include file="../templates/banner_usuario.html" %>


                <div class="content-login w-100 d-flex flex-column justify-content-center align-items-center">
                    <h1>Consulta de Multas Pendientes</h1>
                    <form method="POST" action="ConsultarMultasUsuarioController" class="needs-validation" novalidate>
                        <div class="container mt-5">
                            <div class="row d-flex justify-content-center ">
                                <div class="w-100 col-md-6 text-center">
                                    <div class="card px-5 py-5 text-center" id="form1">
                                        <div class="form-data">
                                            <div class="forms-inputs mb-4 justify-content-center align-items-center">
                                                <h3>Seleccione Tipo de B&uacute;squeda</h3><br>
                                                <input type="radio" name="placaChasis" value="r" checked> Placa
                                                <input type="radio" name="placaChasis" value="r1"> Chasis
                                            </div>
                                            <div class="forms-inputs mb-4 justify-content-center align-items-center">
                                                <label for="txtDato">Ingrese el Dato</label>
                                                <br>
                                                <input type="text" id="txtDato" class="form-control" name="txtPlacaChasis" required>
                                                <div class="invalid-feedback">
										        	Porfavor Ingrese un Dato.
										      	</div>
                                            </div>
                                            <button type="submit" class="btn btn-outline-primary btn-sm" name="consultar" value="consultar">Consultar</button>
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