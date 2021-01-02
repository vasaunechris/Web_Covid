<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mot de passe</title>
</head>
<body>
<%@include  file="index.jsp" %>
<form method="post" action="PasswordEditeur" >

  <div class="form-row">
	  <div class="col-md-4 mb-3)">
	    <label for="idPassword">Old Password</label>
	    <div class="input-group">
		    <input type="password" id="idPassword" name="password" class="form-control" placeholder="Password" aria-describedby="passwordHelpInline" required>
		    <div class="invalid-tooltip">
	        ${valide.getErreurs().get('password')}
	       </div>
	    </div>
	  </div>
  </div>
  <div class="form-row">
   <div class="col-md-6 mb-3)">
    <label for="idPassword">New Password</label>
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
   <div class="col-md-4 mb-3)">
    <label for="idPassword">Confirmation</label>
    <div class="input-group">
	    <input type="password" id="idPassword" name="password" class="form-control" placeholder="Password" aria-describedby="passwordHelpInline" required>
	    <div class="invalid-tooltip">
        ${valide.getErreurs().get('password')}
       </div>
    </div>
   </div>
  </div>

<button class="btn btn-primary" type="submit">Modifier</button>
  
</form>
</body>
</html>