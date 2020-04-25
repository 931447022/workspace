package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet(name = "login3.do", urlPatterns = { "/login3.do" })
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=new String(request.getParameter("loginname").getBytes("ISO8859-1"));
		String password=request.getParameter("pwd");
		
		if(name.equals("admin")&&password.equals("admin")) {
			request.getSession().setAttribute("longinname", name);
			//request.setAttribute("loginname", name);
			//request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			response.sendRedirect("/hello/welcome.jsp");
			
		}else {
			
			//request.getRequestDispatcher("/login.html").forward(request,response);
			//response.sendRedirect("http://www.baidu.com");
			response.sendRedirect("/hello/login.html");
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
