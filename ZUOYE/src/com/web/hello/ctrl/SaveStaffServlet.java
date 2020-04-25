package com.web.hello.ctrl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.hello.db.JDBC;
import com.web.hello.model.tables.Staff;

/**
 * Servlet implementation class SaveStaffServlet
 */
@WebServlet(name = "staff/save.do", urlPatterns = { "/staff/save.do" })
public class SaveStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Staff staff=new Staff();
		try {
			if(request.getParameter("cardnum")!=null)
				staff.setCardnum(request.getParameter("cardnum"));
			if(request.getParameter("name")!=null)
				staff.setName(request.getParameter("name"));
			if(request.getParameter("yudxm")!=null)
				staff.setYudxm(request.getParameter("yudxm"));
			if(request.getParameter("yuddate")!=null)
				staff.setYudDate(request.getParameter("yuddate"));
			if(request.getParameter("amount")!=null)
				staff.setAmount(Integer.parseInt(request.getParameter("amount")));;
			if(request.getParameter("id")!=null)
				staff.setId(Integer.parseInt(request.getParameter("id")));
			JDBC jdbc=new JDBC();
		
			jdbc.startConnection();
			Connection conn=jdbc.getConnection();
			PreparedStatement ps;
			String sql="";
			if(staff.getId()==0)
				sql="insert into Staff(cardnum,name,yudxm,yuddate,amount) values(?,?,?,?,?)";
			else
				sql="update Staff set cardnum=?,name=?,yudxm=?,yuddate=?,amount=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, staff.getCardnum());
			ps.setString(2, staff.getName());
			ps.setString(3, staff.getYudxm());
			ps.setLong(4, staff.getYuddate());
			ps.setInt(5, staff.getAmount());
			if(staff.getId()!=0)
				ps.setInt(6, staff.getId());
			ps.executeUpdate();
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
