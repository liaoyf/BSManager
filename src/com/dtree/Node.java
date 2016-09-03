package com.dtree;

public class Node {  
    private int type = 0;
	private int id;  
    private String name;  
    private int pId;  
    private String url;
    private String userid;
    private String roleid;
    private String functionid;
    private String moduleid;
    private String orgid;
    
    
    
    public Node(){}  
    
    public Node(int id, String name, int pId, int type){  
        this.id = id;  
        this.name = name;  
        this.pId = pId;  
        this.type = type;
    } 
    
    
    public Node(int id, String name, int pId, String url, int type) {
    	this.id = id;
    	this.name = name;
    	this.pId = pId;
    	this.url = url;
    	this.type = type;
    }
    

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFunctionid() {
		return functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
    
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	

	public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getPId() {  
        return pId;  
    }  
    public void setPId(int id) {  
        pId = id;  
    }  
} 