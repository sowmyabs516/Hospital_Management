<%@page import="java.util.List"%>
<%@page import="dto.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Staff> list=(List<Staff>)request.getAttribute("list"); %>

<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Email</th>
<th>Password</th>
<th>Gender</th>
<th>DOB</th>
<th>Age</th>
</tr>

<%
			for (Staff staff : list) {
		%>
		<tr>
			<th><%=staff.getId()%></th>
			<th><%=staff.getName()%></th>
			<th><%=staff.getMobile()%></th>
			<th><%=staff.getEmail() %></th>
			<th><%=staff.getPassword()%></th>
			<th><%=staff.getGender()%></th>
			<th><%=staff.getDob() %></th>
			<th><%=staff.getAge()%></th>
			
		</tr>
		<%
			}
		%>
</table>
</body>
</html>
</body>
</html>