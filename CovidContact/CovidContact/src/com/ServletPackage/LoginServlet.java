package com.ServletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BeansPackage.ActiviteBean;
import com.BeansPackage.LieuBean;
import com.BeansPackage.UserBean;
import com.MysqlPackage.MysqlBDD;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<UserBean> ListAmis = null;
        ArrayList<LieuBean> lieux = null;
        ArrayList<ActiviteBean> activites = null;
        UserBean user = null;
        
        MysqlBDD BDD = new MysqlBDD();
        user = BDD.getUer(request);
        
        HttpSession session = request.getSession( true );
        if ( user != null) {
        	session.setAttribute("current_user",user);
			request.setAttribute("current_user",user);
			
			ListAmis = BDD.getListAmi(user.getLogin());
			if ( ListAmis != null) {
				session.setAttribute("amis",ListAmis);
	        } else {
				session.setAttribute("amis",null);
	        }
			
			lieux = BDD.getListLieux();
			if ( lieux != null) {
				session.setAttribute("lieux",lieux);
	        } else {
				session.setAttribute("lieux",null);
	        }
			
			activites = BDD.getAcitivite(user.getId());
			if ( activites != null) {
				session.setAttribute("activites",activites);
	        } else {
				session.setAttribute("activites",null);
	        }
			
            request.getRequestDispatcher( "/Home.jsp" ).forward( request, response );
        } else {
        	session.setAttribute("current_user",null);
			request.setAttribute("current_user",null);
            request.getRequestDispatcher( "/Connection.jsp" ).forward( request, response );
        }
    }

}