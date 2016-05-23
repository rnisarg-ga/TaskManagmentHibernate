package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserRole;
import com.model.ServiceModel;

/**
 * Servlet implementation class UserRoleController
 */
@WebServlet("/UserRoleController")
public class UserRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRoleController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	try(PrintWriter out= response.getWriter()){
    		String user_role= request.getParameter("user_role");
    		com.bean.UserRole role= new UserRole();
    		com.model.ServiceModel model= new ServiceModel();
    		long userroleid=0L;
    		String Submit = request.getParameter("Submit");
    		boolean flag = false;
    		
    		
    		switch (Submit) {
			case "Submit":
				role.setUserrole(user_role);
				flag= model.AddUserRole(role);
				if(flag){
					response.sendRedirect("user role.jsp");
					
				}
				else{
					out.println(flag);
					
				}
				
				
				
				
				break;

			default:
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
