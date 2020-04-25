package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "register.do", urlPatterns = { "/register.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=new String(request.getParameter("name").getBytes("ISO8859-1"));
		String sex=request.getParameter("sex");
		String[] hobbies=request.getParameterValues("hobby");
		String age=request.getParameter("age");
		String education=request.getParameter("education");
		String email=request.getParameter("email");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write("<html>\r\n");
        out.write("<head>\r\n");
        out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
        out.write("<title>Insert title here</title>\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
		out.println("<p>姓名是"+name);
		out.println("<p>年龄是"+age);
		out.println("<p>性别是"+sex);
		out.println("<p>兴趣是:");
		for(int i=0;i<hobbies.length;i++) {
	        out.println(hobbies[i]);	
		}
		out.println("<p>学历是"+education);
		out.println("<p>邮件地址是"+email);
		out.write("</body>\r\n");
        out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
