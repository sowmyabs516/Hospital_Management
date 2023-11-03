package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospitalDao;
import dto.Staff;
@WebServlet("/adminfetchallstaff")
public class FetchAllStaff extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HospitalDao dao=new HospitalDao();
		List<Staff> list=dao.fetchAllStaff();
		if(list.isEmpty()){
			resp.getWriter().print("<h1>No data</h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
		}
		else{
			req.setAttribute("list", list);
			resp.getWriter().print("<h1 style='color:red'>Staff Data Found</h1>");
			req.getRequestDispatcher("ViewAllStaff.jsp").forward(req, resp);
		}
			}
}
