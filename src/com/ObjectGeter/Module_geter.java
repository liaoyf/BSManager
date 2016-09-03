package com.ObjectGeter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.bsObject.Function;
import com.bsObject.Module;
import com.bsObject.Org;
import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;
import com.ins.exeQueryResult;

public class Module_geter {

	public static List<Module> getAll() {
		exeQueryResult exq1 = new exeQueryResult(
				new Connectsql().Getconnection());
		List<Module> allmodule = new ArrayList<Module>();
		String sql = "select * from D_MODULE";
		String resString[][] = exq1.getSelectResultWithStringArray(sql);
		if (resString != null)
			for (int i = 0; i < resString.length; i++)
				allmodule.add(new Module(resString[i]));
		return allmodule;
	}

	public static int CountTheNextId(String pidStr) {
		List<Module> allmodule = getAll();
		int pid = Integer.parseInt(pidStr);
		int max = pid * 100;
		for (Module module : allmodule) {
			int r_id = Integer.parseInt(module.getModule_id());
			if (r_id >= pid * 100 && r_id < (pid + 1) * 100)
				max = r_id > max ? r_id : max;
		}
		return max + 1;
	}

	public static boolean DoModuleDelete(String mid) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("MODULE_ID", mid);
		boolean hasson = false;
		for (Module module : getAll()) { // 若Module有被引用
			if (module.getUp_module_id().equals(mid))
				hasson = true;
		}
		for (Function function : Function_geter.getAll()) { // 若Module有被引用
			if (function.getModule_id().equals(mid))
				hasson = true;
		}
		if (!hasson) {
			exeInsertUpdateDelete exq1 = new exeInsertUpdateDelete(
					new Connectsql().Getconnection());
			try {
				return exq1.execSql("D_MODULE", exeInsertUpdateDelete.DELETE,
						hs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public static Module GetObjById(String module_id) {
		for (Module m : getAll()) {
			if (m.getModule_id().trim().equals(module_id.trim()))
				return m;
		}
		return null;
	}
}
