package com.web.hello.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc直接连接数据库
 * 
 * mysql:
 * com.mysql.jdbc.Driver
 * jdbc:mysql://localhost:3306/dbname?characterEncoding=utf8&autoReconnect=true&useSSL=false
 * 
 * 
 * sqlite:
 * org.sqlite.JDBC
 * jdbc:sqlite://D:/tmp/LMYHXXCX.db
 * @author iceki
 *
 */
public class JDBC {
	private String driver;
	private String url;
	private String user;
	private String pass;

	/**
	 * 直接连接数据库，每个JDBC包含一个conn对象
	 */
	private Connection conn;

	public JDBC() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite://E:/webroot/vipcard.db";
		this.user = "";
		this.pass = "";
	}

	public JDBC(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * 初始化数据库连接，获得Connection对象
	 */
	public void startConnection() throws Exception {
		Class.forName(this.driver);
		this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
	}

	/**
	 * 关闭连接
	 * 
	 * @throws Exception
	 */
	public void stopConnection() throws Exception {
		if (this.conn != null) {
			this.conn.close();
			this.conn = null;
		}
	}

	/**
	 * 返回conn对象句柄，如果为null，则连接数据库
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		if (conn == null) {
			startConnection();
		}
		return conn;
	}

	/**
	 * 执行数据库查询操作，select
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(String sql) throws Exception {
		if (conn == null) {
			startConnection();
		}
		Statement tmpstmt = conn.createStatement();
		return tmpstmt.executeQuery(sql);
	}

	/**
	 * 执行数据库的更新，insert、update、delete
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int update(String sql) throws Exception {
		if (conn == null) {
			startConnection();
		}
		Statement tmpstmt = conn.createStatement();
		return tmpstmt.executeUpdate(sql);
	}

	/**
	 * 开启事务操作
	 * 
	 * @throws Exception
	 */
	public void startTransaction() throws Exception {
		if (conn == null) {
			startConnection();
		}
		this.conn.setAutoCommit(false);
	}

	/**
	 * 关闭事务，事务开启后，必须手工关闭
	 * 
	 * @throws Exception
	 */
	public void stopTransaction() throws Exception {
		// 事务如果没有开启，就直接返回
		if (this.conn == null || this.conn.getAutoCommit())
			return;
		this.conn.setAutoCommit(true);
	}

	public void commit() throws Exception {
		// 事务如果没有开启，就直接返回
		if (this.conn == null || this.conn.getAutoCommit())
			return;
		this.conn.commit();
	}

	public void rollback() throws Exception {
		// 事务如果没有开启，就直接返回
		if (this.conn == null || this.conn.getAutoCommit())
			return;
		this.conn.rollback();
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
