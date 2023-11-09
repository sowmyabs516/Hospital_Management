package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Doctor;

@WebServlet("/adminapprovedoctor")
public class Doctorapprove extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	HospitalDao dao=new HospitalDao();
	Doctor doctor=dao.findDoctor(id);
	System.out.println(doctor);
	if(doctor.isStatus()){
		doctor.setStatus(false);
	}
	else{
		doctor.setStatus(true);
	}
	dao.updateDoctor(doctor);
	resp.getWriter().print("<h1>Staus Changed");
	req.setAttribute("list", dao.fetchAllDoctor());
	req.getRequestDispatcher("ViewAllDoctor.jsp").include(req, resp);
}
}
