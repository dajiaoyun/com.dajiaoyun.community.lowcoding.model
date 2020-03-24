package com.dajiaoyun.community.lowcoding.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Attribute {
	protected List<FieldObject> fields;
	private HashMap<String,FieldObject> fieldObjects;
	public Attribute(){
		fields=new ArrayList<FieldObject>();
		fieldObjects=new HashMap<String,FieldObject>() ;
	}
	public String getAttribute(String attr){
		String val=null;
		if(fieldObjects.get(attr)!=null){
			val=fieldObjects.get(attr).getValue();
		}
		return val;
	}
	public void setAttribute(String attr,String val){
		FieldObject fo=fieldObjects.get(attr);
		if(fo!=null){
			fo.setValue(val);
		}else{
			fo=new FieldObject();
			fo.setKey(attr);
			fo.setValue(val);
			fieldObjects.put(attr, fo);
			fields.add(fo);
		}
		fo.setGeneratesql(true);
	}
	public void setAttribute(String attr,Object val){
		FieldObject fo=fieldObjects.get(attr);
		if(fo!=null){
			fo.setValue(val);
		}else{
			fo=new FieldObject();
			fo.setKey(attr);
			fo.setValue(val);
			fieldObjects.put(attr, fo);
			fields.add(fo);
		}
		fo.setGeneratesql(false);
	}
	
	public Object getObjectAttribute(String attr){
		FieldObject fo=null;
		Object val=null;
		if(fieldObjects.get(attr)!=null){
			fo=fieldObjects.get(attr);
			val=fo.getObjectValue();
		}
		return val;
	}
	public List<FieldObject> getFields() {
		return fields;
	}
	
}