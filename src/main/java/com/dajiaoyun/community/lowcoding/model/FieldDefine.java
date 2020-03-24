package com.dajiaoyun.community.lowcoding.model;

public class FieldDefine {
	private String seq;
	private String id;
	private String tableName;
	private String tableCname;
	private String fieldName;
	private String fieldDisplayName;
	private String fieldDbLength;
	private String fieldFrontLength;
	private String fieldType;
	private String fieldDbType;//该字段对应数据库字段类型 String 对应Varchar
	private String fieldSeq;
	private String fieldIsVisible;
	private String fieldFrontComponentType;
	private String fieldFrontLineSeq;
	private String fieldAutoSysVal;//是否自动生成系统值，例如 编码=日期+0001
	private String fieldAutoSysValType;// 01字符型，格式：前缀+日期+0001 02 日期 YYYY-MM-DD HH:MM:SS
	private String fieldAutoSysValPrefix;//自动生成值前缀
	
	public static class FieldType{
		public final static String Input ="01";
		public final static String Select ="02";
		public final static String MultiCheckBox ="03";
		public final static String DateTime ="04";
		public final static String CheckBox ="05";
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFieldFrontLineSeq() {
		return fieldFrontLineSeq;
	}
	public void setFieldFrontLineSeq(String fieldFrontLineSeq) {
		this.fieldFrontLineSeq = fieldFrontLineSeq;
	}
	private String tenantno;
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
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldDisplayName() {
		return fieldDisplayName;
	}
	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
	}
	public String getFieldDbLength() {
		return fieldDbLength;
	}
	public void setFieldDbLength(String fieldDbLength) {
		this.fieldDbLength = fieldDbLength;
	}
	public String getFieldFrontLength() {
		return fieldFrontLength;
	}
	public void setFieldFrontLength(String fieldFrontLength) {
		this.fieldFrontLength = fieldFrontLength;
	}
	
	public String getFieldDbType() {
		return fieldDbType;
	}
	public void setFieldDbType(String fieldDbType) {
		this.fieldDbType = fieldDbType;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldSeq() {
		return fieldSeq;
	}
	public void setFieldSeq(String fieldSeq) {
		this.fieldSeq = fieldSeq;
	}
	public String getFieldIsVisible() {
		return fieldIsVisible;
	}
	public void setFieldIsVisible(String fieldIsVisible) {
		this.fieldIsVisible = fieldIsVisible;
	}
	public String getFieldFrontComponentType() {
		return fieldFrontComponentType;
	}
	public void setFieldFrontComponentType(String fieldFrontComponentType) {
		this.fieldFrontComponentType = fieldFrontComponentType;
	}
	public String getTenantno() {
		return tenantno;
	}
	public void setTenantno(String tenantno) {
		this.tenantno = tenantno;
	}
	public String getFieldAutoSysVal() {
		return fieldAutoSysVal;
	}
	public void setFieldAutoSysVal(String fieldAutoSysVal) {
		this.fieldAutoSysVal = fieldAutoSysVal;
	}
	public String getFieldAutoSysValType() {
		return fieldAutoSysValType;
	}
	public void setFieldAutoSysValType(String fieldAutoSysValType) {
		this.fieldAutoSysValType = fieldAutoSysValType;
	}
	public String getFieldAutoSysValPrefix() {
		return fieldAutoSysValPrefix;
	}
	public void setFieldAutoSysValPrefix(String fieldAutoSysValPrefix) {
		this.fieldAutoSysValPrefix = fieldAutoSysValPrefix;
	}
	
}
