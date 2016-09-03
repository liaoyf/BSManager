package com.bsObject;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class User {
	public final static int LENGTH = 22; 
	private String user_id;
	private String org_id;
	private String user_name;
	private String login_uesr;
	private String password;
	private String gender;
	private String address;
	private String mail;
	private String e_mail;
	private String age;
	private String user_tel;
	private String bydate;
	private String byschool;
	private String subject;
	private String edu;
	private String marry;
	private String province;
	private String nation;
	private String user_birth;
	private String u_name;
	private String user_order;
	private String user_control;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String user_id, String org_id, String user_name,
			String login_uesr, String password, String gender, String address,
			String mail, String e_mail, String age, String user_tel,
			String bydate, String byschool, String subject, String edu,
			String marry, String province, String nation, String user_birth,
			String u_name, String user_order, String user_control) {
		this.user_id = user_id;
		this.org_id = org_id;
		this.user_name = user_name;
		this.login_uesr = login_uesr;
		this.password = login_uesr;
		this.gender = gender;
		this.address = address;
		this.mail = mail;
		this.e_mail = e_mail;
		this.age = age;
		this.user_tel = user_tel;
		this.bydate = bydate;
		this.byschool = byschool;
		this.subject = subject;
		this.edu = edu;
		this.marry = marry;
		this.province = province;
		this.nation = nation;
		this.user_birth = user_birth;
		this.u_name = u_name;
		this.user_order = user_order;
		this.user_control = user_control;

	}

	public User(String data[]) {
		if (data.length == LENGTH) {
			this.user_id = data[0];
			this.org_id = data[1];
			this.user_name = data[2];
			this.login_uesr = data[3];
			this.password = data[4];
			this.gender = data[5];
			this.address = data[6];
			this.mail = data[7];
			this.e_mail = data[8];
			this.age = data[9];
			this.user_tel = data[10];
			this.bydate = data[11];
			this.byschool = data[12];
			this.subject = data[13];
			this.edu = data[14];
			this.marry = data[15];
			this.province = data[16];
			this.nation = data[17];
			this.user_birth = data[18];
			this.u_name = data[19];
			this.user_order = data[20];
			this.user_control = data[21];
		}
		else System.out.println("User��String���鳤�ȴ���");
	}

	
	public static Hashtable<String,String> GetUserForm(HttpServletRequest request) {
		Hashtable<String, String> hs = new Hashtable<String, String>();
		hs.put("USER_ID", request.getParameter("User_id").toString());
		hs.put("ORG_ID", request.getParameter("org_id").toString());
		hs.put("USER_NAME", request.getParameter("User_name").toString());
		hs.put("GENDER", request.getParameter("Gender").toString());
		hs.put("ADDRESS", request.getParameter("Address").toString());
		hs.put("MAIL", request.getParameter("Mail").toString());
		hs.put("E_MAIL", request.getParameter("E_mail").toString());
		hs.put("AGE", request.getParameter("Age").toString());
		hs.put("USER_TEL", request.getParameter("User_tel").toString());
		hs.put("BYSCHOOL", request.getParameter("Byschool").toString());
		hs.put("BYDATE", request.getParameter("Bydate").toString());
		hs.put("SUBJECT", request.getParameter("Subject").toString());
		hs.put("EDU", request.getParameter("Edu").toString());
		hs.put("MARRY", request.getParameter("Marry").toString());
		hs.put("PROVINCE", request.getParameter("Province").toString());
		hs.put("NATION", request.getParameter("Nation").toString());
		hs.put("USER_BIRTH", request.getParameter("User_birth").toString());
		return hs;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getLogin_uesr() {
		return login_uesr;
	}

	public void setLogin_uesr(String login_uesr) {
		this.login_uesr = login_uesr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getBydate() {
		return bydate;
	}

	public void setBydate(String bydate) {
		this.bydate = bydate;
	}

	public String getByschool() {
		return byschool;
	}

	public void setByschool(String byschool) {
		this.byschool = byschool;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getUser_order() {
		return user_order;
	}

	public void setUser_order(String user_order) {
		this.user_order = user_order;
	}

	public String getUser_control() {
		return user_control;
	}

	public void setUser_control(String user_control) {
		this.user_control = user_control;
	}

}
