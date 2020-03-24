package com.dajiaoyun.community.lowcoding.model.domain;

import com.dajiaoyun.community.lowcoding.model.Attribute;

public class Shop extends Attribute{
	private String name;
	private String appkey;
	private String appsecret;
	private String warehouseno;
	private String warehousename;
	private String shopid;
	private String sessionkey;
	private String shop_sid;
	private String shop_url;
	private String tenantno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getWarehouseno() {
		return warehouseno;
	}
	public void setWarehouseno(String warehouseno) {
		this.warehouseno = warehouseno;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
	public String getShop_sid() {
		return shop_sid;
	}
	public void setShop_sid(String taoshop_id) {
		this.shop_sid = taoshop_id;
	}
	public String getTenantno() {
		return tenantno;
	}
	public void setTenantno(String tenantno) {
		this.tenantno = tenantno;
	}
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public String getShop_url() {
		return shop_url;
	}
	public void setShop_url(String shop_url) {
		this.shop_url = shop_url;
	}
	
	
}