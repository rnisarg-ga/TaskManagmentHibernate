<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="session_valid.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!private String admin; %>
<%! private String user; %>

<%
admin = (String) session.getAttribute("admin");
user = (String) session.getAttribute("user");

if(admin!=null){
%>	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%=admin %> & <a href="Logout">Logout</a>  </p>
<a href="UserRegistration.jsp">Create User</a>
<a href="TaskDetails.jsp">See Task Details</a>
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
<a href="AllotedWork.jsp">Alloted Task</a>
<a href="TaskDetails.jsp">Create Task</a>
</body>
</html>
	
	
<% }
else {
	response.sendRedirect("index.jsp");
	
}
%>
