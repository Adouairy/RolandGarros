<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'inscription</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="formulaire.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			<ul class="nav navbar-nav">
				<!-- 				<li class="active"><a href="#">Tournoi</a></li> -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Tournoi <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Simple messieurs</a></li>
						<li><a href="#">Simple dames</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Double messieurs</a></li>
						<li><a href="#">Double dames</a></li>
						<li><a href="#">Double mixte</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Simples Juniors Garçons et Filles</a></li>
						<li><a href="#">Doubles Juniors Garçons et Filles</a></li>
					</ul></li>
				<li><a href="#">Programme</a></li>
				<li><a href="#">Joueurs</a></li>
				<li><a href="#">Court</a></li>
				<li><a href="#">Live</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-right" action="accueil" method="get">
					<div class="form-group">
						<select name="select" id="select">
							<option value="aide">Personne Aidée</option>
							<option value="aidant" selected>Personne Aidant</option>
							<option value="medecin">Personne corp médical</option>
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
					<button type="submit" class="btn btn-success">Connection</button>
					<br /> <a href="WEB-INF/inscription">Inscription</a>
				</form>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-left">
				<fieldset id="inscription">
					<h1>Inscription de l'aidé</h1>
					<form method="get" action="formulaire">
						<div class="row content">
							<fieldset class="col-sm-4">
								<legend>Aidé</legend>
								<p>Nom</p>
								<input type="text" name="nomAide" placeholder="Votre nom" />
								<p>Prénom</p>
								<input type="text" name="prenomAide" placeholder="Votre prenom" />
								<p>E-mail</p>
								<input type="email" name="mailAide" placeholder="Votre E-mail" />
								<p>Adresse postale</p>
								<input type="text" name="adresseAide"
									placeholder="Votre adresse postale" />
								<p>Date de naissance</p>
								<input type="text" name="ddnAide"
									placeholder="Votre date de naissance" />
								<p>Mot de passe</p>
								<input type="password" name="mdpAide"
									placeholder="Votre mot de passe" /><br />
								<p>Confirmation du mot de passe</p>
								<input type="password" name="confirmAide"
									placeholder="Confirmation du mot de passe" />
								<p>Choix du médecin traitant</p>
								<select>
									<option>a</option>
									<option>b</option>
									<option>c</option>
									<option>d</option>
								</select><br />
							</fieldset>
							<fieldset class="col-sm-4">
								<legend>Référent</legend>
								<p>Nom</p>
								<input type="text" name="nomRef" placeholder="Nom Référent" />
								<p>Prénom</p>
								<input type="text" name="prenomRef"
									placeholder="Prenom Référent" />
								<p>E-mail</p>
								<input type="email" name="mailRef" placeholder="E-mail Référent" />
								<p>Adresse postale</p>
								<input type="text" name="adresseRef"
									placeholder="Adresse postale Référent" />
								<p>Date de naissance</p>
								<input type="text" name="ddnRef"
									placeholder="Date de naissance Référent" />
							</fieldset>
							<fieldset class="col-sm-4">
								<legend>Aidant</legend>
								<select>
									<option>a</option>
									<option>b</option>
									<option>c</option>
									<option>d</option>
								</select><br />
								<br />
								<p>Nom</p>
								<input type="text" name="nomAidant" placeholder="Votre nom" />
								<p>E-mail</p>
								<input type="email" name="mailAidant" placeholder="Votre E-mail" />
							</fieldset>
						</div>
						<p id="inputSubmit">
							<input type="submit" value="Valider l'inscription" />
						</p>
			</div>
			</form>
			</fieldset>
		</div>
		<div class="col-sm-2"></div>
	</div>
	</div>
	<footer class="container-fluid text-center">
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>
	</footer>
</body>
</html>