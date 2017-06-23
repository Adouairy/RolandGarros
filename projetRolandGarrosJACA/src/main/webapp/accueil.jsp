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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="style/style.css" />
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
			<!-- test confilt git tortoise 1 -->

			<p>test confilt git tortoise 1 modifier par adrien et cr�er par mick</p>

			<!-- 			<div class="nav navbar-nav navbar-right row"> -->
			<form id="buttonInscription"
				class="navbar-form navbar-right col-sm-3" action="lienFormulaire"
				method="get">
				<button type="submit" class="btn btn-info">Inscription</button>
			</form>
			<form class="navbar-form navbar-right col-sm-9" action="accueil"
				method="get">
				<div class="form-group">
				<p>syso+ctrl+entree("Hello World")</p>
					<select name="select" id="select">
						<option value="aide">Aid�</option>
						<option value="aidant" selected>Aidant</option>
						<option value="medecin">M�decin</option>
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
	<!-- test confilt git tortoise 2 -->
	<p>test confilt git tortoise 2</p>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-left">
				<h1>Autonomia</h1>
				<hr>
				<div>
					<p>Autonomia est une plateforme unifi�e de services destin�e �
						s�curiser la vie des personnes d�pendantes et faciliter
						l'intervention des aidants. En effet 20 millions de Fran�ais sont
						concern�s par le handicap et la d�pendance en tant qu'aid� et/ou
						aidant (11 millions d'aidants). Autonomia propose de s'int�resser
						� 6 types d'handicapes :</p>
					<p class="ulCenter">
					<ul>
						<li>Moteur</li>
						<li>Visuel</li>
						<li>Auditif</li>
						<li>Cognitif</li>
						<li>Maladies invalidantes</li>
						<li>S�niorit�</li>
					</ul>
					</p>
					<p>Ces diff�rents handicapes sont parfois associ�s � des objets
						connect�s tels que des bracelets, des cannes blanches ou encore
						des lunettes, etc. Selon le type de handicap les aidants seront de
						diff�rents types, il y a notamment les proches, le personnel
						m�dical, les service � la personne ainsi que des artisans.</p>
					<p>Beaucoup d'initiatives et de services voient le jour mais il
						est difficile voire impossible d'avoir une vision consolid�e et
						globalisante. Les services et/ou les objets ne couvrent en g�n�ral
						qu'une seule probl�matique et propose un back-office d�di�
						faiblement interop�rable.</p>
					<p>Autonomia a pour objectif de d�velopper l'autonomie pour
						mieux vivre ensemble. Que les personnes fragilis�es puissent vivre
						dans un climat de confiance et de s�curit� et que les aidants
						puisse agir efficacement pour les aider.</p>
					<p>Elle se positionne en tant qu'HUB d'int�gration de services
						et d'objets facilitant la vie des aidants et des aid�es, ceci de
						mani�re :</p>
					<p class="ulCenter">
					<ul>
						<li>Simple</li>
						<li>Fiable</li>
						<li>Interop�rable</li>
						<li>Usage</li>
					</ul>
					</p>
					<p>AUTONOMIA se base sur les 4 services suivants :</p>
					<ul>
						<li><span class="aSouligner">Suzanne & L�a</span> est un
							service qui propose des solutions innovantes d'entraide destin�e
							� accompagner et s�curiser le quotidien des personnes fragilis�es
							et faciliter l'intervention des aidants.</li>
						<li><span class="aSouligner">EasyCity</span> est un r�seau
							social d'entraide destin� � faciliter et am�liorer les
							d�placements des personnes d�pendantes.</li>
						<li><span class="aSouligner">PuisJeVousAider</span> propose
							des solutions d'accueil personnalis� pour personnes fragilis�es
							destin�e aux �tablissement commerciaux et publics.</li>
						<li><span class="aSouligner">Les services partenaires</span>
							permettent l'int�gration d'�v�nements en provenances d'objets
							connect�s et de services partenaires.</li>
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
				<h2>Membres de l'�quipe</h2>
				<p>Adrien OUAIRY</p>
				<p>Antoine GUILLOIS</p>
				<p>Clara MIGNEE</p>
				<p>J�r�mie HERVE</p>
			</div>
			<div class="col-md-6">
				<h2>Sodifrance</h2>
				<p>
					Parc d'Activit�s "La Bret�che"<br /> 35768 Saint Gr�goire Cedex<br />
					02 99 23 46 00<br /> <a href="http://www.sodifrance.fr/">Plus
						d'informations</a>.
				</p>
			</div>
		</div>
	</div>
	<c:if test="${not empty MessageErreur}">
		<div id="echecCo" class="ui-widget-content ui-corner-all">Echec
			+ lors de la connexion</div>
	</c:if> </footer>
</body>
</html>