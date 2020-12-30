<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Profil</title>
</head>
<body>
<%@include  file="index.jsp" %>

<h3 align="center" >Modifier Profil</h3>

<form method="post" action="ProfilEditeur" >

  <div class="form-row">
  
    <div class="col-md-4 mb-3">
      <label for="idNom">Nom</label>
      <input type="text" class="form-control " id="idNom" name ="nom" value="${current_user.getNom()}" placeholder="Nom" required>
      <div class="invalid-tooltip">

        ${valide.getErreurs().get('nom')}
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="idPrenom">Prenom</label>
      <input type="text" class="form-control " value="${current_user.getPrenom()}" id="idprenom" name="prenom" placeholder="Prenom" required>
      <div class="valid-feedback">
        ${valide.getErreurs().get('prenom')}
      </div>
    </div>
  </div>
  
  <div class="form-row">
   <div class="col-md-4 mb-3">
     <label for="idUtilisateur">Nom d'utilisateur</label>
     <div class="input-group">
       <input type="text" class="form-control " id="idUtilisateur" value="${current_user.getLogin()}" name="utilisateur" placeholder="Utilisateur" aria-describedby="inputGroupPrepend3" required>
       <div class="valid-feedback">
         ${valide.getErreurs().get('utilisateur')}
       </div>
     </div>
   </div>
  </div>
  
  <div class="form-row">
   <div class="form-group col-sm-6">
	  <label for="idMail">Mail</label>
	  <div class="input-group">
	  	<div class="input-group-text">@</div>
	    <input type="email" class="form-control " id="idMail" name="mail" value="${current_user.getMail()}" aria-describedby="inputGroupPrepend4" placeholder="Email" required>
	    <div class="invalid-feedback">
         ${valide.getErreurs().get('mail')}
        </div>
	  </div>
   </div>
  </div>
  
  <div class="form-row">
  <div class="form-group col-sm-2">
  	<label for="idDate">Date de Naissance</label>
  	<div class="input-group">
	<input type="date" id="idDate" class="form-control " name="date" value="2018-07-22" aria-describedby="inputGroupPrepend4" required>
	<div class="invalid-feedback">
         ${valide.getErreurs().get('date')} 
        </div>
	</div>
	</div>
  </div>
  
  <div class="form-row">
  	<div class="form-group col-sm-6">
  	<label for="idAdr">Adresse</label>
  	<div class="input-group">
	<input type="text" id="idAdr" class="form-control " id="idAdr"  value="${current_user.getAdresse()}" name="adr" aria-describedby="inputGroupPrepend4" placeholder="Adresse" required>
	<div class="invalid-feedback">
         ${valide.getErreurs().get('adresse')} 
        </div>
	</div>
	</div>
  
  </div>
  
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="idPays">Pays</label>
      <input type="text" class="form-control " id="idPays"  value="${current_user.getPays()}" name="pays" placeholder="Pays" required>
      <div class="invalid-feedback">
        ${valide.getErreurs().get('pays')}
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="idVille">Ville</label>
      <input type="text" class="form-control " id="idVille" value="${current_user.getVille()}" name="ville" placeholder="Ville" required>
      <div class="invalid-feedback">
        ${valide.getErreurs().get('ville')}
      </div>
    </div>
  </div>

  <button class="btn btn-primary" type="submit">Modifier</button>
  
</form>

</body>
</html>