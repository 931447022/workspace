package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookieServlet
 */
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cookieName = "username";
        String cookieValue = null; 
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
           for(int i = 0;i<cookies.length;i++){
             Cookie cookie = cookies[i];
             if(cookie.getName().equals(cookieName))
               cookieValue = cookie.getValue();
           }
        }
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out=response.getWriter();
		  out.println("<html><title>读取Cookie</title>");
		  out.println("<body><h3>从浏览器读回一个Cookie</h3>");
		  out.println("Cookie名:"+cookieName+"<br>");
		  out.println("Cookie值:"+cookieValue+"<br>");
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
