package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Doctor;

@WebServlet("/doctoravailable")
public class Doctor_Availability extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctor1 = (Doctor) req.getSession().getAttribute("doctor");
System.out.println(doctor1);
		HospitalDao dao = new HospitalDao();
		if (doctor1.isAvailable()) {
			doctor1.setAvailable(false);
			dao.updateAvailability(doctor1);
			resp.getWriter().print("<h1>Not available");
		} else {
			doctor1.setAvailable(true);
			dao.updateDoctor(doctor1);
			req.getSession().setAttribute("doctor", doctor1);
			resp.getWriter().print("<h1>Changed to Available</h1>");
			req.getRequestDispatcher("DoctorHome.html").include(req, resp);
		}
	}
}
