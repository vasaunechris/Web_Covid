<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<title>Inscription</title>
	<link href="jumbotron.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
 
<body> 
<%@include  file="index.jsp" %>

<h1 align="center" class="display-4">Inscription</h1>

<form method="post" action="Register" >

  <div class="form-row">
  
    <div class="col-auto my-1">
      <label  for="idGenre">Genre</label>
      <select class="form-select custom-select mr-sm-2 " id="idGenre" name="genre" required>
        <option selected disabled value="">Choose...</option>
        <option value="1">Mme.</option>
        <option value="2">M.</option>
      </select>
    </div>
  
    <div class="col-md-4 mb-3">
      <label for="idNom">Nom</label>
      <input type="text" class="form-control " id="idNom" name ="nom" value="${nom}" placeholder="Nom" required>
      <div class="invalid-tooltip">

        ${valide.getErreurs().get('nom')}
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="idPrenom">Prenom</label>
      <input type="text" class="form-control " value="${prenom}" id="idprenom" name="prenom" placeholder="Prenom" required>
      <div class="valid-feedback">
        ${valide.getErreurs().get('prenom')}
      </div>
    </div>
  </div>
  
  <div class="form-row">
   <div class="col-md-4 mb-3">
     <label for="idUtilisateur">Nom d'utilisateur</label>
     <div class="input-group">
       <input type="text" class="form-control " id="idUtilisateur" value="${utilisateur}" name="utilisateur" placeholder="Utilisateur" aria-describedby="inputGroupPrepend3" required>
       <div class="valid-feedback">
         ${valide.getErreurs().get('utilisateur')}
       </div>
     </div>
   </div>
   <div class="col-md-4 mb-3)">
    <label for="idPassword">Password</label>
    <div class="input-group">
	    <input type="password" id="idPassword" name="password" class="form-control" placeholder="Password" aria-describedby="passwordHelpInline" required>
	    <div class="invalid-tooltip">
        ${valide.getErreurs().get('password')}
       </div>
       <small id="passwordHelpInline" class="text-muted">
	              Must be 8-20 characters long.
	    </small>
    </div>
   </div>
  </div>
  
  <div class="form-row">
   <div class="form-group col-sm-6">
	  <label for="idMail">Mail</label>
	  <div class="input-group">
	  	<div class="input-group-text">@</div>
	    <input type="email" class="form-control " id="idMail" name="mail" value="${mail}" aria-describedby="inputGroupPrepend4" placeholder="Email" required>
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
	<input type="text" id="idAdr" class="form-control " id="idAdr"  value="${adr}" name="adr" aria-describedby="inputGroupPrepend4" placeholder="Adresse" required>
	<div class="invalid-feedback">
         ${valide.getErreurs().get('adresse')} 
        </div>
	</div>
	</div>
  
  </div>
  
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="idPays">Pays</label>
      <input type="text" class="form-control " id="idPays"  value="${pays}" name="pays" placeholder="Pays" required>
      <div class="invalid-feedback">
        ${valide.getErreurs().get('pays')}
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="idVille">Ville</label>
      <input type="text" class="form-control " id="idVille" value="${ville}" name="ville" placeholder="Ville" required>
      <div class="invalid-feedback">
        ${valide.getErreurs().get('ville')}
      </div>
    </div>
  </div>
  
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input " type="checkbox" value="" id="invalidCheck3" required>
      <label class="form-check-label" for="invalidCheck3">
        Agree to terms and conditions
      </label>
      <div class="invalid-feedback">
        You must agree before submitting.
      </div>
    </div>
  </div>
  
  <button class="btn btn-primary" type="submit">Valider</button>
  
</form>
</body>
</html>