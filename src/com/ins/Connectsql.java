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
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}

		try {
			 
			con = DriverManager.getConnection(str);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// if (con != null) System.out.println("连接成功！！");
	}
	public Connection Getconnection() {
		return con;
	}
}
