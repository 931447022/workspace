package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigDemoServlet2
 */
public class ConfigDemoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String servletName = null;
	ServletConfig config = null;
	String email = null;
	String telephone = null;

	public void init(ServletConfig config) {
		this.config = config;
		servletName = config.getServletName();
		email = config.getInitParameter("email");
		telephone = config.getInitParameter("telephone");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigDemoServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<head><title>配置对象</title></head>");
		out.println("Servlet名称："+servletName+"<br>");
		out.println("Email地址："+email+"<br>");	
		out.println("电话："+telephone);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
