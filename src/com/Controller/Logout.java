package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
    		PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("admin");
		String	user = (String) session.getAttribute("user");
		
		if(admin!=null){
			session.removeAttribute("admin");
			session.invalidate();
			response.sendRedirect("index.jsp");
			
			
		}
		else if(user!=null){
			session.removeAttribute("user");
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		}
		else {
			response.sendRedirect("index.jsp");
		}
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

}
