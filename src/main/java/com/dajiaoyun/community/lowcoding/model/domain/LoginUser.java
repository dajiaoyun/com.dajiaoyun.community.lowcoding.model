package com.dajiaoyun.community.lowcoding.model.domain;

import java.util.ArrayList;
import java.util.List;

import com.dajiaoyun.community.lowcoding.model.Attribute;

public class LoginUser extends Attribute{
	private String usrname;
	private String usrpwd;
	private Tenant tenant;
	private String usrno;
	private int usrid;
	private String status;
	private String email;
	private String telephone;
	private String cellphone;
	private String activeaddress;
	private String postcode;
	private String registerdate;
	private String msn;
	private String qq;
	private String birthday;
	private String gender;
	private String oriusrno;
	private String partnerno;
	private Role[] roles;
	private Menu[] menus;
	private List<Menu> allMenus;
	private JobTitle jobTitle;
	private Department department;
	private Organization organization;
	
	
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public LoginUser(){
		super();
		menus=new Menu[0];
	}
	public Menu getMenu(String menuno) {
		Menu ret=null;
		for(int i=0;i<menus.length;i++){
			if(menus[i].getMenuno().equals(menuno)||menus[i].getMenuurl().equals(menuno)){
				ret=menus[i];
				break;
			}else{
				if(menus[i].getSubMenu()!=null){
					for(int j=0;j<menus[i].getSubMenu().length;j++){
						if(menus[i].getSubMenu()[j].getMenuno().equals(menuno)||menus[i].getSubMenu()[j].getMenuurl().equals(menuno)){
							ret=menus[i].getSubMenu()[j];
							break;
						}
					}
				}
			}
		}
		if(ret==null&&this.allMenus!=null){
			for(Menu menu:allMenus){
				if(menu.getMenuno().equals(menuno)||menu.getMenuurl().equals(menuno)){
					ret=menu;
					break;
				}
			}
		}
		return ret;
	}
//	public Menu[] getSubMenus(String menuno) {
//		Menu[] ret=null;
//		List<Menu> l_menus=new ArrayList<Menu>();
//		for(int i=0;i<menus.length;i++){
//			if(menus[i].getMenuno().equals(menuno)){
//				l_menus.add(menus[i]);
//			}
//		}
//		ret=new Menu[l_menus.size()];
//		ret=l_menus.toArray(ret);
//		return ret;
//	}
	
	public Menu[] getSubMenus(String parent_menuno) {
		Menu[] ret=null;
		List<Menu> l_menus=new ArrayList<Menu>();
		for(int i=0;i<menus.length;i++){
			if(menus[i].getParentno().equals(parent_menuno)){
				l_menus.add(menus[i]);
			}
		}
		ret=new Menu[l_menus.size()];
		ret=l_menus.toArray(ret);
		return ret;
	}
	
	public List<Menu> getAllMenus() {
		return allMenus;
	}
	public void setAllMenus(List<Menu> allMenus) {
		this.allMenus = allMenus;
	}
	public Menu[] getMenus() {
		return menus;
	}
	public void setMenus(Menu[] menus) {
		this.menus = menus;
	}
	
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsrpwd() {
		return usrpwd;
	}
	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
	
	public String getUsrno() {
		return usrno;
	}
	public void setUsrno(String usrno) {
		this.usrno = usrno;
	}
	public Role[] getRoles() {
		return roles;
	}
	public void setRoles(Role[] roles) {
		this.roles = roles;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUsrid() {
		return usrid;
	}
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getActiveaddress() {
		return activeaddress;
	}
	public void setActiveaddress(String activeaddress) {
		this.activeaddress = activeaddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getOriusrno() {
		return oriusrno;
	}
	public void setOriusrno(String oriusrno) {
		this.oriusrno = oriusrno;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPartnerno() {
		return partnerno;
	}
	public void setPartnerno(String partnerno) {
		this.partnerno = partnerno;
	}
	
	
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}	
}