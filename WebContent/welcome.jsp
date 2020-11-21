<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuestra tienda virtual</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/card.css">
</head>
<body>

<!-- Team -->
<section id="team" class="pb-5">
    <div class="container">
        <h5 class="section-title h1">SERVICIOS</h5>
        <div class="row  justify-content-center pb-5">
  
            <div class="col-xs-12 col-sm-6 col-md-3">
            	<a href="TiendaController?action=login" class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light" type="submit">Login</a>
            </div>

            <div class="col-xs-12 col-sm-6 col-md-3 align-self-center">
            	<a href="TiendaController?action=nuevo" class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light" type="submit">Registrate</a>
            </div>
            
            <div class="col-xs-12 col-sm-6 col-md-3 align-self-center">
            	<a href="TiendaController?action=listar" class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light" type="submit">Index</a>
            </div>
        </div>
      </div>
</section>
</body>
</html>