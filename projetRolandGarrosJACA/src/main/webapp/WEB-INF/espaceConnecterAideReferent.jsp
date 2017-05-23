<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> <img id="logo"
				src="img/logo.png"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar"></div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-left">
				<h1>Coucou ${ref.prenom} et bienvenue dans ton espace connecté</h1>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>

	<footer class="container-fluid text-center">
	<div class="container">

		<div class="row">
			<div class="col-md-6">
				<h2>Membres de l'équipe</h2>
				<p>Adrien OUAIRY</p>
				<p>Antoine GUILLOIS</p>
				<p>Clara MIGNEE</p>
				<p>Jérémie HERVE</p>
			</div>
			<div class="col-md-6">
				<h2>Sodifrance</h2>
				<p>
					Parc d’Activités "La Bretèche"<br /> 35768 Saint Grégoire Cedex<br />
					02 99 23 46 00<br /> <a href="http://www.sodifrance.fr/">Plus
						d'informations</a>.
				</p>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>