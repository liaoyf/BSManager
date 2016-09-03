package com.bsObject;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class Module {
	public final static int LENGTH = 6;
	private String module_id;
	private String module_name;
	private String module_order;
	private String module_url;
	private String up_module_id;
	private String module_control;

	
	public Module() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Module(String module_id, String module_name, String module_order,
			String module_url, String up_module_id, String module_control) {

		this.module_id = module_id;
		this.module_name = module_name;
		this.module_order = module_order;
		this.module_url = module_url;
		this.up_module_id = up_module_id;
		this.module_control = module_control;
	}

	public Module(String data[]) {
		if (data.length == LENGTH) {
			this.module_id = data[0];
			this.module_name = data[1];
			this.module_order = data[2];
			this.module_url = data[3];
			this.up_module_id = data[4];
			this.module_control = data[5];
		} else {
			System.out.println("Module��String���鳤�ȴ���");
		}

	}
	
	public static Hashtable<String,String> GetModuleForm(HttpServletRequest request) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("MODULE_ID", request.getParameter("module_id").toString());
		hs.put("MODULE_NAME", request.getParameter("module_name").toString());
		hs.put("UP_MODULE_ID", request.getParameter("up_module_id").toString());
		hs.put("MODULE_URL", request.getParameter("module_url").toString());
		hs.put("MODULE_ORDER", request.getParameter("module_order").toString());
		return hs;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_order() {
		return module_order;
	}

	public void setModule_order(String module_order) {
		this.module_order = module_order;
	}

	public String getModule_url() {
		return module_url;
	}

	public void setModule_url(String module_url) {
		this.module_url = module_url;
	}

	public String getUp_module_id() {
		return up_module_id;
	}

	public void setUp_module_id(String up_module_id) {
		this.up_module_id = up_module_id;
	}

	public String getModule_control() {
		return module_control;
	}

	public void setModule_control(String module_control) {
		this.module_control = module_control;
	}

	public static int getLength() {
		return LENGTH;
	}
}
