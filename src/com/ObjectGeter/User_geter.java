package com.ObjectGeter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.bsObject.Module;
import com.bsObject.User;
import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;
import com.ins.exeQueryResult;

public class User_geter {

	public static List<User> getAll() {
		exeQueryResult exq1 = new exeQueryResult(
				new Connectsql().Getconnection());
		List<User> alluser = new ArrayList<User>();
		String sql = "select * from D_USER";
		String resString[][] = exq1.getSelectResultWithStringArray(sql);
		if (resString != null)
			for (int i = 0; i < resString.length; i++)
				alluser.add(new User(resString[i]));
		return alluser;
	}

	public static User GetObj(String user_id) {
		for (User u : getAll()) {
			if (u.getUser_id().trim().equals(user_id.trim()))
				return u;
		}
		return null;
	}

	public static int MaxNum() {
		return getAll().size();
	}

	public static int CountTheNextId(String pidStr) {
		List<User> alluser = getAll();
		int pid = Integer.parseInt(pidStr);
		int max = pid * 100;
		for (User user : alluser) {
			int r_id = Integer.parseInt(user.getUser_id());
			if (r_id >= pid * 100 && r_id < (pid + 1) * 100)
				max = r_id > max ? r_id : max;
		}
		return max + 1;
	}

	public static boolean DoUserDelete(String uid) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("USER_ID", uid);
		exeInsertUpdateDelete exq1 = new exeInsertUpdateDelete(
				new Connectsql().Getconnection());
		try {
			return exq1.execSql("D_USER", exeInsertUpdateDelete.DELETE, hs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static String[] GetRelation(String user_id) {
		exeQueryResult exq1 = new exeQueryResult(
				new Connectsql().Getconnection());
		String sql = "Select FUNCTION_ID from D_R_USERFUN where USER_ID = ?";
		String resString[] = exq1.getSelectResultWithString(sql, user_id);
		return resString;
	}

}
