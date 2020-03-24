package com.dajiaoyun.community.lowcoding.model.domain;

/**
 * 部门
 * @author root
 *
 */
public class Department {
	private String departid;
	private String departname;
	private Manager manager;
	private Director director;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	
}