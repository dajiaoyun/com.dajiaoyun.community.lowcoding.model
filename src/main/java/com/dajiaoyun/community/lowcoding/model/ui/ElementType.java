package com.dajiaoyun.community.lowcoding.model.ui;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author root
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement  
@XmlType(name = "element-type", propOrder = { "html", "id" ,"react","vue","angular","weixin"})  
public class ElementType {
	
	private String html;
	private String react;
	private String vue;
	private String angular;
	private String weixin;
	@XmlAttribute  
	private String id;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getReact() {
		return react;
	}
	public void setReact(String react) {
		this.react = react;
	}
	public String getVue() {
		return vue;
	}
	public void setVue(String vue) {
		this.vue = vue;
	}
	public String getAngular() {
		return angular;
	}
	public void setAngular(String angular) {
		this.angular = angular;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
}
