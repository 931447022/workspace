package com.web.hello.ctrl;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.hello.db.JDBC;
import com.web.hello.model.tables.CardDao;
import com.web.hello.model.tables.Staff;
import com.web.hello.model.tables.StaffListModel;

/**
 * Servlet implementation class StaffListServlet
 */
@WebServlet(name = "staff/list.do", urlPatterns = { "/staff/list.do" })
public class StaffListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		StaffListModel model=new StaffListModel();
		if(request.getParameter("cardnum")!=null)
			model.setCardnum(request.getParameter("cardnum"));
		if(request.getParameter("keyword")!=null)
			model.setKeyword(request.getParameter("keyword"));
		if(request.getParameter("page")!=null)
			model.getPage().setCurrentPage(Integer.parseInt(request.getParameter("page")));
		if(request.getParameter("pagesize")!=null)
			model.getPage().setPagesize(Integer.parseInt(request.getParameter("pagesize")));
		JDBC jdbc=new JDBC();
		try {
			jdbc.startConnection();
			String where="";
		if(model.getCardnum()!=null && !"".equals(model.getCardnum().trim()))
			where+=" and cardnum like '%"+model.getCardnum()+"%'";
		if(model.getKeyword()!=null && !"".equals(model.getKeyword().trim()))
			where+=" and (name like '%"+model.getKeyword()+"%' or cardnum like '%"+model.getKeyword()+"%')";
		String sql="select count(*) from Staff where 1=1"+where;
		ResultSet rs=jdbc.query(sql);
		if(rs.next()) {
			model.getPage().setTotalRecords(rs.getInt(1));
		}
		rs.close();
		int totalpage=model.getPage().getTotalRecords()/model.getPage().getPagesize();
		if(model.getPage().getTotalRecords()%model.getPage().getPagesize()!=0)
			totalpage++;
		model.getPage().setTotalpage(totalpage);
		
		sql="select * from Staff where 1=1"+where;
		sql+=" limit "+model.getPage().getPagesize();
		sql+=" offset "+(model.getPage().getCurrentPage()-1)*model.getPage().getPagesize();
		
		System.out.println(sql);
		rs=jdbc.query(sql);
			while(rs.next()) {
				Staff staff=new Staff();
				staff.setId(rs.getInt("id"));
				staff.setCardnum(rs.getString("cardnum"));
				staff.setName(rs.getString("name"));
				staff.setYudxm(rs.getString("yudxm"));
				staff.setYuddate(rs.getLong("yuddate"));
				staff.setAmount(rs.getInt("amount"));
				model.getStaffList().add(staff);
			}
			jdbc.stopConnection();			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setCardnumList(CardDao.getCardnumList());
		request.setAttribute("model", model);
		request.getRequestDispatcher("list_staff.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
