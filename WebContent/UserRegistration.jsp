<%@page import="com.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>

<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Criteria"%>
<%@include file="session_valid.jsp" %>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!private String admin; %>
<%
admin = (String) session.getAttribute("admin");
if(admin!=null){
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserRegistration" method="post">
 
<table>
<tr>
<td>Email ID(Login ID)</td>
<td><input type="text" name="login_id" placeholder="Enter EmailID"/>  </td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" placeholder="Enter Password"/>  </td>
</tr>

<tr>
<td>User Role</td>
<td> 
<select name="user_role">
<option value="-1">--User Role--</option>
<% 
try{
	Configuration configuration= new Configuration().configure();
	SessionFactory factory = configuration.buildSessionFactory();
	Session session2 = factory.openSession();
	Criteria criteria = session2.createCriteria(UserRole.class);
	criteria.add(Restrictions.ne("userrole", "admin"));
	List<UserRole> list= criteria.list();
	for(UserRole role :list){
	%>		
		<option value="<%=role.getUserroleid()%>"> <%=role.getUserrole() %> </option>
		
	<% }
	
	
}
catch(Exception e){e.printStackTrace();}


%>

</select>
 </td>
</tr>

<tr>
<td></td>
<td>
<input type="submit" name="Submit" value="Submit"/>
<input type="reset" name="Reset" value="Reset"/>  
</td>
</tr>

</table>

</form>

</body>
</html>	
	
<% }
else{
	response.sendRedirect("index.jsp");
}


%>

