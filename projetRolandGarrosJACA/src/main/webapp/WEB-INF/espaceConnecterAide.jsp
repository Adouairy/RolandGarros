<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Espace connecté (Aidé / Référent)</title>
<script type="text/javascript" src="./script/accordion.js"></script>
<script type="text/javascript" src="./script/script.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="./style/style.css" />
<link rel="stylesheet" type="text/css" href="./style/formulaire.css" />
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
				<h2>Bonjour ${leConnecte.prenom} ${leConnecte.nom} et bienvenue
					dans votre espace connecté</h2>
				<div class="container">
					<div class="row">
						<div class="col-sm-9 col-md-9">
							<div class="panel-group" id="accordion">
								<!-- ///////////////////////////////////////////MES INFORMATIONS//////////// -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><span
												class="glyphicon glyphicon-cog"> </span>Mes informations</a>
										</h4>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in">
										<h3>Vos informations personnelles:</h3>
										<ul>
											<li>Adresse: ${leConnecte.adresse}</li>
											<li>Téléphone: ${leConnecte.tel}</li>
											<li>Référent: ${referent.nomAidant}</li>
											<li>Médecin: ${medecin.nom}</li>
										</ul>
									</div>
								</div>
								<!-- //////////////////////////////////////////////MES AIDANTS/////////// -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseFour"><span
												class="glyphicon glyphicon-user"> </span>Gérer mes aidants</a>
										</h4>
									</div>
									<div id="collapseFour" class="panel-collapse collapse">
										<p>
											Vos aidants sont:
											<c:forEach items="${aidant}" var="aidant">

												<ul>
													<li><i>Nom: </i><b><c:out
																value="${ aidant.nomAidant }" /></b> <i> Prenom :</i> <c:out
															value="${ aidant.prenomAidant }" /></li>
												</ul>
											</c:forEach>
										<form action="espaceConnecterAide" method="POST">
										<p>Nom :</p>
											<input type="text" name="nomAidant" placeholder="Nom de l'aidant"/>
										<p>E-mail :</p>
											<input type="email" name="mailAidant" placeholder="E-mail de l'aidant"/>
										<p class="messageErreur">${messageAjoutAidant}</p>
											<input type="submit" name="valider_form"
												value="Ajouter Aidants" />
										</form>

									</div>
								</div>
								<!-- ///////////////////////////////////////////////AGENDA////////// -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo"><span
												class="glyphicon glyphicon-calendar"> </span>Agenda</a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div id="datepicker3"></div>
									</div>
								</div>
								<!-- ////////////////////////////////////////////////COMPTE RENDU///////// -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseThree"><span
												class="glyphicon glyphicon-paste"> </span>Compte Rendu</a>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse collapse">
										<p>Salut les copains</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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
					Parc d'Activités "La Bretéche"<br /> 35768 Saint Grégoire Cedex<br />
					02 99 23 46 00<br /> <a href="http://www.sodifrance.fr/">Plus
						d'informations</a>.
				</p>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>