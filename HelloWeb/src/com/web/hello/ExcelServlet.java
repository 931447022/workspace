package com.web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/excel.do")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //指定页面在传输过程中使用的编码方式
	    response.setHeader("Content-Encoding","gb2312");
	    // 设置响应的内容类型
	    response.setContentType("application/vnd.ms-excel;charset=gb2312");
	    PrintWriter out = response.getWriter();
	   
	    out.println("学号\t姓名\t性别\t年龄\t所在系");
	    out.println("95001\t李勇\t男\t20\t信息");
	    out.println("95002\t刘晨\t女\t19\t数学");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
