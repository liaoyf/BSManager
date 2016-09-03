package com.bsObject;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class Org {
	public final static int LENGTH = 4;
	private String org_id;
	private String org_name;
	private String org_order;
	private String up_org_id;

	
	public Org() {
		// TODO Auto-generated constructor stub
	}
	
	public Org(String org_id, String org_name, String org_order,
			String up_org_id) {
		this.org_id = org_id;
		this.org_name = org_name;
		this.org_order = org_order;
		this.up_org_id = up_org_id;
	}

	public Org(String data[]) {
		if (data.length == LENGTH) {
			this.org_id = data[0];
			this.org_name = data[1];
			this.org_order = data[2];
			this.up_org_id = data[3];
		} else {
			System.out.println("Org��String���鳤�ȴ���");
		}
	}
	
	
	public static Hashtable<String,String> GetOrgForm(HttpServletRequest request) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("ORG_ID", request.getParameter("Org_id").toString());
		hs.put("UP_ORG_ID", request.getParameter("up_org_id").toString());
		hs.put("ORG_NAME", request.getParameter("Org_name").toString());
		return hs;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_order() {
		return org_order;
	}

	public void setOrg_order(String org_order) {
		this.org_order = org_order;
	}

	public String getUp_org_id() {
		return up_org_id;
	}

	public void setUp_org_id(String up_org_id) {
		this.up_org_id = up_org_id;
	}

	public static int getLength() {
		return LENGTH;
	}
}
