package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Patient;

@WebServlet("/updatepatient")
public class UpdatePatient extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("dob"));
		
		HospitalDao hospitalDao=new HospitalDao();
		Patient patient=new Patient();
		patient.setDob1(dob);
		patient.setMobile1(mobile);
		
		hospitalDao.updatePatient(patient);
		resp.getWriter().print("<h1>Patient Data Updated</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
