package com.web.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ASServlet
 */
@WebServlet("/as.svt")
public class ASServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Model1 model = new Model1();
		
		if(request.getParameter("a")!=null)
			model.setA(request.getParameter("a"));
		if(request.getParameter("b")!=null)
			model.setB(request.getParameter("b"));
		if(request.getParameter("s")!=null)
			model.setS(request.getParameter("s"));
		
		
		model.caculate();
//		if(!"".equals(model.getA()) && !"".equals(model.getB()) && !"".equals(model.getS())){
//			try {
//				if("add".equals(model.getS())) {
//					model.setC(String.valueOf(Integer.parseInt(model.getA())+Integer.parseInt(model.getB())));
//				}else if ("sub".equals(model.getS())) {
//					model.setC(String.valueOf(Integer.parseInt(model.getA())-Integer.parseInt(model.getB())));
//				}else {
//					model.setError("s必须是+或者-");
//				}
//			} catch (Exception e) {
//				model.setError("参数解析异常："+e.getMessage());
//			}
//		}else {
//			model.setError("参数不完整，必须有 a，b，s");
//		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addsub.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
