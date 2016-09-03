package com.bsObject;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class Function {
	public final static int LENGTH = 8;
	private String function_id;
	private String module_id;
	private String function_name;
	private String function_des;
	private String function_order;
	private String function_url;
	private String function_target;
	private String function_control;

	public Function() {
		// TODO Auto-generated constructor stub
	}

	public Function(String function_id, String module_id, String function_name, String function_des,
			String function_order, String function_url, String function_target,
			String function_control) {
		this.function_id = function_id;
		this.module_id = module_id;
		this.function_name = function_name;
		this.function_des = function_des;
		this.function_order = function_order;
		this.function_url = function_url;
		this.function_target = function_target;
		this.function_control = function_control;

	}

	public Function(String data[]) {
		if (data.length == LENGTH) {
			this.function_id = data[0];
			this.module_id = data[1];
			this.function_name = data[2];
			this.function_des = data[3];
			this.function_order = data[4];
			this.function_url = data[5];
			this.function_target = data[6];
			this.function_control = data[7];
		} else {
			System.out.println("Function��String���鳤�ȴ���");
		}
	}
	
	
	public static Hashtable<String,String> GetFunctionForm(HttpServletRequest request) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("FUNCTION_ID", request.getParameter("function_id").toString());
		hs.put("MODULE_ID", request.getParameter("module_id").toString()); //待完善
		hs.put("FUNCTION_NAME", request.getParameter("function_name").toString());
		hs.put("FUNCTION_DES", request.getParameter("function_des").toString());
		hs.put("FUNCTION_ORDER", request.getParameter("function_order").toString());
		hs.put("FUNCTION_URL", request.getParameter("function_url").toString());
		hs.put("FUNCTION_TARGET", request.getParameter("Openstyle").toString());
		return hs;
	}
	
	
	
	
	
	
	
	
	public String getFunction_id() {
		return function_id;
	}

	public void setFunction_id(String function_id) {
		this.function_id = function_id;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	public String getFunction_des() {
		return function_des;
	}

	public void setFunction_des(String function_des) {
		this.function_des = function_des;
	}

	public String getFunction_order() {
		return function_order;
	}

	public void setFunction_order(String function_order) {
		this.function_order = function_order;
	}

	public String getFunction_url() {
		return function_url;
	}

	public void setFunction_url(String function_url) {
		this.function_url = function_url;
	}

	public String getFunction_target() {
		return function_target;
	}

	public void setFunction_target(String function_target) {
		this.function_target = function_target;
	}

	public String getFunction_control() {
		return function_control;
	}

	public void setFunction_control(String function_control) {
		this.function_control = function_control;
	}

	public static int getLength() {
		return LENGTH;
	}
	
	
	
}
