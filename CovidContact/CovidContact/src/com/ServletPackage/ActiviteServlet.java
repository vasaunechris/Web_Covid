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

/**
 * Servlet implementation class ActiviteServlet
 */
@WebServlet("/Activite")
public class ActiviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiviteServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession( true );
		ArrayList<ActiviteBean> activites = null;
		ArrayList<LieuBean> lieux = null;
		UserBean u = (UserBean)session.getAttribute("current_user");
		
		MysqlBDD BDD = new MysqlBDD();
		
		System.out.print(u.getId());
		BDD.createActivite(request, u.getId());
		
		activites = BDD.getAcitivite(u.getId());
		if ( activites != null) {
			session.setAttribute("activites",activites);
        } else {
			session.setAttribute("activites",null);
        }
		
		lieux = BDD.getListLieux();
		if ( lieux != null) {
			session.setAttribute("lieux",lieux);
        } else {
			session.setAttribute("lieux",null);
        }
		
		request.getRequestDispatcher( "/Activite.jsp" ).forward( request, response );
	}

}
