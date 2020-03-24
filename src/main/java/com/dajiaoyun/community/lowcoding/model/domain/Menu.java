package com.dajiaoyun.community.lowcoding.model.domain;

/** 
 * 2008-5-6
 * @ author Xing Botao
 */
public class Menu {
	private String menuno;
	private String menuname;
	private String menuurl;
	private String menuicon;
	private String tenantno;
	private String applyservicetype;
	private int position;
	private String parentno;
	private String level;
	private String p_roleno;
	
	public String getP_Roleno() {
		return p_roleno;
	}
	public void setP_Roleno(String roleno) {
		this.p_roleno = roleno;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	private Menu[] subMenu;
	public Menu[] getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(Menu[] subMenu) {
		this.subMenu = subMenu;
	}
	public String getMenuno() {
		return menuno;
	}
	public void setMenuno(String menuno) {
		this.menuno = menuno;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}
	public String getTenantno() {
		return tenantno;
	}
	public void setTenantno(String companyno) {
		this.tenantno = companyno;
	}
	public String getApplyservicetype() {
		return applyservicetype;
	}
	public void setApplyservicetype(String applyservicetype) {
		this.applyservicetype = applyservicetype;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getParentno() {
		return parentno;
	}
	public void setParentno(String parentno) {
		this.parentno = parentno;
	}
	
}
