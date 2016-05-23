package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Login;
import com.model.ModelSelectAll;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	PrintWriter out = response.getWriter();
    	out.println("Outside Try");
    	try {
    		
			com.bean.Login login = new Login();
			com.model.ModelSelectAll all = new ModelSelectAll();
			
    		String login_id= request.getParameter("email_id");
    		String password= request.getParameter("password");
    	
    		out.println(login_id);
    		boolean flag=false,adminflag=false,userflag = false;
    		
    		login.setLogin_id(login_id);
    		login.setPassword(password);
    		HttpSession session;
    		
    		
    		flag = all.CheckUserPassword(login);
    		out.println(flag+login_id);
    		if(flag){
    				out.println("inside if");
    			if(adminflag = all.AdminLoginController(login)){
    				out.println("Admin Flag :-"+flag);
    				session = request.getSession();
    				session.setAttribute("admin", login_id);
    				response.sendRedirect("dashboard.jsp");
    				
    				
    			}
    			else if(userflag = all.UserLoginController(login)){
    				out.println("User Flag :-"+flag);
    				session = request.getSession();
    				session.setAttribute("user", login_id);
    				response.sendRedirect("dashboard.jsp");
    				
    			} 
    				
    		}
    		else{
    			
    			out.println(flag);
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
