<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="jumbotron.css" rel="stylesheet">
  		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<% Object v = session.getAttribute("current_user"); %>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="Home.jsp">CovidContact</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="Home.jsp">Acceuille <span class="sr-only">(current)</span></a>
		      </li>
		      <%  
		      if(v != null){
		    	out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Deconnection.jsp'>Se Deconnecter</a>");
		  		out.print("</li>");
		      }else{
	    	  	out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Connection.jsp'>Se Connecter</a>");
		  		out.print("</li>");
		      }
		      %>
		      <% 
		      if(v != null){
		    	out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Profil.jsp'>Profil</a>");
		  		out.print("</li>");
		      }else{
	    	  	out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Inscription.jsp'>S'inscrire</a>");
		  		out.print("</li>");
		      }
		      %>
		    </ul>
		  </div>
		</nav>
	</body>
</html>