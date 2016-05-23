package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AllotedTask;
import com.bean.Login;
import com.bean.TaskManagement;
import com.model.ServiceModel;

/**
 * Servlet implementation class TaskController
 */
@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
    		PrintWriter out = response.getWriter();
    		 Random random = new Random();
			HttpSession session;
			String task_name =request.getParameter("task_name");
			String description= request.getParameter("description");
			String Starting_date =request.getParameter("Starting_date");
			String ending_date= request.getParameter("ending_date");
			String Submit =request.getParameter("Submit");
			String userlist[]=request.getParameterValues("userlist");
			long taskid = 0L;
			boolean flag =false;
			com.bean.TaskManagement management;
			
			com.model.ServiceModel model= new ServiceModel();
			
			
			
			switch (Submit) {
			case "Submit":
				session = request.getSession();
				taskid = Long.parseLong(new SimpleDateFormat("ddMMYYYHHMMss").format(new Date()));
				management = new TaskManagement(taskid);
				management.setTask_name(task_name);
				management.setDescription(description);
				management.setStarting_date(Starting_date);
				management.setEnding_date(ending_date);
				
				management.setLogin(new Login((String)session.getAttribute("user")));
				com.bean.AllotedTask allotedTask = new AllotedTask();
				
				for(int i=0;i<userlist.length;i++){
					com.bean.Login login = new Login(userlist[i]) ;
					allotedTask.setManagement(management);
					allotedTask.setLogin(login);
				}
				
				flag = model.AddUserTask(management,allotedTask);
				if(flag){
					response.sendRedirect("dashboard.jsp");
					
				}
				else{
					out.println(flag);
					
				}
				
				
				
				break;
				
			case "Update":
				session = request.getSession();
				taskid = Long.parseLong(request.getParameter("task_id"));
				management = new TaskManagement(taskid);
				management.setTask_name(task_name);
				management.setDescription(description);
				management.setStarting_date(Starting_date);
				management.setEnding_date(ending_date);
				management.setLogin(new Login((String)session.getAttribute("user")));
				
				flag = new com.model.ModelUpdate().UpdateTask(management);
				if(flag){
					response.sendRedirect("TaskDetails.jsp"); 
				}
				else{
					
					out.println(flag);
				}
				
				
				
				
				
				break;
				
			case "Delete":
				taskid = Long.parseLong(request.getParameter("task_id"));
				//management = new TaskManagement(taskid);
				new com.model.ModelDelete().DeleteTask(taskid);
				break;

			default:
				out.print(Submit);
				break;
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
