<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Appointment Form</h1>
<%if(session.getAttribute("staff")==null){
	response.getWriter().print("<h1>Session Expired</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
	%>
	<a href="viewAllPatientforAppointment"><button>View All Patient</button></a>
	<a href=""><button>Fetch By Id</button></a>
<% } %>
</body>
</html>