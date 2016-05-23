<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="session_valid.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController" method="post">
<table>
<tr>
<td>Email ID(Login ID)</td>
<td><input type="text" name="email_id" placeholder="Email ID"/>  </td>
</tr>
<tr>
<td>Password </td>
<td><input type="password" name="password" placeholder="Password"/>  </td>
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