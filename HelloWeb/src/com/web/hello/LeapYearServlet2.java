package com.web.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeapYearServlet2
 */
@WebServlet(name = "year2.do", urlPatterns = { "/year2.do" })
public class LeapYearServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeapYearServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String year = request.getParameter("year");

	   // try (year != null && year.length() > 0 && year.matches("^[0-9]*$")) {
			LeapYear ly = new LeapYear(Integer.parseInt(year));
			request.setAttribute("year", ly);
			request.getRequestDispatcher("LeapYear.jsp").forward(request, response);
		} //catch(Exception e){
			//request.setAttribute("error", "输入年份有误！");
			//request.getRequestDispatcher("error.jsp").forward(request, response);
		//}

	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
