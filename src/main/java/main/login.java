package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/login")
public class login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	HospitalDao dao=new HospitalDao();
	Doctor doctor=dao.findDoctor(id);
	Staff staff=dao.findStaff(id);
	if(doctor==null && staff==null && id!=999999){
		resp.getWriter().print("<h1 style='color:red'>Incorrect Id</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	} else {
		if (doctor != null) {
			if (doctor.getPassword().equals(password)) {
					resp.getWriter().print("<h1 style='color:green'>Login Success</h1>");
					req.getRequestDispatcher("DoctorHome.html").include(req, resp);
			} else {
				resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
	}
		
		if (staff != null) {
			if (staff.getPassword().equals(password)) {
					resp.getWriter().print("<h1 style='color:green'>Login Success</h1>");
					req.getRequestDispatcher("StaffHome.html").include(req, resp);
			} else {
				resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
	}
		
		if(id==999999){
			if(password.equals("999999")){
			resp.getWriter().print("<h1 style='color:green'>Login Success</h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		}
			else{
				resp.getWriter().print("<h1 style='color:green'>Enter correct password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
}
		
}
}
}
