package com.deloitte.dept.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;




@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DeptDao dao = new DeptDaoImpl();
		List<Dept> Deptlist = dao.getDeptList();
		out.println("<table border=2>");
		out.println("<tr><th>DeptNO<TH>DeptName<TH>Location</tr>");
		for(Dept e : Deptlist){
		out.println("<tr>");
		out.println("<td>"+e.getDeptno()+"</td>");
		out.println("<td>"+e.getDname()+"</td>");
		out.println("<td>"+e.getLoc()+"</td>");
		
		out.println("</tr>");
		}
		out.println("</table>");
	}

}
