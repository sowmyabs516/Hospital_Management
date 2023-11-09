package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Patient;

@WebServlet("/addpatient")
@MultipartConfig
public class AddPatient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		long mobile1=Long.parseLong(req.getParameter("mobile1"));
		Date dob1=Date.valueOf(req.getParameter("dob1"));
		int age=Period.between(dob1.toLocalDate(), LocalDate.now()).getYears();

		HospitalDao dao=new HospitalDao();
		
		Patient patient=new Patient();
		patient.setName(name);
		patient.setMobile1(mobile1);
		patient.setDob1(dob1);
		patient.setAge(age);
				
		dao.savePatient(patient);
		
		resp.getWriter().print("<h1 style='color:green'>Patient Data Added Successfully</h1>");
		req.getRequestDispatcher("StaffHome.html").include(req, resp);
	}
}
