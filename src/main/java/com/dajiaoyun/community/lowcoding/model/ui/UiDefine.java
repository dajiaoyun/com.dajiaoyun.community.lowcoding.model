package com.dajiaoyun.community.lowcoding.model.ui;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement  
@XmlType( propOrder = { "elementTypes"})  
public class UiDefine {
	@XmlElement(name = "element-type")  
	private List<ElementType> elementTypes;

	public List<ElementType> getElementTypes() {
		return elementTypes;
	}

	public void setElementTypes(List<ElementType> elementTypes) {
		this.elementTypes = elementTypes;
	}
	
	public ElementType getElementType(String id){
		ElementType ret=null;
		for(ElementType et:elementTypes){
			if(id.equals(et.getId())){
				ret=et;
				break;
			}
		}
		return ret;
	}
}
