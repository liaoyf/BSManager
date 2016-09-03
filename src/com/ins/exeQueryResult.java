package com.ins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exeQueryResult {
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public exeQueryResult(Connection con) {
		this.con = con;
	}

	public static void PrintArr(String[][] arr) {
		if (arr != null)
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
	}

	public String[][] getSelectResultWithStringArray(String sql) {
		String[][] arr1 = null;
		PreparedStatement ps = null;
		int i = 0;
		int rowCount = 0, columnCount = 0;
		try {
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rs.last();
				rowCount = rs.getRow();
				columnCount = rs.getMetaData().getColumnCount();
				arr1 = new String[rowCount][columnCount];
				rs.first();
				do {
					for (int j = 0; j < columnCount; j++)
						arr1[i][j] = rs.getString(j + 1);
					i++;
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr1;
	}

	/**
	 * 从一段查询语句中获取一组数据
	 * 
	 * @param sql
	 * @return
	 */
	public String[] getSelectResultWithString(String sql, String id) {
		String[] arr1 = null;
		int row = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			rs.last();
			row = rs.getRow();
			arr1 = new String[row]; // 注意跳到行尾后调用完要再回来
			rs.first();
			if (arr1.length > 0) {
				int j = 0;
				do {
						arr1[j++] = rs.getString(1); //因之查询了一列，故只获取一列，即getString(1)
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr1;
	}

	public boolean exeLoginQuery(String loginuser, String password) {
		boolean isright = false;
		String sql = "select PASSWORD from D_USER where LOGIN_USER = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginuser);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (password.equals(rs.getString(1).trim()))
					isright = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isright;
	}
}
