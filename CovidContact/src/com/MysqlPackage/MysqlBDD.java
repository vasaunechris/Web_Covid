package com.MysqlPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.BeansPackage.UserBean;

public class MysqlBDD {
	
	
	public MysqlBDD() {}
	
	
	
	public Connection connect(){
		

		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/CovidContact_BDD?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "root";
		
		Connection connexion = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Pilote trouvé");
		}catch (ClassNotFoundException e) {
			System.err.println("impossible de charger le pilote de jdbc");
		    System.exit(99);
		}
		
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    System.out.println("Connection réussit");
		} catch ( SQLException e ) {
			e.printStackTrace();
			System.err.println("Impossible de se connecter a la base de donnée");
		    System.exit(99);

		}
		return connexion;
		
	}
	
	public void createUser(HttpServletRequest request) {
		Connection connexion = connect();
		Statement statement = null;
		
		String genre = request.getParameter("genre");
		int ngenre = Integer.valueOf(genre);
		String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String login = request.getParameter( "utilisateur" );
        String password = request.getParameter( "password" );
        String mail = request.getParameter( "mail" );
        String adresse = request.getParameter( "adr" );
        String date = request.getParameter( "date" );
        String pays = request.getParameter( "pays" );
        String ville = request.getParameter( "ville" );
		   
	    try {
	    	statement = connexion.createStatement();
	    	String rq = "INSERT INTO Utilisateur (Genre, Nom, Prenom, Utilisateur, Password, Mail, Date, Adresse, Pays, Ville) VALUES ("+ngenre+",'"+nom+"','"+prenom+"','"+login+"','"+password+"','"+mail+"','"+date+"','"+adresse+"','"+pays+"','"+ville+"');";
	    	statement.executeUpdate(rq);
		} 
	    catch (SQLException e) {
			e.printStackTrace();
	    } finally {
	        if ( statement != null ) {
	            try {
	            	System.out.println("fermeture statement");
	            	statement.close();
	                
	            } catch ( SQLException ignore ) {
	            }
	        }
	        if ( connexion != null ) {
	            try {
	            	System.out.println("fermeture connection");
	            	connexion.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }
	}
	
	public UserBean getUer(HttpServletRequest request) {
		
		Connection connexion = connect();
		Statement statement = null;
		ResultSet res = null;
		UserBean user = null;
		
        String login = request.getParameter( "utilisateur" );
        String password = request.getParameter( "password" );

		
		try {
	    	statement = connexion.createStatement();
	    	String rq = "SELECT * from Utilisateur where (Mail='"+login+"' and Password='"+password+"') or (Utilisateur ='"+login+"' and  Password='"+password+"') ;";
	    	res = statement.executeQuery(rq);
	    	
		} 
	    catch (SQLException e) {
			e.printStackTrace();
	    }
		
		int i = 0;
		   try {
			while(res.next()) {
				   if(i==0) {
					   user = new UserBean();
					   user.setLogin(res.getString("utilisateur"));
					   user.setMdp(res.getString("password"));
					   user.setNom(res.getString("nom"));
					   user.setPrenom(res.getString("prenom"));
				   }
				   else {
					   i++;
					   
				   }

			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    if ( res != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		        	System.out.println("fermeture resultat");
		            res.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	System.out.println("fermeture statament");
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		            /* Et enfin on ferme la connexion */
		        	System.out.println("fermeture connexion");
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		}
		
		return user;
		
	}

}
