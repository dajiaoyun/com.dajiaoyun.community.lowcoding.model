package com.dajiaoyun.community.lowcoding.model;

import java.util.List;

public class TableDefine {
	private String id;
	private String tableName;
	private String tableCname;
	private String tenantno;
	private List<FieldDefine> fields;
	public List<FieldDefine> getFields() {
		return fields;
	}
	public void setFields(List<FieldDefine> fields) {
		this.fields = fields;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableCname() {
		return tableCname;
	}
	public void setTableCname(String tableCname) {
		this.tableCname = tableCname;
	}
	
	public String getTenantno() {
		return tenantno;
	}
	public void setTenantno(String tenantno) {
		this.tenantno = tenantno;
	}
	
	
}
