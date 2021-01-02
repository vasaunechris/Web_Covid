<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acitivite</title>
</head>
<body>
<%@include  file="index.jsp" %>

<h2 align="center" class="display-4">Activité</h2>

<h3>Ajouter une activité</h3>

<form method="post" action="Activite" >

   <div class="form-row">
	<div class="col-md-4 mb-3">
      <label for="idNom">Nom Activité</label>
      <input type="text" class="form-control " id="idNom" name ="nom" value="" placeholder="Nom activité" required>
    </div>
   </div>
  <div class="form-row">
   <div class="col-md-4 mb-3">
     <label for="idUtilisateur">Heure de debut</label>
     <div class="input-group">
       <input type="time" id="IdHeureD" name="heureD" value="12:00" required>
     </div>
   </div>
  </div>
  
  <div class="form-row">
   <div class="col-md-4 mb-3">
     <label for="idUtilisateur">Heure de fin</label>
     <div class="input-group">
       <input type="time" id="IdHeureF" name="heureF" value="14:00" required>
     </div>
   </div>
  </div>
  
  <div class="form-row">
  <div class="form-group col-sm-2">
  	<label for="idDate">Date</label>
  	<div class="input-group">
	<input type="date" id="idDate" class="form-control " name="date" value="2018-07-22" aria-describedby="inputGroupPrepend4" required>
	</div>
  </div>
  </div>
  
  <div class="form-row">
    <div class="col-auto my-1">
      <label  for="idGenre">Liste des lieux</label>
      <select class="form-select custom-select mr-sm-2 " id="idGenre" name="lieu" required>
        <option selected disabled value="">Liste de Lieux ...</option>
        <% 
        if(lieux != null){
        	for(int i = 0; i < lieux.size();i++){
        		out.print("<option value="+lieux.get(i).getId()+"> nom : "+lieux.get(i).getDenomination()+", adresse : "+lieux.get(i).getAdresse()+"</option>");
        	}
        }
        %>
      </select>
    </div>
  </div>
  
  <button class="btn btn-primary" type="submit">Ajouter</button>
  
</form>
<h3>Mes Activités</h3>
<% 
if(activites != null){
out.print("<div class='container'>");
	for(int i = 0; i < activites.size();i++){
		out.print("<div class='card mt-5 border-5 pt-2 active pb-0 px-3'>");
		out.print("<div class='card-body '>");	
		out.print("<div class='row'>");
		out.print("<div class='col-12 '>");
		out.print("<h4 class='card-title '><b>"+activites.get(i).getNom()+"</b></h4>");
		out.print("</div>");
		out.print("<div class='col'>");
		out.print("<h6 class='card-subtitle mb-2 text-muted'>");
		out.print("<p class='card-text text-muted small'>De :<span class='font-weight-bold'>"+activites.get(i).getHeureD()+"</span> à : <span class='font-weight-bold'> "+activites.get(i).getHeureF()+"</span> Le : <span class='font-weight-bold'> "+activites.get(i).getDate()+" </span></p>");
		out.print("</h6>");
		out.print("<h6 class='card-subtitle mb-2 text-muted'>");
		out.print("<p class='card-text text-muted small '>Aux :<span class='font-weight-bold'> "+activites.get(i).getLieu().getAdresse()+"</span> </p>");
		out.print("</h6>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
	}
out.print("<div class='container'>");
}else{
	out.print("<p>pas d'activité</p>");
}
%>
</body>
</html>