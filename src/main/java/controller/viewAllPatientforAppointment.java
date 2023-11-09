package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Patient;
@WebServlet("/viewAllPatientforAppointment")
public class viewAllPatientforAppointment extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if(req.getSession().getAttribute("staff")==null){
		resp.getWriter().print("<h1>Session Expired</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
}
	else{
		HospitalDao dao=new HospitalDao();
		List<Patient> list=(List<Patient>) dao.fetchAllPatient();
		
		if(list.isEmpty()){
			resp.getWriter().print("<h1>No Patient Data</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("PatientList.jsp").forward(req, resp);
		}
	}
}
}