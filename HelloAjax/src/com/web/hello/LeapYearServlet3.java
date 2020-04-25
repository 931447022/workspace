package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LeapYearServlet3
 */
@WebServlet(name = "yearjson2", urlPatterns = { "/yearjson2" })
public class LeapYearServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeapYearServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		System.out.print("kjkdjf");
		LeapYear ly;
		JSONObject json=new JSONObject();
		try{ 
			int year=Integer.parseInt(request.getParameter("year"));
			ly=new LeapYear(year);
		}
		catch(Exception e)
		{   e.printStackTrace();          
			ly=new LeapYear();
			String error="输入信息"+request.getParameter("year")+"有误！不是合法年份!";
	        ly.setError(error);
		}
		json.put("result", ly.getResult());
		json.put("error", ly.getError());
		response.getWriter().println(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
