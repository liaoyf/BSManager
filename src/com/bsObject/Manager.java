package com.bsObject;

public class Manager {
	public final static int LENGTH = 7;
	private String manager_id;
	private String org_id;
	private String manager_name;
	private String manager_login;
	private String manager_pwd;
	private String manager_order;
	private String manager_control;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Manager(String manager_id, String org_id, String manager_name,
			String manager_login, String manager_pwd, String manager_order,
			String manager_control) {
		this.manager_id = manager_id;
		this.org_id = org_id;
		this.manager_name = manager_name;
		this.manager_login = manager_login;
		this.manager_pwd = manager_pwd;
		this.manager_order = manager_order;
		this.manager_control = manager_control;
	}

	public Manager(String data[]) {
		if (data.length == LENGTH) {
			this.manager_id = data[0];
			this.org_id = data[1];
			this.manager_name = data[2];
			this.manager_login = data[3];
			this.manager_pwd = data[4];
			this.manager_order = data[5];
			this.manager_control = data[6];
		} else {
			System.out.println("Manager��String���鳤�ȴ���");
		}

	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_login() {
		return manager_login;
	}

	public void setManager_login(String manager_login) {
		this.manager_login = manager_login;
	}

	public String getManager_pwd() {
		return manager_pwd;
	}

	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}

	public String getManager_order() {
		return manager_order;
	}

	public void setManager_order(String manager_order) {
		this.manager_order = manager_order;
	}

	public String getManager_control() {
		return manager_control;
	}

	public void setManager_control(String manager_control) {
		this.manager_control = manager_control;
	}

	public static int getLength() {
		return LENGTH;
	}

}
