package com.dajiaoyun.community.lowcoding.model.domain;

/** 
 * 2008-5-6
 * @ author Xing Botao
 */

public class Role {
	private String roleno;
	private String rolename;
	private String tenantno;
	private String remark;
	
	public String getTenantno() {
		return tenantno;
	}
	public void setTenantno(String tenantno) {
		this.tenantno = tenantno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRoleno() {
		return roleno;
	}
	public void setRoleno(String roleno) {
		this.roleno = roleno;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}