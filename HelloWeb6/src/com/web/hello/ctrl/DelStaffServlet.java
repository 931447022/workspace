package com.web.hello.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.hello.db.JDBC;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DelStaffServlet
 */
@WebServlet(name = "staff/del.do", urlPatterns = { "/staff/del.do" })
public class DelStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
		int result=0;
		try {
			if(request.getParameter("id")!=null)
				id=Integer.parseInt(request.getParameter("id"));
			JDBC jdbc=new JDBC();
			jdbc.startConnection();
			String sql="delete from Staff where id="+id;
			result=jdbc.update(sql);
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject=new JSONObject();
		if(result>0) 
			jsonObject.put("succ", true);
		else
			jsonObject.put("succ", false);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonObject);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
