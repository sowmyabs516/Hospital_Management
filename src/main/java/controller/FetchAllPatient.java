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

@WebServlet("/adminfetchallpatient")
public class FetchAllPatient extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HospitalDao dao=new HospitalDao();
	List<Patient> list=dao.fetchAllPatient();
	if(list.isEmpty()){
		resp.getWriter().print("<h1 style='color:red'>No Patient Data Found</h1>");
		req.getRequestDispatcher("AdminHome.html").include(req, resp);
	}
	else{
		req.setAttribute("list", list);
		resp.getWriter().print("<h1 style='color:red'>Patient Data Found</h1>");
		req.getRequestDispatcher("ViewAllPatient.jsp").forward(req, resp);
	}
}
}
