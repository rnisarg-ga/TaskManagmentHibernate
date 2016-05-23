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
import com.bean.TaskManagement;
import com.bean.WorkLog;
import com.model.ServiceModel;

/**
 * Servlet implementation class WorkLogController
 */
@WebServlet("/WorkLogController")
public class WorkLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkLogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try(PrintWriter out= response.getWriter()) {
    	 
			long task_id=0L; 
			String Starting_time= request.getParameter("Starting_time");
			String spend_time = request.getParameter("spend_time");
			String Submit = request.getParameter("Submit");
			String pattern="[a-zA-Z]"+"\\s";
			String m = null;
			Integer days=0,hours=0,minutes=0;
			com.bean.WorkLog workLog = new WorkLog();
			boolean flag =false;
			
			switch (Submit) {
			case "Submit":
				HttpSession session = request.getSession();
				String[] temp = spend_time.split(pattern);
				for(int i=0;i<temp.length;i++){
					days = Integer.parseInt(temp[0]);
					hours = Integer.parseInt(temp[1]);
					m=temp[2];
				}
				String[] t1= m.split("[a-zA-Z]");
				for(int i=0;i<t1.length;i++){
					minutes = Integer.parseInt(t1[i]);
				}
				
				if(minutes>=60){
					hours += minutes /60;
					minutes = minutes %60;
					
				}
				if(hours >8){
					days += hours /8;
					hours = hours %8;
				}
				
				
				
				task_id = Long.parseLong(request.getParameter("task_id"));
				workLog.setLogin(new Login((String)session.getAttribute("user")));
				workLog.setManagement(new TaskManagement(task_id));
				workLog.setStarting_time(Starting_time);
				workLog.setSpend_time(days.toString()+"D "+hours.toString()+"H "+minutes.toString()+"M ");
				
				flag = new ServiceModel().AddWorkLog(workLog);
				if(flag){
						response.sendRedirect("worklog.jsp?task_id="+task_id);
				}
				else{
					
				}
				
				
				
				
				
				
				
				break;

			default:
				break;
			}
			
			
    		
    		
		} catch (Exception e) {
		e.printStackTrace();
		}
    	
    	
    }
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
