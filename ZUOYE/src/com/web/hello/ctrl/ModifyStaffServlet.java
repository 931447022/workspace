package com.web.hello.ctrl;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.hello.db.JDBC;
import com.web.hello.model.tables.CardDao;
import com.web.hello.model.tables.Staff;

/**
 * Servlet implementation class ModifyStaffServlet
 */
@WebServlet(name = "staff/pream.do", urlPatterns = { "/staff/pream.do" })
public class ModifyStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Staff staff=new Staff();
		
		try {
			if(request.getParameter("id")!=null)
				staff.setId(Integer.parseInt(request.getParameter("id")));
			JDBC jdbc=new JDBC();
			jdbc.startConnection();
			String sql="select * from Staff where id="+staff.getId();
			System.out.println(sql);
			ResultSet rs=jdbc.query(sql);
			if(rs.next()) {
				staff.setCardnum(rs.getString("cardnum"));
				staff.setName(rs.getString("name"));
				staff.setYudxm(rs.getString("yudxm"));
				staff.setYuddate(rs.getLong("yuddate"));
				staff.setAmount(rs.getInt("amount"));
			}
			rs.close();
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> CardnumList=CardDao.getCardnumList();
		request.setAttribute("model", staff);
		request.setAttribute("model2", CardnumList);
		request.getRequestDispatcher("am_staff.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
