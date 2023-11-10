<%@page import="dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="dto.Patient"%>
<%@page import="dto.Staff"%>
<%@page import="dao.HospitalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Staff  staff=(Staff)session.getAttribute("staff");
int pid=Integer.parseInt(request.getParameter("id"));
HospitalDao dao=new HospitalDao();
Patient patient=dao.fetchPatientById(pid);

if(patient==null){
	response.getWriter().print("<h1>Enter Proper Id</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
List<Doctor> list=dao.fetchAvailableDoctors();
	if(list.isEmpty()){
		response.getWriter().print("<h1>No Available Doctors</h1>");
		request.getRequestDispatcher("Login.html").include(request, response);
	}	else{%>
	
	<form action="/appointment" method="post">
	Patient Id:<input type="text" name="id" value="<%=pid %>" readonly="readonly">
	Patient Name:<input type="text" name="name" value="<%=patient.getName() %>" readonly="readonly">
	Staff Name: <input type="text" name="staffname" value="<%=staff.getName()%>" readonly="readonly"><br>
Problem:<input type="text" name="problem"><br>
Select Doctor:
<select name="doctor">
<%for(Doctor doctor:list){ %>
<option value="<%=doctor.getId()%>"><%=doctor.getName()%> (<%=doctor.getSpecialization()%>)</option>
<%} %>
</select>
<br>
<button>Fix Appointment</button><button type="reset">Cancel</button>
</form>
<%} %>
<a href="fetchallpatient"><button>Back</button></a>
<%} %>
</body>
</html>