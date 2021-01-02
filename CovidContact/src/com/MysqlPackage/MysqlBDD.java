package com.MysqlPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.BeansPackage.ActiviteBean;
import com.BeansPackage.LieuBean;
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
	
	public void createActivite(HttpServletRequest request, int id) {
		Connection connexion = connect();
		Statement statement = null;
		
		String lieu = request.getParameter("lieu");
		int nlieu = Integer.valueOf(lieu);
		String nom = request.getParameter( "nom" );
        String heureD = request.getParameter( "heureD" );
        String heureF = request.getParameter( "heureF" );
        String date = request.getParameter( "date" );
		   
	    try {
	    	statement = connexion.createStatement();
	    	String rq = "INSERT INTO Activite (IdUser, Nom, Date, HeureDebut, HeureFin, IdLieux) VALUES ("+id+",'"+nom+"','"+date+"','"+heureD+"','"+heureF+"','"+nlieu+"');";
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
					   user.setGenre(Integer.valueOf(res.getString("genre")));
					   user.setId(Integer.valueOf(res.getString("id")));
					   user.setVille(res.getString("ville"));
					   user.setPays(res.getString("pays"));
					   user.setDate(res.getString("date"));
					   user.setAdresse(res.getString("adresse"));
					   user.setMail(res.getString("mail"));
					   user.setMdp(res.getString("password"));
					   user.setLogin(res.getString("utilisateur"));
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
	
public ArrayList<UserBean> getUer(String login, String u) {
		
		Connection connexion = connect();
		Statement statement = null;
		ResultSet res = null;
		UserBean user = null;
		ArrayList<UserBean> users = new ArrayList<>();
		
		try {
	    	statement = connexion.createStatement();
	    	String rq = "SELECT * from Utilisateur where (Mail='"+login+"' or Nom='"+login+"' or Utilisateur ='"+login+"' or  Prenom='"+login+"') and Utilisateur !='"+u+"' ;";
	    	res = statement.executeQuery(rq);
	    	
		} 
	    catch (SQLException e) {
			e.printStackTrace();
	    }
		
		   try {
			while(res.next()) {
				   
			   user = new UserBean();
			   user.setGenre(Integer.valueOf(res.getString("genre")));
			   user.setVille(res.getString("ville"));
			   user.setPays(res.getString("pays"));
			   user.setDate(res.getString("date"));
			   user.setAdresse(res.getString("adresse"));
			   user.setMail(res.getString("mail"));
			   user.setMdp(res.getString("password"));
			   user.setLogin(res.getString("utilisateur"));
			   user.setNom(res.getString("nom"));
			   user.setPrenom(res.getString("prenom"));
				   
			   users.add(user);
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
		
		return users;
		
	}

public ArrayList<UserBean> getListAmi(String login) {
	
	Connection connexion = connect();
	Statement statement = null;
	ResultSet res = null;
	ResultSet res2 = null;
	UserBean user = null;
	String[] parts = null;
	ArrayList<UserBean> users = new ArrayList<>();
	
	try {
    	statement = connexion.createStatement();
    	String rq = "SELECT * from Utilisateur where Utilisateur ='"+login+"';";
    	res = statement.executeQuery(rq);
    	
	} 
    catch (SQLException e) {
		e.printStackTrace();
    }
	
	   try {
		while(res.next()) {
			if(res.getString("ListAmies") != null) {
				parts = res.getString("ListAmies").split(",");
				
			}
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		if(parts != null) {
		for(int j = 0; j < parts.length; j++) {
			try {
			String rq = "SELECT * from Utilisateur where Id ='"+Integer.valueOf(parts[j])+"';";
	    	res2 = statement.executeQuery(rq);
			} 
		    catch (SQLException e) {
				e.printStackTrace();
		    }
			while(res2.next()) {
				user = new UserBean();
			   user.setGenre(Integer.valueOf(res2.getString("genre")));
			   user.setVille(res2.getString("ville"));
			   user.setPays(res2.getString("pays"));
			   user.setDate(res2.getString("date"));
			   user.setAdresse(res2.getString("adresse"));
			   user.setMail(res2.getString("mail"));
			   user.setMdp(res2.getString("password"));
			   user.setLogin(res2.getString("utilisateur"));
			   user.setNom(res2.getString("nom"));
			   user.setPrenom(res2.getString("prenom"));
			   users.add(user);
			}
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
	    if ( res2 != null ) {
	        try {
	            /* On commence par fermer le ResultSet */
	        	System.out.println("fermeture resultat");
	            res2.close();
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
	
	return users;
	
}

public ArrayList<LieuBean> getListLieux() {
	
	Connection connexion = connect();
	Statement statement = null;
	ResultSet res = null;
	LieuBean lieu = null;
	ArrayList<LieuBean> lieux = new ArrayList<>();
	
	try {
    	statement = connexion.createStatement();
    	String rq = "SELECT * from Lieux ;";
    	res = statement.executeQuery(rq);
    	
	} 
    catch (SQLException e) {
		e.printStackTrace();
    }
	
	   try {
		while(res.next()) {
			   
		   lieu = new LieuBean();
		   lieu.setId(Integer.valueOf(res.getString("Id")));
		   lieu.setAdresse(res.getString("Adresse"));
		   lieu.setDenomination(res.getString("Denomination"));
		   lieux.add(lieu);
		   
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
	
	return lieux;
	
}

public ArrayList<ActiviteBean> getAcitivite(int id) {
	
	Connection connexion = connect();
	Statement statement = null;
	ResultSet res = null;
	ActiviteBean activite = null;
	LieuBean lieu = null;
	ArrayList<ActiviteBean> activites = new ArrayList<>();
	
	try {
    	statement = connexion.createStatement();
    	String rq = "select * from Activite inner join lieux on  activite.IdLieux = lieux.Id where activite.IdUser = "+id+";";
    	res = statement.executeQuery(rq);
    	
	} 
    catch (SQLException e) {
		e.printStackTrace();
    }
	
	   try {
		while(res.next()) {
			   
		   activite = new ActiviteBean();
		   lieu = new LieuBean();
		   activite.setId(Integer.valueOf(res.getString("activite.Id")));
		   activite.setNom(res.getString("Nom"));
		   activite.setDate(res.getString("Date"));
		   activite.setHeureD(res.getString("HeureDebut"));
		   activite.setHeureF(res.getString("HeureFin"));
		   lieu.setDenomination(res.getString("Denomination"));
		   lieu.setId(Integer.valueOf(res.getString("IdLieux")));
		   lieu.setAdresse(res.getString("Adresse"));
		   activite.setLieu(lieu);
		   activites.add(activite);
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
	
	return activites;
	
}
	

}
