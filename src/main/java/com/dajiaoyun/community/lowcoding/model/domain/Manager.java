package com.dajiaoyun.community.lowcoding.model.domain;

/**
 * 部门经理
 * @author root
 *
 */
public class Manager {
	private String usrno; //部门经理 员工编码
	private String usrname;//姓名
	public String getUsrno() {
		return usrno;
	}
	public void setUsrno(String usrno) {
		this.usrno = usrno;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
}