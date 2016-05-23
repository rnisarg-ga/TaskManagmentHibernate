<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="session_valid.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! private String user; %>
<%!private long task_id; %>

<%
user = (String) session.getAttribute("user");
if(user!=null){
	task_id =Long.parseLong(request.getParameter("task_id"));
%>	
	
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%=user %> & <a href="Logout">Logout</a>  </p>
<form action="WorkLogController" method="post">
<input type="hidden" name="task_id" value="<%=task_id%>"/>
<table>
<tr>
<td>Starting Time</td>
<td><input type="text" name="Starting_time" placeholder="Starting Time"/>  </td>
</tr>

<tr>
<td>Spend Time For Task</td>
<td><input type="text" name="spend_time" placeholder="SpendTime(1D 1H 1M)"/>  </td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" name="Submit" value="Submit"/>
<input type="reset" name="Reset" value="Reset" /> 
</td>
</tr>

</table>

</form>


</body>
</html>
	
<%}
else{
	
	response.sendRedirect("index.jsp");
}

%>

