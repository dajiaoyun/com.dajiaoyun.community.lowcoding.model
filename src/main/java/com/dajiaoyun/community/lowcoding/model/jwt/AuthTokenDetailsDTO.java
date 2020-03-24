package com.dajiaoyun.community.lowcoding.model.jwt;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AuthTokenDetailsDTO {
	public String userId;
	public String userName;
	public String password;
	public String tenantno;
	public String from;//请求的API来自于哪个，例如Web
	public List<String> roles;
//	public List<Menu> menus;
//	public Tenant tenant;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public Date expirationDate;
}
