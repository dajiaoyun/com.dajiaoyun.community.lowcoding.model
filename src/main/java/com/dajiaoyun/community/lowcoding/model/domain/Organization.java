package com.dajiaoyun.community.lowcoding.model.domain;

public class Organization {
	private String org_no;
	private String org_name;
	private Organization branch;
	private String parentno;
	public String getOrg_no() {
		return org_no;
	}
	public void setOrg_no(String org_no) {
		this.org_no = org_no;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public Organization getBranch() {
		return branch;
	}
	public void setBranch(Organization branch) {
		this.branch = branch;
	}
	public String getParentno() {
		return parentno;
	}
	public void setParentno(String parentno) {
		this.parentno = parentno;
	}
	
	
}