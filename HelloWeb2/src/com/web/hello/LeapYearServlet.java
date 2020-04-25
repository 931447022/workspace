package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeapYearServlet
 */
@WebServlet(name = "year.do", urlPatterns = { "/year.do" })
public class LeapYearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeapYearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int year=Integer.parseInt(request.getParameter("a"));
			LeapYear ly = new LeapYear(year);
			request.setAttribute("ly", ly);
			request.getRequestDispatcher("year.jsp").forward(request, response);
		} catch(Exception e) {
			String error="输入信息有误！不是合法年份";
			LeapYear ly = new LeapYear();
			request.setAttribute("ly", ly);
			request.getRequestDispatcher("year.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
