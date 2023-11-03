package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Patient;

@WebServlet("/addpatient")
public class AddPatient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile1 = Long.parseLong(req.getParameter("mobile1"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();

		HospitalDao dao = new HospitalDao();

		Patient patient1 = dao.fetchPatient(mobile1);
		if (patient1 == null) {
			Patient patient = new Patient();
			patient.setAge(age);
			patient.setDob(dob);
			patient.setMobile1(mobile1);
			patient.setName(name);

			dao.savePatient(patient);

			resp.getWriter().print("<h1 style='color:green'>Patient Data Added Successfully</h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1 style='color:red'>Mobile Number should be unique</h1>");
			req.getRequestDispatcher("AddPatient.html").include(req, resp);
		}
	}
}
