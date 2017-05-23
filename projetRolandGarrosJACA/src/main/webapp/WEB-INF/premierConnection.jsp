<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Première connexion</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./style/formulaire.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="./script/script.js"></script>
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
				<fieldset id="infoCompl">
					<h1>Informations complémentaires</h1>
					<form method="get" action="premierConnection">

						<p>Prénom :</p>
						<input type="text" name="iPrenomAidant" placeholder="Votre prénom"
							required />

						<p>Adresse :</p>
						<input type="text" name="iAdresseAidant"
							placeholder="Votre adresse postale" required />

						<p>Date de naissance :</p>
						<input type="text" name="iDdnAidant"
							placeholder="Votre date de naissance" id="datepicker" required />


						<p>Numéro de téléphone :</p>
						<input type="text" name="iTelAidant"
							placeholder="Votre numéro de téléphone" required />

						<p>Mot de passe :</p>
						<input type="password" name="iMdpAidant"
							placeholder="Votre mot de passe" required /><br />

						<p>Confirmation du mot de passe :</p>
						<input type="password" name="iConfirmAidant"
							placeholder="Confirmation du mot de passe" required />

						<p class="messageErreur">${messageVerifMdp}</p>

						<p>Catégorie d'aidant :</p>
						<select name="catAidant" required>
							<option value="proche">Proche</option>
							<option value="Artisan">Artisan</option>
							<option value="personnelMedical">Personnel médical</option>
						</select><br /><br/>

						<p id="inputSubmit">
							<input type="submit" value="Envoyer les informations" />
						</p>
					</form>
				</fieldset>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>

	<footer class="container-fluid text-center">
	<div class="container">

		<div class="row">
			<div class="col-md-6">
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
			<div class="col-md-6">
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
		</div>
	</div>
	</footer>
</body>
</html>