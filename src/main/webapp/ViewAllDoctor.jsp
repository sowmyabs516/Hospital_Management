<%@page import="dto.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Doctor> list= (List<Doctor>)request.getAttribute("list"); %>

<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Email</th>
<th>Password</th>
<th>Gender</th>
<th>DOB</th>
<th>Qualification</th>
<th>Specialization</th>
<th>Status</th>
</tr>

<%for(Doctor doctor :list){ %>
<tr>
<th><%=doctor.getId() %></th>
<th><%=doctor.getName() %></th>
<th><%=doctor.getMobile() %></th>
<th><%=doctor.getEmail() %></th>
<th><%=doctor.getPassword()%></th>
<th><%=doctor.getGender() %></th>
<th><%=doctor.getDob() %></th>
<th><%=doctor.getQualification() %></th>
<th><%=doctor.getSpecialization() %></th>
<th><a href="adminapprovedoctor?id=<%=doctor.getId()%>"><button>Change Status</button></a></th>

</tr>
<%} %>
</table>
</body>
</html>