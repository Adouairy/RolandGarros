<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'inscription</title>
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
				<fieldset id="inscription">
					<h1>Inscription de l'aidé</h1>
					<form method="get" action="formulaire">
						<div class="row content">
							<fieldset class="col-sm-4">
								<legend>Aidé</legend>
								<p>Nom :</p>
								<input type="text" name="nomAide" placeholder="Votre nom"
									required />
								<p>Prénom :</p>
								<input type="text" name="prenomAide" placeholder="Votre prenom"
									required />
								<p>E-mail :</p>
								<input type="email" name="mailAide" placeholder="Votre E-mail"
									required />
								<p class="messageErreur">${messageMailAide}</p>
								<p>Adresse postale :</p>
								<input type="text" name="adresseAide"
									placeholder="Votre adresse postale" required />
								<p>Numéro de téléphone :</p>
								<input type="text" name="telAide"
									placeholder="Votre numéro de téléphone" required />
								<p>Date de naissance :</p>
								<input type="text" name="ddnAide"
									placeholder="Votre date de naissance" class="datepicker"
									required />
								<p>Mot de passe :</p>
								<input type="password" name="mdpAide"
									placeholder="Votre mot de passe" required /><br />
								<p>Confirmation du mot de passe :</p>
								<input type="password" name="confirmAide"
									placeholder="Confirmation du mot de passe" required />
								<p class="messageErreur">${messageVerifMdp}</p>
								<p>Choix du médecin traitant :</p>
								<select name="database1" required>
									<c:forEach items="${listMedecin}" var="listMedecinValue"
										varStatus="status">
										<option value="${listMedecinValue.idMedecin}">Dr.
											${listMedecinValue.nom} ${listMedecinValue.prenom}</option>
									</c:forEach>
								</select><br />
								<p class="messageErreur">${messageValidAide}</p>
							</fieldset>
							<fieldset class="col-sm-4">
								<legend>Référent</legend>
								<p>Nom :</p>
								<input type="text" name="nomRef" placeholder="Nom Référent"
									required />
								<p>Prénom :</p>
								<input type="text" name="prenomRef"
									placeholder="Prenom Référent" required />
								<p>E-mail :</p>
								<input type="email" name="mailRef" placeholder="E-mail Référent"
									required />
								<p class="messageErreur">${messageVerifMailRef}</p>
								<p>Adresse postale :</p>
								<input type="text" name="adresseRef"
									placeholder="Adresse postale Référent" required />
								<p>Date de naissance :</p>
								<input type="text" name="ddnRef"
									placeholder="Date de naissance Référent annee/mois/date"
									class="datepicker" required />
							</fieldset>
							<fieldset class="col-sm-4">
								<legend>Aidant :</legend>
								<p>Nom :</p>
								<input type="text" name="nomAidant" placeholder="Votre nom" />
								<p>E-mail :</p>
								<input type="email" name="mailAidant" placeholder="Votre E-mail" />
								<p class="messageErreur">${messageAjoutAidant}</p>
							</fieldset>
						</div>
						<p id="inputSubmit">
							<input type="submit" value="Valider l'inscription" />
						</p>
					</form>
				</fieldset>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<footer class="container-fluid text-center">
	<div class="container">
		<!-- Example row of columns -->
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

<!-- 	<p>${listeMessage[0]} </p> -->