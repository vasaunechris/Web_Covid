<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="jumbotron.css" rel="stylesheet">
  		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.BeansPackage.UserBean"%>
	<%@ page import="com.BeansPackage.LieuBean"%>
	<%@ page import="com.BeansPackage.ActiviteBean"%>
	<% UserBean v = (UserBean) session.getAttribute("current_user");%>
	<% ArrayList<UserBean> rech = (ArrayList<UserBean>) request.getAttribute("recherche");%>
	<% ArrayList<UserBean> ams = (ArrayList<UserBean>) session.getAttribute("amis");%>
	<% ArrayList<LieuBean> lieux = (ArrayList<LieuBean>) session.getAttribute("lieux");%>
	<% ArrayList<ActiviteBean> activites = (ArrayList<ActiviteBean>) session.getAttribute("activites");%>
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
		  		
		  		out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Profil.jsp'>Profil</a>");
		  		out.print("</li>");
		  	
		  		out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Relation.jsp'>Relation</a>");
		  		out.print("</li>");
		  		
		  		out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Activite.jsp'>Activité</a>");
		  		out.print("</li>");
		      }else{
	    	  	out.print("<li class='nav-item'>");
		  		out.print("<a class='nav-link' href='Connection.jsp'>Se Connecter</a>");
		  		out.print("</li>");
		  		
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