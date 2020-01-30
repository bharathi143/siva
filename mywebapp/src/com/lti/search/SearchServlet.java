package com.lti.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;

@WebServlet("/search.lti")
public class SearchServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String city=request.getParameter("city");
		
		SearchDao dao = new SearchDao();
		List<RegisterM> list = new ArrayList<RegisterM>();
		list=dao.select(city);
		
		out.println("<table>");
		for(RegisterM m : list) {
			out.println("<tr>");
			out.println("<td>" + m.getName() + "</td>");
			out.println("<td>" + m.getEmail() + "</td>");
			out.println("<td>" + m.getCity() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
				
	
	}

}
