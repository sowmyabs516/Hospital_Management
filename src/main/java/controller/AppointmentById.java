package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Patient;

@WebServlet("/appointment")
public class AppointmentById extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	HospitalDao dao=new HospitalDao();
	Patient patient=dao.fetchPatientById(id);
	if(patient==null){
		resp.getWriter().print("<h1>Enter Proper Id</h1>");
		req.getRequestDispatcher("FetchById.html").include(req, resp);
	}
	else{
		req.getRequestDispatcher("AppointmentForm.jsp").forward(req, resp);
	}
	
}
}
