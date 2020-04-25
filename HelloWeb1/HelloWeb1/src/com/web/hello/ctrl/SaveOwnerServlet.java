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
import com.web.hello.model.tablse.Owner;

/**
 * Servlet implementation class SaveOwnerServlet
 */
@WebServlet(name = "owner/save.do", urlPatterns = { "/owner/save.do" })
public class SaveOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Owner owner=new Owner();
		try {
			if(request.getParameter("id")!=null)
				owner.setId(Integer.parseInt(request.getParameter("id")));
			if(request.getParameter("name")!=null)
				owner.setName(request.getParameter("name"));
			if(request.getParameter("age")!=null)
				owner.setAge(Integer.parseInt(request.getParameter("age")));
			if(request.getParameter("datetime")!=null)
				owner.setDatetime(request.getParameter("datetime"));
			if(request.getParameter("pcount")!=null)
				owner.setPcount(Integer.parseInt(request.getParameter("pcount")));
			if(request.getParameter("hname")!=null)
				owner.setHname(request.getParameter("hname"));
			if(request.getParameter("amount")!=null)
				owner.setAmount(request.getParameter("amount"));
			System.out.println("Owner:" + owner);
			
			JDBC jdbc=new JDBC();
		
			jdbc.startConnection();
			Connection conn=jdbc.getConnection();
			PreparedStatement ps;
			String sql="";
			if(owner.getId()==0)
				sql="insert into Owner(name,age,datetime,pcount,hname,amount) values(?,?,?,?,?,?)";
			else
				sql="update Owner set name=?,age=?,datetime=?,pcount=?,hname=?,amount=? where id=?";
			System.out.println("sql:" + sql);
			ps=conn.prepareStatement(sql);
			ps.setString(1, owner.getName());
			ps.setInt(2, owner.getAge());
			ps.setString(3, owner.getDatetime());
			ps.setInt(4, owner.getPcount());
			ps.setString(5, owner.getHname());
			ps.setString(6, owner.getAmount());
			if(owner.getId()!=0)
				ps.setInt(7,owner.getId());
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
