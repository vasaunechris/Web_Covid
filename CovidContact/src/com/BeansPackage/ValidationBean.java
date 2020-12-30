package com.BeansPackage;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class ValidationBean {
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	
	public Map<String, String> getErreurs() {
	        return erreurs;
	}
	
	public void Verification(HttpServletRequest request) {
		
		/* Validation du champ nom */
        try {
            validationNom( request.getParameter( "nom" ));
            request.setAttribute("nom", request.getParameter( "nom" ));
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
            request.setAttribute("nom", null);
        }
        
        /* Validation du champ prenom */
        try {
            validationPrenom( request.getParameter( "prenom" ) );
            request.setAttribute("prenom", request.getParameter( "prenom" ));
        } catch ( Exception e ) {
            setErreur( "prenom", e.getMessage() );
            request.setAttribute("prenom", null);
        }
        
        /* Validation du champ mot de passe. */
        try {
            validationUtilisateur(request.getParameter( "utilisateur" ));
            request.setAttribute("utilisateur", request.getParameter( "utilisateur" ));
        } catch ( Exception e ) {
            setErreur( "utilisateur", e.getMessage() );
            request.setAttribute("utilisateur", null);
        }
		
		/* Validation du champ mot de passe. */
        try {
            validationPassword( request.getParameter( "password" ));
        } catch ( Exception e ) {
            setErreur( "password", e.getMessage() );
        }
		
		/* Validation du champ mail. */
        try {
            validationMail( request.getParameter( "mail" ));
            request.setAttribute("mail", request.getParameter( "mail" ));
        } catch ( Exception e ) {
            setErreur( "mail", e.getMessage() );
            request.setAttribute("mail", null);
        }
        
        /* Validation du champ date */
        try {
            validationDate( request.getParameter( "date" ));
            request.setAttribute("date", request.getParameter( "date" ));
        } catch ( Exception e ) {
            setErreur( "date", e.getMessage() );
            request.setAttribute("date", null);
        }
        
        /* Validation du champ adresse */
        try {
            validationAdresse( request.getParameter( "adr" ));
            request.setAttribute("adresse", request.getParameter( "adr" ));
        } catch ( Exception e ) {
            setErreur( "adr", e.getMessage() );
            request.setAttribute("adr", null);
        }
        
        /* Validation du champ pays */
        try {
            validationPays( request.getParameter( "pays" ));
            request.setAttribute("pays", request.getParameter( "pays" ));
        } catch ( Exception e ) {
            setErreur( "pays", e.getMessage() );
            request.setAttribute("pays", null);
        }
        
        /* Validation du champ ville */
        try {
            validationVille( request.getParameter( "ville" ));
            request.setAttribute("ville", request.getParameter( "ville" ));
        } catch ( Exception e ) {
            setErreur( "ville", e.getMessage() );
            request.setAttribute("ville", null);
        }
		
	}
	
	private void validationNom( String nom ) throws Exception {
        if ( nom == null) {        	
        	throw new Exception( "Merci de saisir un nom valide" );
        }
    }
	
	private void validationPrenom( String prenom ) throws Exception {
        if ( prenom == null) {       	
        	throw new Exception( "Merci de saisir un prenom valide" );
        }
    }
	
	private void validationUtilisateur( String utilisateur ) throws Exception {
        if ( utilisateur == null) {
        	throw new Exception( "Merci de saisir un nom d'utilisateur valide" );
        }
    }
	
	private void validationPassword( String password ) throws Exception {
        if ( password != null) {
        	if(password.trim().length() < 8 || password.trim().length() > 20) {
        		throw new Exception( "Merci de saisir un mot de passe valide" );
        	}
        }
    }
	
	private void validationMail( String mail ) throws Exception {
        if ( mail != null && !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
	
	private void validationDate( String date ) throws Exception {
        if ( date == null) {
            throw new Exception( "Merci de saisir une date valide." );
        }
    }
	
	private void validationAdresse( String adresse ) throws Exception {
        if ( adresse == null  ) {
            throw new Exception( "Merci de saisir une adresse valide." );
        }
    }
	
	private void validationPays( String pays ) throws Exception {
        if ( pays == null ) {
            throw new Exception( "Merci de saisir une pays valide." );
        }
    }
	
	private void validationVille( String ville ) throws Exception {
        if (ville == null) {
            throw new Exception( "Merci de saisir une ville valide." );
        }
    }
	
	
	private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
	
	
}
