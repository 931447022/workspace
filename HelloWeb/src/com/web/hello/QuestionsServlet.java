package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet(name = "questions.do", urlPatterns = { "/questions.do" })
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sum = 0;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			String question1 = request.getParameter("quest1");
			String question2 = request.getParameter("quest2");
			String[] question3= request.getParameterValues("quest3");
			String question4 = new String(request.getParameter("quest4").getBytes("Iso8859-1"));
			if(question1.equals("1")) {
				sum += 25;
				}
			if(question2.equals("3")) {
				 sum += 25;
				}
			if(question3.length == 2&& question3[0].equals("1") && question3[1].equals("3")) {
				sum +=25;
			}
			if(question4.equals("HttpServlet")) {
				sum +=25;
			}
			out.write("<html>\r\n");
	        out.write("<head>\r\n");
	        out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
	        out.write("<title>Insert title here</title>\r\n");
	        out.write("</head>\r\n");
	        out.write("<body>\r\n");
	        
	        out.write("你的成绩是"+sum+"分");
	        out.write("</body>\r\n");
	        out.write("</html>");
	        
		}catch(Exception e)
        {
      	  out.println("0");
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
