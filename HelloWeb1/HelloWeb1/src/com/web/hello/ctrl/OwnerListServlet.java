package com.web.hello.ctrl;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.ModelAbstractChannelMixer;
import com.web.hello.db.JDBC;
import com.web.hello.model.tablse.Owner;
import com.web.hello.model.OwnerListModel;
import com.web.hello.model.RhouseDao;


/**
 * Servlet implementation class OwnerListServlet
 */
@WebServlet(name = "owner/list.do", urlPatterns = { "/owner/list.do" })
public class OwnerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		OwnerListModel model=new OwnerListModel();
		String Rhouse =request.getParameter("Rhouse");
		String keyword =request.getParameter("keyword");
		JDBC jdbc=new JDBC();
		ArrayList<Owner>list=new ArrayList<>();
		try {
			jdbc.startConnection();
			String sql="select * from owner where 1=1";
			if(Rhouse!=null&&!"".equals(Rhouse.trim()))
				sql+=" and Rhouse like '%"+Rhouse+"%'";
			if(keyword!=null&&!"".equals(keyword.trim()))
				sql+=" and (Hname like '%"+keyword+"%'or Id like'%"+keyword+"%')";
			System.out.println(sql);
			ResultSet rs=jdbc.query(sql);
			while(rs.next()) {
				Owner owner=new Owner();
				owner.setId(rs.getInt("id"));
				owner.setName(rs.getString("name"));
				owner.setAge(rs.getInt("age"));
				owner.setDatetime(rs.getString("datetime"));
				owner.setPcount(rs.getInt("pcount"));
				owner.setHname(rs.getString("hname"));
				owner.setAmount(rs.getString("amount"));
				owner.setRhouse(rs.getString("rhouse"));
				list.add(owner);
			}
			jdbc.stopConnection();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setRhouseList(RhouseDao.getRhouseList());
		request.setAttribute("model",list);
		request.getRequestDispatcher("list_owner.jsp").forward(request, response);		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
