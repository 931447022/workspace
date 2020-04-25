package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * Servlet implementation class YearServlet
 */
@WebServlet(name = "year.do", urlPatterns = { "/year.do" })
public class YearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		  out.write("<html>\r\n");
          out.write("<head>\r\n");
          out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
          out.write("<title>Insert title here</title>\r\n");
          out.write("</head>\r\n");
          out.write("<body>\r\n");
          try {
        	  		int year=Integer.parseInt(request.getParameter("a"));
        	  		if(year%4==0 && year%100!=0 || year%400==0) {
        			  out.println(year+"年是闰年");
          }else {
        	  out.println("清输入正确的年份！");
          }
        	  out.println("<br>");
          }
          catch(Exception e)
          {
        	  out.println("页面有问题！");
          }
          finally {
        	  out.write("</body>\r\n");
              out.write("</html>");
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
