<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relation</title>

</head>
<body>
<%@include  file="index.jsp" %>
<% ArrayList<UserBean> rech = (ArrayList<UserBean>) request.getAttribute("recherche");%>
<% ArrayList<UserBean> ams = (ArrayList<UserBean>) request.getAttribute("amis");%>

<form class="form-inline" method="post" action="Relation">
  <div class="form-group mb-2">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <label for="ami" class="sr-only">Ami</label>
    <input type="text" class="form-control" id="IdAmi" name="ami" placeholder="Chercher">
    
  </div>
  <button type="submit" class="btn btn-primary mb-2">Chercher</button>
 </form>
<h3>Liste Recherche</h3>
 <% 
 if(rech != null){
	out.print("<div class='content'>");
	out.print("<div class='container'>");
	out.print("<div class='row'>");
	for(int i = 0; i < rech.size();i++){
		out.print("<div class='col-lg-4'>");
		out.print("<div class='text-center card-box'>");
		out.print("<div class='member-card pt-2 pb-2'>");
		out.print("<div class='thumb-lg member-thumb mx-auto'><img src='https://bootdey.com/img/Content/avatar/avatar2.png' class='rounded-circle img-thumbnail' alt='profile-image'></div>");
		out.print("<div class=''>");
		out.print("<h4>"+rech.get(i).getNom()+"  "+rech.get(i).getPrenom()+"</h4>");
		out.print("<p class='text-muted'>Utilisateur <span>| </span><span>"+rech.get(i).getLogin()+"</span></p>");
		out.print("</div>");
		out.print("<form class='form-inline' method='post' action='Relation'>");
		out.print("<button type='submit' class='btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light'>ajouter</button>");
		out.print("</form>");
		out.print("<div class='mt-4'>");
		out.print("<div class='row'>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
	}
	out.print("</div>");
	out.print("</div>");
	out.print("</div>");
 }else{
	 out.print("<p>Auccun résultat</p>");
 }
 %>
 <h3>Liste des Amis</h3>
 <% 
 if(ams != null){
	out.print("<div class='content'>");
	out.print("<div class='container'>");
	out.print("<div class='row'>");
	for(int i = 0; i < ams.size();i++){
		out.print("<div class='col-lg-4'>");
		out.print("<div class='text-center card-box'>");
		out.print("<div class='member-card pt-2 pb-2'>");
		out.print("<div class='thumb-lg member-thumb mx-auto'><img src='https://bootdey.com/img/Content/avatar/avatar2.png' class='rounded-circle img-thumbnail' alt='profile-image'></div>");
		out.print("<div class=''>");
		out.print("<h4>"+ams.get(i).getNom()+"  "+ams.get(i).getPrenom()+"</h4>");
		out.print("<p class='text-muted'>Utilisateur <span>| </span><span>"+ams.get(i).getLogin()+"</span></p>");
		out.print("</div>");
		out.print("<form class='form-inline' method='post' action='Relation'>");
		out.print("<button type='submit' class='btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light'>ajouter</button>");
		out.print("</form>");
		out.print("<div class='mt-4'>");
		out.print("<div class='row'>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
	}
	out.print("</div>");
	out.print("</div>");
	out.print("</div>");
 }else{
	 out.print("<p>Pas d'amis</p>");
 }
 %>
 

</body>
</html>