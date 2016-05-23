package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Login;
import com.bean.UserRole;
import com.model.ServiceModel;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean flag = false;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try(PrintWriter out= response.getWriter()){
    		String login_id =request.getParameter("login_id");
    		String password =request.getParameter("password");
    		long user_role=0l;
    		String Submit = request.getParameter("Submit");
    		
    		 
    		com.bean.Login login = new Login() ;   
    		 com.bean.UserRole role;
    		 com.model.ServiceModel model = new ServiceModel();
    		
    		switch(Submit){
    		case "Submit":
    			login.setLogin_id(login_id);
    			login.setPassword(password);
    			user_role = Long.parseLong(request.getParameter("user_role"));
    			
    			role = new UserRole(user_role);
    			login.setRole(role);
    			out.println(login.getRole().getUserroleid());
    			
    			
    			
    			flag = model.AddUserDetails(login);
    			if(flag){
    				response.sendRedirect("UserRegistration.jsp");
    				
    			}
    			else{
    				out.println(flag);
    				
    			}
    			
    			
    			
    			break;
    			default:
    				out.println(Submit);
    				break;
    			
    			
    		
    		}
    		
    		
    		
    		
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
