<%@page import="com.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Query"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@include file="session_valid.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!private String admin; %>
<%! private String user; %>
<%!private long task_id; %>

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

<table>
<%

try{
	task_id =Long.parseLong(request.getParameter("task_id"));
	Session session2 = factory.openSession();
	Criteria criteria = session2.createCriteria(TaskManagement.class).add(Restrictions.eq("taskid", task_id));
	List<TaskManagement> list = criteria.list();
	for(TaskManagement management: list){
	%>	
		
		<table border="1">
		<tr>
		<td>Task Name</td>
		<td><%=management.getTask_name() %> </td>
		</tr>
		
		<tr>
		<td> Description</td>
		<td><%=management.getDescription() %> </td>
		</tr>
		<tr>
		<td>Starting Date </td>
		<td><%=management.getStarting_date() %> </td>
		</tr>
		
		<tr>
		<td>Ending Date</td>
		<td><%=management.getEnding_date() %></td>
		</tr>
		
		</table>
		
	<%}
	
	
}catch(Exception e){e.printStackTrace();}

%>


</table>

<p> Spend Time</p>

<table border="1">
<thead>
<tr>
<th>Email ID</th>
<th>Starting Time </th>
<th>Spend Time</th>
</tr>
</thead>
<tbody>
<%
try{
	Session session2 = factory.openSession();
	Query query = session2.createQuery("from WorkLog w where w.management.taskid=:task_id");
	query.setParameter("task_id", task_id);
	List<WorkLog> list = query.list();
	for(WorkLog log : list){
	%>	
		<tr>
		<td><%=log.getLogin().getLogin_id() %> </td>
		<td><%=log.getStarting_time() %> </td>
		<td><%=log.getSpend_time()%> </td>
		</tr>
		
		
	<%}
	
	
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
</head>
<body>
<p><%=user %> & <a href="Logout">Logout</a>  </p>
<%

try{
	task_id =Long.parseLong(request.getParameter("task_id"));
	Session session2 = factory.openSession();
	Criteria criteria = session2.createCriteria(TaskManagement.class).add(Restrictions.eq("taskid", task_id));
	List<TaskManagement> list = criteria.list();
	for(TaskManagement management: list){
	%>	
		
		<table border="1">
		<tr>
		<td>Task Name</td>
		<td><%=management.getTask_name() %> </td>
		</tr>
		
		<tr>
		<td> Description</td>
		<td><%=management.getDescription() %> </td>
		</tr>
		<tr>
		<td>Starting Date </td>
		<td><%=management.getStarting_date() %> </td>
		</tr>
		
		<tr>
		<td>Ending Date</td>
		<td><%=management.getEnding_date() %></td>
		</tr>
		
		</table>
		
	<%}
	
	
}catch(Exception e){e.printStackTrace();}

%>
<a href="AddWorkLog.jsp?task_id=<%=task_id%>">Add WorkLog</a>
<p>Work Log Details</p>
<table border="1">
<thead>
<tr>
<th>Email ID</th>
<th>Starting Time </th>
<th>Spend Time</th>
</tr>
</thead>
<tbody>
<%
try{
	Session session2 = factory.openSession();
	Query query = session2.createQuery("from WorkLog w where w.management.taskid=:task_id");
	query.setParameter("task_id", task_id);
	List<WorkLog> list = query.list();
	for(WorkLog log : list){
	%>	
		<tr>
		<td><%=log.getLogin().getLogin_id() %> </td>
		<td><%=log.getStarting_time() %> </td>
		<td><%=log.getSpend_time()%> </td>
		</tr>
		
		
	<%}
	
	
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>