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
			if(request.getParameter("name")!=null)
				staff.setName(request.getParameter("name"));
			if(request.getParameter("depart")!=null)
				staff.setDepart(request.getParameter("depart"));
			if(request.getParameter("code")!=null)
				staff.setCode(request.getParameter("code"));
			if(request.getParameter("gender")!=null)
				staff.setGender(Integer.parseInt(request.getParameter("gender")));
			if(request.getParameter("birthyear")!=null)
				staff.setBirthyear(Integer.parseInt(request.getParameter("birthyear")));
			if(request.getParameter("resume")!=null)
				staff.setResume(request.getParameter("resume"));
			if(request.getParameter("enrolldate")!=null)
				staff.setEnrolldate(request.getParameter("enrolldate"));
			if(request.getParameter("id")!=null)
				staff.setId(Integer.parseInt(request.getParameter("id")));
			JDBC jdbc=new JDBC();
		
			jdbc.startConnection();
			Connection conn=jdbc.getConnection();
			PreparedStatement ps;
			String sql="";
			if(staff.getId()==0)
				sql="insert into Staff(name,code,depart,gender,birthyear,resume,enrolldate) values(?,?,?,?,?,?,?)";
			else
				sql="update Staff set name=?,code=?,depart=?,gender=?,birthyear=?,resume=?,enrolldate=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getCode());
			ps.setString(3, staff.getDepart());
			ps.setInt(4, staff.getGender());
			ps.setInt(5, staff.getBirthyear());
			ps.setString(6, staff.getResume());
			ps.setLong(7, staff.getEnrolldate());
			if(staff.getId()!=0)
				ps.setInt(8, staff.getId());
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
