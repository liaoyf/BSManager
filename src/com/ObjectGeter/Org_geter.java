package com.ObjectGeter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.bsObject.Function;
import com.bsObject.Org;
import com.bsObject.User;
import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;
import com.ins.exeQueryResult;

public class Org_geter {

	public static List<Org> getAll() {
		exeQueryResult exq1 = new exeQueryResult(
				new Connectsql().Getconnection());
		List<Org> allmodule = new ArrayList<Org>();
		String sql = "select * from D_ORG";
		String resString[][] = exq1.getSelectResultWithStringArray(sql);
		if (resString != null)
			for (int i = 0; i < resString.length; i++)
				allmodule.add(new Org(resString[i]));
		return allmodule;
	}

	public static int CountTheNextId(String pidStr) {
		List<Org> allorg = getAll();
		int pid = Integer.parseInt(pidStr);
		int max = pid * 100;
		for (Org org : allorg) {
			int r_id = Integer.parseInt(org.getOrg_id());
			if (r_id >= pid * 100 && r_id < (pid + 1) * 100)
				max = r_id > max ? r_id : max;
		}
		return max + 1;
	}

	public static boolean DoOrgDelete(String oid) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("ORG_ID", oid);
		boolean hasson = false;
		for (Org org : getAll()) { //若ORG有被引用
			if (org.getUp_org_id().equals(oid))
				hasson = true;
		}
		for (User user : User_geter.getAll()) {
			if (user.getOrg_id().equals(oid))
				hasson = true;
		}
		if (!hasson) {
			exeInsertUpdateDelete exq1 = new exeInsertUpdateDelete(
					new Connectsql().Getconnection());
			try {
				return exq1.execSql("D_ORG", exeInsertUpdateDelete.DELETE, hs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Org GetObjById(String Org_id) {
		for (Org o : getAll()) {
			if (o.getOrg_id().trim().equals(Org_id.trim()))
				return o;
		}
		return null;
	}
}
