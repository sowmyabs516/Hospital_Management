<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Patient"%>
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
<% List<Patient> list=(List<Patient>)request.getAttribute("list"); %>

<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>DOB</th>
<th>Age</th>
<th>View Previous Appointment</th>
</tr>

<%
			for (Patient patient : list) {
		%>
		<tr>
			<th><%=patient.getId()%></th>
			<th><%=patient.getName()%></th>
			<th><%=patient.getMobile1()%></th>
			<th><%=patient.getDob1() %></th>
			<th><%=patient.getAge()%></th>
			<th><a href="ViewPatientAppointment.jsp?id=<%=patient.getId()%>"><button></button></a></th>
			
		</tr>
		<%
			}
		%>
</table>
</body>
</html>