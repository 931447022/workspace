package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.util.Length;

/**
 * Servlet implementation class RegisterServlet2
 */
@WebServlet(name = "register2.do", urlPatterns = { "/register2.do" })
public class RegisterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		if(name!=null)
			name=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		    String sex=request.getParameter("sex");
		    String[] hobbies=request.getParameterValues("hobby");
			String education=request.getParameter("education");
			String email=request.getParameter("email");
			String age=request.getParameter("age");
			
			User user=new User();
			user.setName(name);
			user.setSex(sex);
			user.setHobbies(hobbies);
			user.setEducation(education);
			user.setEmail(email);
			if(age!=null && age.length()>0 && age.matches("^[0-9]*$"))
					user.setAge(Integer.parseInt(age));
			else 
			user.setAge(0);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("showUser.jsp").forward(request, response);
			}
			


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
