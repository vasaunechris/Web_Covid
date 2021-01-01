package com.ServletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BeansPackage.UserBean;
import com.MysqlPackage.MysqlBDD;

/**
 * Servlet implementation class RelationServlet
 */
@WebServlet("/Relation")
public class RelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelationServlet() {
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
		String ami = request.getParameter( "ami" );
        ArrayList<UserBean> users = null;
        ArrayList<UserBean> ListAmis = null;
        
        HttpSession session = request.getSession( true );
        UserBean u = (UserBean)session.getAttribute("current_user");
        MysqlBDD BDD = new MysqlBDD();
        users = BDD.getUer(ami,u.getLogin());
        ListAmis = BDD.getListAmi(u.getLogin());
        
        if ( users != null) {
			request.setAttribute("recherche",users);
        } else {
			request.setAttribute("recherche",null);
        }
        
        if ( users != null) {
			request.setAttribute("amis",ListAmis);
        } else {
			request.setAttribute("amis",null);
        }
        request.getRequestDispatcher( "/Relation.jsp" ).forward( request, response );
	}

}
