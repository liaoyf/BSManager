package com.ObjectGeter;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.bsObject.Function;
import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;
import com.ins.exeQueryResult;

public class Function_geter {

	public static List<Function> getAll() {
		exeQueryResult exq1 = new exeQueryResult(
				new Connectsql().Getconnection());
		List<Function> allfunction = new ArrayList<Function>();
		String sql = "select * from D_FUNCTION";
		String resString[][] = exq1.getSelectResultWithStringArray(sql);
		if (resString != null)
			for (int i = 0; i < resString.length; i++)
				allfunction.add(new Function(resString[i]));
		return allfunction;
	}

	public static Function GetObjById(String function_id) {
		for (Function f : getAll()) {
			if (f.getFunction_id().trim().equals(function_id.trim()))
				return f;
		}
		return null;
	}

	public static Function GetObjByName(String function_name) {
		for (Function f : getAll()) {
			if (f.getFunction_name().trim().equals(function_name.trim()))
				return f;
		}
		return null;
	}

	public static Function GetObjByName(String function_name,
			List<Function> allfunc) {
		for (Function f : allfunc) {
			if (f.getFunction_name().trim().equals(function_name.trim()))
				return f;
		}
		return null;
	}

	public static DoubleList<Function> getDoubleList(String[] function_id) {
		List<Function> selectedfunction = new ArrayList<Function>();
		List<Function> unselectedfunction = new ArrayList<Function>();
		for (Function f : getAll()) {
			boolean isselected = false; //初始化
			for (int i = 0; i < function_id.length; i++)
				if ((f.getFunction_id().trim()).equals(function_id[i].trim())) {
					selectedfunction.add(f);
				isselected = true;
				}

			if (!isselected)
				unselectedfunction.add(f);
		}

		return new DoubleList<Function>(selectedfunction, unselectedfunction);
	}

	public static int CountTheNextId(String pidStr) {
		List<Function> allfun = getAll();
		int pid = Integer.parseInt(pidStr);
		int max = pid * 100;
		for (Function function : allfun) {
			int r_id = Integer.parseInt(function.getFunction_id());
			if (r_id >= pid * 100 && r_id < (pid + 1) * 100)
				max = r_id > max ? r_id : max;
		}		
		return max + 1;
	}
	
	public static boolean DoFunctionDelete(String fid) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("FUNCTION_ID", fid);
		exeInsertUpdateDelete exq1 = new exeInsertUpdateDelete(new Connectsql().Getconnection());
		try {
			return exq1.execSql("D_FUNCTION",exeInsertUpdateDelete.DELETE,hs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static int MaxNum() {
		return getAll().size();
	}

}