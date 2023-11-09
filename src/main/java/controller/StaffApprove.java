package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Doctor;
import dto.Staff;
@WebServlet("/adminstaffapproval")
public class StaffApprove extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		HospitalDao dao=new HospitalDao();
		Staff staff=dao.findStaff(id);
		
		if(staff.isStatus()){
			staff.setStatus(false);
		}
		else{
			staff.setStatus(true);
		}
		dao.updateStaff(staff);
		resp.getWriter().print("<h1>Staus Changed");
		req.setAttribute("list", dao.fetchAllStaff());
		req.getRequestDispatcher("ViewAllStaff.jsp").include(req, resp);
	}
	}
