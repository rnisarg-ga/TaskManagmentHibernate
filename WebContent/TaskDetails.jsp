
<%@page import="java.util.Iterator"%>
<%@page import="com.bean.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>

<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@include file="session_valid.jsp" %>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!private String admin; %>
<%! private String user; %>

<%
admin = (String) session.getAttribute("admin");
user = (String) session.getAttribute("user");
Configuration configuration = new Configuration().configure();
SessionFactory factory = configuration.buildSessionFactory();



if(admin!=null){
%>	
	<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%=admin %> & <a href="Logout">Logout</a>  </p>
<table border="1">
<thead>
<tr>
<th>Task Name</th>
<th>Description</th>
<th>Starting Date</th>
<th>Ending Date </th>
<th>Total Time Spend </th>
</tr>

</thead>
<tbody>
<% 
try{
	Session session2 = factory.openSession();
	Criteria criteria = session2.createCriteria(TaskManagement.class);
	List<TaskManagement> list = criteria.list();
	for(TaskManagement workLog : list){
	%>	
		<tr>
<td><a href="worklog.jsp?task_id=<%=workLog.getTaskid()%>"><%=workLog.getTask_name() %></a>  </td>
<td> <%=workLog.getDescription() %>
</td>
<td> <%=workLog.getStarting_date() %> </td>
<td><%=workLog.getEnding_date() %> </td>
<td>
	<% 
		try{
		Query query = session2.createQuery("from WorkLog w where w.management.taskid=:taskid ");
		query.setParameter("taskid", workLog.getTaskid());
		Integer days=0,hours=0,minuets =0;
		List<WorkLog> list2 = query.list();
		Iterator iterator = list2.iterator();
		String m = null;
		String patterns="[a-zA-Z]"+"\\s";
		while(iterator.hasNext()){
			WorkLog log = (WorkLog) iterator.next();
			String[] t1=log.getSpend_time().split(patterns);
			for(int i=0;i<t1.length;i++){
					days = Integer.parseInt(t1[0]);
					hours = Integer.parseInt(t1[1]);
					m = t1[2];
			}
			
			String[] t2= m.split("[a-zA-Z]");
			for(int i=0;i<t2.length;i++){
				minuets = Integer.parseInt(t2[i]);
			}
			
			days += days;
			hours += hours;
			minuets += minuets;
			
			
		}
		
		
		if(minuets >=60){
			hours += minuets / 60;
			minuets = minuets %60;
			
		}
		if(hours >8){
				days += hours /8;
				hours = hours %8;
			
		}
		
		out.println(days.toString()+"D "+hours.toString()+"H "+minuets.toString()+"M");
	
		}catch(Exception e){e.printStackTrace();}
	
	
	%>
 </td>
</tr>
		
		
	<% }
	
	
}catch(Exception e){e.printStackTrace();}


%>



</tbody>


</table>	




</body>
</html>
	
	
	
	
<%}
else if(user!=null){
%>	
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var request; 
function updateTask(x,id){
	var r1= x.parentNode.parentNode;
	var cell0=r1.cells[1].innerHTML;
	var cell1= r1.cells[2].innerHTML;
	var cell2=r1.cells[3].innerHTML;
	var cell3 = r1.cells[4].innerHTML;

	document.getElementById('TaskName').value = cell0.trim();
	document.getElementById('description').value = cell1.trim();
	document.getElementById('Starting_date').value = cell2.trim();
	document.getElementById('ending_date').value = cell3.trim();
	document.getElementById('task_id').value = id;
	document.getElementById('Submit').value = "Update";

	}

function DeleteTask(id) {
	var url="TaskController?Submit=Delete&task_id="+id;
	if(confirm("Are you sure want to Delete?") == true){
		if(window.XMLHttpRequest){  
			request=new XMLHttpRequest();  
			}  
			else if(window.ActiveXObject){  
			request=new ActiveXObject("Microsoft.XMLHTTP");  
			}  
		try  
		{  
		//request.onreadystatechange=getInfo;  
		request.open("GET",url,true);  
		request.send();  
		alert("Record Delete Successfully");
		window.location.reload();
		
		}  
		catch(e)  
		{  
		alert("Unable to connect to server");  
		}	
	
	}
	else{

		}
	
}

function ResetAll(){
	document.getElementById('Submit').value='Submit';
	document.getElementById('task_id').value='';
	
}


</script>


</head>
<body>
<p><%=user %> & <a href="Logout">Logout</a>  </p>
<form action="TaskController" method="post">
<input type="hidden" name="task_id" id="task_id"/>
<table>
<tr>
<td>Task Name</td>
<td><input type="text" name="task_name" id="TaskName" placeholder="Task Name"/> 
</td>
</tr>


<tr>
<td>Description</td>
<td> <textarea name="description" id="description" placeholder="Description"></textarea> 
</td>
</tr>

<tr>
<td>Starting Date </td>
<td> <input type="text" name="Starting_date" id="Starting_date" placeholder="Starting Date"/> 
</td>
</tr>

<tr>
<td>Ending Date </td>
<td> <input type="text" name="ending_date" id="ending_date" placeholder="Ending Date"/> 
</td>
</tr>


<tr>
<td>Add Member</td>
<td>
<select name="userlist" multiple="multiple">
<%
	try{
		Session session2 = factory.openSession();
		Criteria criteria = session2.createCriteria(Login.class);
		criteria.add(Restrictions.ne("login_id", "admin@admin.com"));
		criteria.add(Restrictions.ne("login_id", user));
		List<Login> list = criteria.list();
		for(Login login :list){
		%>		
			
			<option>
			<%=login.getLogin_id() %>
			</option>
			
		<% }
		
	}catch(Exception e){e.printStackTrace();}

%>

 </select>

</td>

</tr>
<tr>
<td></td>
<Td><input type="submit" name="Submit" id="Submit" value="Submit"/>
<input type="reset" name="Reset" value="Reset" onclick="ResetAll()" />
  </Td>

</tr>

</table>


</form>

<table border="1">
<thead>
	<tr>
	<th>#</th>
	<th>Task Name</th>
	<th>Description</th>
	<th>Starting Date</th>
	<th>Ending Date</th>
	<th>Operations</th>
	</tr>

</thead>
<tbody>
<% 
try{
	Session session2 = factory.openSession();
	String sql="from TaskManagement t "
			+" where t.login.login_id=:login ";
	Query query = session2.createQuery(sql);
	query.setParameter("login", user);
	List<TaskManagement> list = query.list();
	for(TaskManagement management : list){
		
	%>	
		<tr>
		<td><a href="worklog.jsp?task_id=<%=management.getTaskid()%>">Click Here</a></td>
		<td><%=management.getTask_name() %> </td>
		<td><%=management.getDescription() %> </td>
		<td><%=management.getStarting_date() %> </td>
		<td><%=management.getEnding_date() %> </td>
		<td><a href="#" onclick="updateTask(this,'<%=management.getTaskid()%>')">Update</a> || <a href="#" onclick="DeleteTask('<%=management.getTaskid()%>')">Delete</a> </td>
		</tr>
		
		
		
	<% }
	
	
}catch(Exception e){e.printStackTrace();}


%>


</tbody>


</table>

</body>
</html>
	
	
	
	
<%}
else {
	response.sendRedirect("index.jsp");
}


%>
