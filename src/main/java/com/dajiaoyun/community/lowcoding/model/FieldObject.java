package com.dajiaoyun.community.lowcoding.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldObject implements Cloneable,Serializable{
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private Object objectvalue;
	private String type;
	private boolean primaryKey;
	
	private boolean autogeneratePK;
	
	private boolean nullupdate;
	private boolean generatesql;
	private List<FieldObject> fields;
//	private HashMap<String,FieldObject> fieldObjects;
	private TableObject tableObject;
	public TableObject getTableObject() {
		return tableObject;
	}
	public void setTableObject(TableObject tableObject) {
		this.tableObject = tableObject;
	}
	public FieldObject(){
		nullupdate=true;
		generatesql=true;
		fields=new ArrayList<FieldObject>();
//		fieldObjects=new HashMap<String,FieldObject>() ;
	}
	public FieldObject(String key,String val){
		this.key=key;
		this.value=val;
		this.type=DBConstant.STRING;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
		this.generatesql=true;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	/**
	 * replaced by isAutogeneratePK
	 * @param autogenerate
	 */
	@Deprecated
	public boolean isAutogenerate() {
		return autogeneratePK;
	}
	
	/**
	 * replaced by setAutogeneratePK
	 * @param autogenerate
	 */
	@Deprecated
	public void setAutogenerate(boolean autogenerate) {
		this.autogeneratePK= autogenerate;
	}
	// if aoto generate primary key by system
	public boolean isAutogeneratePK() {
		return autogeneratePK;
	}
	/**
	 *  if aoto generate primary key by system
	 * @param autogeneratePK
	 */
	public void setAutogeneratePK(boolean autogeneratePK) {
		this.autogeneratePK = autogeneratePK;
	}
	public boolean isNullupdate() {
		return nullupdate;
	}
	public void setNullupdate(boolean nullupdate) {
		this.nullupdate = nullupdate;
	}
	public boolean isGeneratesql() {
		return generatesql;
	}
	public void setGeneratesql(boolean generatesql) {
		this.generatesql = generatesql;
	}
	public Object getObjectValue() {
		return objectvalue;
	}
	public void setValue(Object objectvalue) {
		this.objectvalue = objectvalue;
	}	
	
	public String getAttribute(String attr){
//		String val=null;
//		if(fieldObjects.get(attr)!=null){
//			val=fieldObjects.get(attr).getValue();
//		}
		return value;
	}
	public void setAttribute(String attr,String val){
//		FieldObject fo=fieldObjects.get(attr);
//		if(fo!=null){
//			fo.setValue(val);
//		}else{
//			fo=new FieldObject();
//			fo.setKey(attr);
//			fo.setValue(val);
//			fieldObjects.put(attr, fo);
//			fields.add(fo);
//		}
//		fo.setGeneratesql(true);
		this.key=attr;
		this.value=val;
		this.generatesql=true;
	}
	public void add(FieldObject foo){
		fields.add(foo);
	}
	
	public List<FieldObject> getFields() {
		return fields;
	}
	
}
