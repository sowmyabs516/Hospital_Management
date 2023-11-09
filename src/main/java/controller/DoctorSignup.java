package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Doctor;
@WebServlet("/doctorsignup")
public class DoctorSignup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospitalDao dao=new HospitalDao();
		String name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		Date dob=Date.valueOf(req.getParameter("dob"));
		String qualification=req.getParameter("qualification");
		String specialization=req.getParameter("specialization");
		
		if(dao.findDoctor(email)==null && dao.findDoctor(mobile)==null && dao.findStaff(email)==null && dao.findStaff(mobile)==null){
		Doctor doctor=new Doctor();
		doctor.setDob(dob);
		doctor.setEmail(email);
		doctor.setGender(gender);
		doctor.setMobile(mobile);
		doctor.setName(name);
		doctor.setPassword(password);
		doctor.setQualification(qualification);
		doctor.setSpecialization(specialization);
		
		dao.doctorSignup(doctor);
		resp.getWriter().print("<h1 style='color:green'>Data saved Successfully</h1>");
		resp.getWriter().print("<h1>Your Doctor Id: "+ doctor.getId()+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
		req.setAttribute("doctor",doctor);
		}
		else{
			resp.getWriter().print("<h1 style='color:green'>Mobile or email already exists</h1>");
			req.getRequestDispatcher("DoctorSignup.html").include(req, resp);
		}
	}
	}
