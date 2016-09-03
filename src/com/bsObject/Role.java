package com.bsObject;

public class Role {
	public final static int LENGTH = 5;
	private String role_id;
	private String org_id;
	private String role_name;
	private String role_describe;
	private String role_order;

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Role(String role_id, String org_id, String role_name,
			String role_describe, String role_order) {
		this.role_id = role_id;
		this.org_id = org_id;
		this.role_name = role_name;
		this.role_describe = role_describe;
		this.role_order = role_order;
	}

	public Role(String data[]) {
		if (data.length == LENGTH) {
			this.role_id = data[0];
			this.org_id = data[1];
			this.role_name = data[2];
			this.role_describe = data[3];
			this.role_order = data[4];
		} else {
			System.out.println("Role��String���鳤�ȴ���");
		}
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_describe() {
		return role_describe;
	}

	public void setRole_describe(String role_describe) {
		this.role_describe = role_describe;
	}

	public String getRole_order() {
		return role_order;
	}

	public void setRole_order(String role_order) {
		this.role_order = role_order;
	}

	public static int getLength() {
		return LENGTH;
	}

}
