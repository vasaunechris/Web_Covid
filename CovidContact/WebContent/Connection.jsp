<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Connection</title>
        <link rel='stylesheet' type='text/css' href='styles.css' />
        <link href="jumbotron.css" rel="stylesheet">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
    </head>
    
    <body>
    	<%@include  file="index.html" %>
        <h2 align="center" class="display-4">Connection</h2>
    	
        <form method="post" action="Login" >
	        <div class="col-md-4 mb-3">
		      <label for="txtLogin">Login/Email</label>
		      <input type="text" class="form-control " id="idLogin" name="utilisateur" placeholder="Utilisateur/Mail" value='${utilisateur}' required>
		      <div class="valid-feedback">
		        Looks good!
		      </div>
		    </div>
		    <div class="col-md-4 mb-3">
		      <label for="txtpassword">Password</label>
		      <input type="password" class="form-control i" id="idPassword" name="password" placeholder="Password" value='${password}' required>
		      <div class="valid-feedback">
		        Looks good!
		      </div>
		    </div>   
		    <button class="btn btn-primary" type="submit">Se Connecter</button> 
        </form>  
        
    
    </body>
</html>
