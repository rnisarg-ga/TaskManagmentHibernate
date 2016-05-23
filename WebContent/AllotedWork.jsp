<%@page import="com.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
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

if(user!=null){
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%=user %> & <a href="Logout">Logout</a>  </p>
<table border="1">
<thead>
<tr>
<th>Task Name</th>
<th>Description</th>
<th>Starting Date</th>
<th>Ending Date</th>

</tr>
</thead>

<tbody>
<% 
try{
Session session2 = factory.openSession();
Query query =  session2.createQuery("from AllotedTask a where a.login.login_id=:login_id");
query.setParameter("login_id", user);
List<AllotedTask> list = query.list();
for(AllotedTask task : list){
%>	
	<tr>
<td><a href="worklog.jsp?task_id=<%=task.getManagement().getTaskid() %>"><%=task.getManagement().getTask_name() %></a> </td>
<td><%=task.getManagement().getDescription() %> </td>
<td><%=task.getManagement().getStarting_date() %>  </td>
<td><%=task.getManagement().getEnding_date() %>  </td>

</tr>
	
	
<% }
	
}catch(Exception e){e.printStackTrace();}


%>



</tbody>

</table>

</body>
</html>	

	
	
<%}
else{
	response.sendRedirect("index.jsp");
}

%>
