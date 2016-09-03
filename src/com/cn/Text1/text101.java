package com.cn.Text1;

import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;
import com.ins.exeQueryResult;

public class text101 {

	public static void main(String args[]) {
		// Create a variable for the connection string.
		Connectsql consql = new Connectsql();
		exeInsertUpdateDelete exeiud = new exeInsertUpdateDelete(
				consql.Getconnection());
		String[] sql = {
				"insert into D_ORG(ORG_ID,ORG_NAME,ORG_ORDER,UP_ORG_ID) values(8,8,8,8)",
				"insert into D_ORG(ORG_ID,ORG_NAME,ORG_ORDER,UP_ORG_ID) values(7,7,7,7)" };
		exeQueryResult loginverify = new exeQueryResult(consql.Getconnection());
		System.out.println(loginverify.exeLoginQuery("admin", "admin"));
		//exeiud.execSql(sql);
		
	}

}