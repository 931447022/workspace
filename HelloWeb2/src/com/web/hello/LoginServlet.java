package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login.do", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String check=request.getParameter("check");
		if(check!=null && check.equals("on")) {
			Cookie namecookie =new Cookie("loginname", name);
			Cookie pwdcookie =new Cookie("password", password);
			Cookie checkcookie =new Cookie("check", check);
			namecookie.setMaxAge(60*60);
			pwdcookie.setMaxAge(60*60);
			checkcookie.setMaxAge(60*60);
			response.addCookie(namecookie);
			response.addCookie(pwdcookie);
			response.addCookie(checkcookie);
		}else {
			Cookie cookie=null;
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					cookie=cookies[i];
					if(cookie.getName().equals("loginname"))
							cookie.setMaxAge(0);
					if(cookie.getName().equals("password"))
							cookie.setMaxAge(0);
					if(cookie.getName().equals("check"))
							cookie.setMaxAge(0);
					response.addCookie(cookie);
							
					
				}
			}
		}
		
		
		
		
		
		
		if(name.equals("admin")&&password.equals("admin")) {
			request.getSession().setAttribute("longinname", name);
			response.sendRedirect("welcome.jsp");
			
		}else {
			String message="用户或口令不正确，请重试！";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("login.jsp");
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
