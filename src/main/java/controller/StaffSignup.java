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
import dto.Staff;

@WebServlet("/staffsignup")
public class StaffSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospitalDao dao = new HospitalDao();
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		if(dao.findDoctor(email)==null && dao.findDoctor(mobile)==null && dao.findStaff(email)==null && dao.findStaff(mobile)==null){
		Staff staff = new Staff();
		staff.setDob(dob);
		staff.setEmail(email);
		staff.setGender(gender);
		staff.setMobile(mobile);
		staff.setName(name);
		staff.setPassword(password);
		staff.setAge(age);
		
		dao.staffSignup(staff);
		resp.getWriter().print("<h1 style='color:green'>Data saved Successfully</h1>");
		resp.getWriter().print("<h1>Your Staff Id" + staff.getId() + "</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
		else{
			resp.getWriter().print("<h1 style='color:green'>Mobile or email already exists</h1>");
			req.getRequestDispatcher("StaffSignup.html").include(req, resp);
		}
}
}

