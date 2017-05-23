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
			<form id="buttonInscription" action="lienFormulaire" method="get">
				<button type="submit" class="btn btn-info">Inscription</button>
			</form>
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
					<button id="buttonConnection" type="submit" class="btn btn-success">Connection</button>
				</form>

			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-left">
				<h1>A Star Wars Story</h1>
				<hr>
				<table class="table table-hover">
					<tr>
						<td>Star Wars 1</td>
						<td>1999-10-13</td>
						<td>
							<p>Keira</p>
							<p>Natalie Portman</p>
							<p>Liam Neeson</p>
						</td>
						<td>SF</td>
					</tr>
					<tr>
						<td>Star Wars 2</td>
						<td>2002-05-17</td>
						<td>
							<p>Natalie Portman</p>
							<p>Hayden Christensen</p>
							<p>Anthony Daniels</p>
						</td>
						<td>SF</td>
					</tr>
					<tr>
						<td>Star Wars 3</td>
						<td>2005-05-18</td>
						<td>
							<p>Hayden Christensen</p>
							<p>Ewan McGregor</p>
							<p>Natalie Portman</p>
						</td>
						<td>SF</td>
					</tr>
					<tr>
						<td>Star Wars 4</td>
						<td>1977-10-19</td>
						<td>
							<p>Carrie Fisher</p>
							<p>Mark Hamill</p>
							<p>Harrison Ford</p>
						</td>
						<td>SF</td>
					</tr>
					<tr>
						<td>Star Wars 5</td>
						<td>1980-08-20</td>
						<td>
							<p>Carrie Fisher</p>
							<p>Mark Hamill</p>
							<p>Harrison Ford</p>
						</td>
						<td>SF</td>
					</tr>
					<tr>
						<td>Star Wars 6</td>
						<td>1983-10-19</td>
						<td>
							<p>Carrie Fisher</p>
							<p>Mark Hamill</p>
							<p>Harrison Ford</p>
						</td>
						<td>SF</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-2"></div>
		</div>
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
		<div name="effects" id="effectTypes" value="blind"></div>
		<c:if test="${not empty MessageErreur}">
			<div id="echecCo" class="ui-widget-content ui-corner-all">Echec
				lors de la connexion</div>
		</c:if>
	</footer>
</body>
</html>