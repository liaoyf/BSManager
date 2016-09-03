package com.ins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class exeInsertUpdateDelete {
	public final static int INSERT = 1;
	public final static int UPDATE = 2;
	public final static int DELETE = 3;
	public static String keyMark = "$";
	public static String nonKeyMark = "_";

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public exeInsertUpdateDelete(Connection con) {
		this.con = con;
	}

	private String[] moveidtolast(String[] strarr) {
		int flag = 0;
		for (int i = strarr.length - 1; i > 0; i--) {
			if (strarr[i].trim().equals("ORG_ID")) flag = 1;
			if (strarr[i].trim().equals("USER_ID")
					|| strarr[i].trim().equals("FUNCTION_ID")
					|| strarr[i].trim().equals("ROLE_ID")
					|| strarr[i].trim().equals("MODULE_ID")
					|| strarr[i].trim().equals("ORG_ID")) {
				String tempString = strarr[strarr.length - 1];
				strarr[strarr.length - 1] = strarr[i];
				strarr[i] = tempString;
				if (flag != 1) break;
			}
		}
		return strarr;
	}

	/**
	 * 为一个表执行一个操作，包括增删改。参数由哈希表传入
	 * @param tableName : 表名
	 * @param tableAction ：执行操作
	 * @param dbParam ：哈希表
	 * @return 返回执行成功与否
	 * @throws SQLException
	 */
	public boolean execSql(String tableName, int tableAction,
			Hashtable<String, String> dbParam) throws SQLException {
		String sql = "";
		String[] keycoll = moveidtolast(dbParam.keySet().toArray(
				new String[dbParam.size()]));
		switch (tableAction) {
		case INSERT:
			sql += "insert into " + tableName + "(";
			for (int i = 0; i < keycoll.length; i++) {
				sql += keycoll[i];
				if (i < keycoll.length - 1)
					sql += ",";
			}
			sql += ") values(";
			for (int i = 0; i < keycoll.length; i++) {
				sql += "?";
				if (i < keycoll.length - 1)
					sql += ",";
			}
			sql += ")";
			break;
		case UPDATE:
			sql += "update " + tableName + " set ";
			for (int i = 0; i < keycoll.length - 1; i++) {
				sql += keycoll[i] + " = " + "?";
				if (i < keycoll.length - 2)
					sql += ",";
			}
			sql += " where " + keycoll[keycoll.length - 1] + " = ?";
			break;
		case DELETE:
			sql += "delete " + tableName + " where " + keycoll[keycoll.length - 1] + " = ?";
			break;
		default:
			break;
		}
		System.out.println(sql);
		PreparedStatement pres = con.prepareStatement(sql);
		for (int i = 0; i < keycoll.length; i++) {
			pres.setString(i + 1, dbParam.get(keycoll[i]).toString());
		}
		pres.addBatch();
		int Count[] = pres.executeBatch();
		if (Count[0] != 0)
			return true;
		else
			return false;
	}

	public boolean execSql(String sqlStr) {
		boolean isexe = false;
		try {
			PreparedStatement ps = con.prepareStatement(sqlStr);
			if (ps.executeUpdate() != 0) {
				isexe = true;
			} else {
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return isexe;
	}
	
/**
 * 执行一段数据库事务，处理一组数据库操作
 * @param sql ： String类型数组
 * @return true表示执行成功.否则失败
 */
	public boolean execSql(String[] sql) {
		boolean issuccess = false;
		Statement stmt = null;
		try {
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			stmt = con.createStatement();
			for (int i = 0; i < sql.length; i++) {
				stmt.addBatch(sql[i]);
			}
			int[] Count = stmt.executeBatch();
			con.commit();
			issuccess = true;
			con.setAutoCommit(true);
		} catch (SQLException e) {

			e.printStackTrace();
			try {

				if (con != null) {
					con.rollback();
					con.setAutoCommit(true);
				}
			} catch (SQLException se1) {
				se1.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return issuccess;
	}

}
