package com.web.hello.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.web.hello.db.JDBC;

public class RhouseDao {
	public static ArrayList<String> getRhouseList(){
		ArrayList<String> RhouseList=new ArrayList<>();
		JDBC jdbc=new JDBC();
		try {
			jdbc.startConnection();
			String sql="select Rhouse from House";
			ResultSet rs =jdbc.query(sql);
			while(rs.next()) {
				RhouseList.add(rs.getString("Rhouse"));
			}
			rs.close();
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RhouseList;
	}
}
