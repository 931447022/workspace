package com.web.hello.ctrl;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.hello.db.JDBC;
import com.web.hello.model.tablse.Owner;

/**
 * Servlet implementation class ModifyOwnerServlet
 */
@WebServlet(name = "owner/pream.do", urlPatterns = { "/owner/pream.do" })
public class ModifyOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
Owner owner=new Owner();
		
		try {
			if(request.getParameter("id")!=null)
				owner.setId(Integer.parseInt(request.getParameter("id")));
			JDBC jdbc=new JDBC();
			jdbc.startConnection();
			String sql="select * from Owner where id="+owner.getId();
			ResultSet rs=jdbc.query(sql);
			if(rs.next()) {
				owner.setId(rs.getInt("id"));
				owner.setName(rs.getString("name"));
				owner.setAge(rs.getInt("age"));
				owner.setDatetime(rs.getString("datetime"));
				owner.setPcount(rs.getInt("pcount"));
				owner.setHname(rs.getString("hname"));
				owner.setAmount(rs.getString("amount"));
				
			}
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("model", owner);
		request.getRequestDispatcher("am_owner.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
