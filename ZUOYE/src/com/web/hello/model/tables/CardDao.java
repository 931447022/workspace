package com.web.hello.model.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.web.hello.db.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.web.hello.db.JDBC;

public class CardDao {
	public static ArrayList<String> getCardnumList(){
		ArrayList<String> cardList=new ArrayList<>();
		JDBC jdbc=new JDBC();
		try {
			jdbc.startConnection();
			String sql="select cardnum from card";
			ResultSet rs =jdbc.query(sql);
			while(rs.next()) {
				cardList.add(rs.getString("cardnum"));
			}
			rs.close();
			jdbc.stopConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardList;
	}
}