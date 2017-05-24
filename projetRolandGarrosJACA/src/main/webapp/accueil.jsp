<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
		<div class="collapse navbar-collapse" id="myNavbar">

			<!-- 			<div class="nav navbar-nav navbar-right row"> -->
			<form id="buttonInscription" class="col-sm-3" action="lienFormulaire"
				method="get">
				<button type="submit" class="btn btn-info">Inscription</button>
			</form>
			<form class="navbar-form navbar-right col-sm-9" action="accueil"
				method="get">
				<div class="form-group">
					<select name="select" id="select">
						<option value="aide">Aidé</option>
						<option value="aidant" selected>Aidant</option>
						<option value="medecin">Médecin</option>
					</select>
				</div>
				<div class="form-group">
					<input type="email" placeholder="Email" name="email"
						class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Mot de passe"
						name="mdpIdentifiant" class="form-control">
				</div>
				<button id="buttonConnection" type="submit" class="btn btn-success">Connection</button>
			</form>
			<!-- 			</div> -->
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-left">
				<h1>A Star Wars Story</h1>
				<hr>
				<div>
					<p>Autonomia est une plateforme unifiée de services destinée à
						sécuriser la vie des personnes dépendantes et faciliter
						l'intervention des aidants. En effet 20 millions de Français sont
						concernés par le handicap et la dépendance en tant qu'aidé et/ou
						aidant (11 millions d'aidants). Autonomia propose de s'intéresser
						à 6 types d'handicapes :</p>
					<ul>
						<li>Moteur</li>
						<li>Visuel</li>
						<li>Auditif</li>
						<li>Cognitif</li>
						<li>Maladies invalidantes</li>
						<li>Séniorité</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
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
					Parc d'Activités "La Bretèche"<br /> 35768 Saint Grégoire Cedex<br />
					02 99 23 46 00<br /> <a href="http://www.sodifrance.fr/">Plus
						d'informations</a>.
				</p>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>