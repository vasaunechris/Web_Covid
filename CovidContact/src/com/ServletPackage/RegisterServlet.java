package com.ServletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BeansPackage.ValidationBean;
import com.MysqlPackage.MysqlBDD;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        
        ValidationBean valide = new ValidationBean();
        valide.Verification(request);
        
        HttpSession session = request.getSession();
        if(valide.getErreurs().isEmpty()) {
        	MysqlBDD BDD = new MysqlBDD();
            BDD.createUser(request);;
            this.getServletContext().getRequestDispatcher( "/Home.jsp" ).forward( request, response );
            
        }else {
        	session.setAttribute("current_user",null);
        	request.setAttribute("current_user",null);
        	request.setAttribute("valide", valide );
            this.getServletContext().getRequestDispatcher( "/Inscription.jsp" ).forward( request, response );
        }
        
        
        
        
        
	}

}
