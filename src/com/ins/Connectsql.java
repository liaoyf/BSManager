package com.ins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  Connectsql {
	private Connection con = null;
	public Connectsql() {
			String str = "jdbc:odbc:EDUDSN";
			  try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (ClassNotFoundException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

		try {
			 
			con = DriverManager.getConnection(str);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// if (con != null) System.out.println("杩炴帴鎴愬姛锛侊紒");
	}
	public Connection Getconnection() {
		return con;
	}
}
