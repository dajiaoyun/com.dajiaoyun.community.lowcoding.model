package com.dajiaoyun.community.lowcoding.model.domain;

import java.util.Date;

import com.dajiaoyun.community.lowcoding.model.Attribute;
import com.dajiaoyun.community.lowcoding.model.TableObject;

/**
 * 2007-8-14 @ author Xing Botao
 */
public class Tenant extends Attribute{
	public final static String defaultno = "0000000000";
	private String gatewayRoutesCode;
	private String databasecatalog;
	private String databasepassword;
	private String hasowndbconnection;//
	private String dbtype; //Oracle/Mysql/SQLServer/DB2
	private String databasename; //
	private String address;
	private String tenantname;
	private String storename;
	private String tenantno;
	private String email;
	private String fax;
	private String telephone;
	private String cellphone;	
	private Date registerdate;
	private Date servicebegindate;
	private String serviceclosedate;
	private String servicetype;//
	private String postcode;
	private String contractor;
	private int maxusernum;//
	private int allowactiveusernum;
	private int dbconnectionnum;// 
	private String serviceipaddress;// ַ
	private String databaseipaddress; // 
	private String logopath;
	private String status;
	private String usrno;
	private String passwd;
	private long tenantid;
	private String parentno;// 
	private Tenant parent;//
	private Tenant[] parents;//
	private Tenant[] children;//
	private String iseshop; //
	private String shop_score;
	private String shop_title;
	private String shop_sid;
	private String shop_cid;
	private Date shop_created;
	private int loginusernum; //
	private Long areaid;
	private String province;
	private String city;
	private String district;
	private Long cityno;
	private Long provinceno;
	private String taoappkey;
	private String taosecret;
	private String remark;
	private String sessionkey;
	private String logisticno;
	private Shop shop;
	private Shop[] shops;
	private TableObject[] warehouses; 
	
	public enum EntType {  
		Administrator("00"),Op("01"),ServiceMan("02"),Customer("03") ; 
		private String entType;
		private EntType(String type){
			this.entType=type;
		}
		public String getValue(){
			return this.entType;
		}
	} 
	
	public String getGatewayRoutesCode() {
		return gatewayRoutesCode;
	}
	public void setGatewayRoutesCode(String gatewayRoutesCode) {
		this.gatewayRoutesCode = gatewayRoutesCode;
	}
	public void addLoginUserNum(){
		loginusernum=loginusernum+1;
	}
	public void removeLoginUserNum(){
		loginusernum=loginusernum-1;
	}
	public int getLoginusernum() {
		return loginusernum;
	}

	public void setLoginusernum(int loginusernum) {
		this.loginusernum = loginusernum;
	}

	public String getIseshop() {
		return iseshop;
	}

	public void setIseshop(String iseshop) {
		this.iseshop = iseshop;
	}
	
	public int getAllowactiveusernum() {
		return allowactiveusernum;
	}

	public void setAllowactiveusernum(int allowactiveusernum) {
		this.allowactiveusernum = allowactiveusernum;
	}

	public Tenant getParent() {
		return parent;
	}

	public void setParent(Tenant parent) {
		this.parent = parent;
	}

	public Tenant[] getParents() {
		return parents;
	}

	public void setParents(Tenant[] parents) {
		this.parents = parents;
	}

	public Tenant[] getChildren() {
		return children;
	}

	public void setChildren(Tenant[] children) {
		this.children = children;
	}

	public String getParentno() {
		return parentno;
	}

	public void setParentno(String parentno) {
		this.parentno = parentno;
	}

	public String getDatabasename() {
		return databasename;
	}

	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getTenantname() {
		return tenantname;
	}

	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	public String getTenantno() {
		return tenantno;
	}

	public void setTenantno(String tenantno) {
		this.tenantno = tenantno;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsrno() {
		return usrno;
	}

	public void setUsrno(String usrno) {
		this.usrno = usrno;
	}

	public long getTenantid() {
		return tenantid;
	}

	public void setTenantid(long tenantid) {
		this.tenantid = tenantid;
	}

	public String getDatabaseipaddress() {
		if (databaseipaddress == null || databaseipaddress.equals("")) {
			if (serviceipaddress == null || serviceipaddress.equals("")) {
				serviceipaddress = "127.0.0.1";
			} else {
				databaseipaddress = serviceipaddress;
			}
		}
		return databaseipaddress;
	}

	public void setDatabaseipaddress(String databaseipaddress) {
		this.databaseipaddress = databaseipaddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}	

	public String getDatabasecatalog() {
		return databasecatalog;
	}

	public void setDatabasecatalog(String databasecatalog) {
		this.databasecatalog = databasecatalog;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getServicebegindate() {
		return servicebegindate;
	}

	public void setServicebegindate(Date servicebegindate) {
		this.servicebegindate = servicebegindate;
	}

	public String getServiceclosedate() {
		return serviceclosedate;
	}

	public void setServiceclosedate(String serviceclosedate) {
		this.serviceclosedate = serviceclosedate;
	}

	public int getMaxusernum() {
		return maxusernum;
	}

	public void setMaxusernum(int maxusernum) {
		this.maxusernum = maxusernum;
	}

	public String getServiceipaddress() {
		if(serviceipaddress==null){
			serviceipaddress="127.0.0.1";
		}
		return serviceipaddress;
	}

	public void setServiceipaddress(String serviceipaddress) {
		this.serviceipaddress = serviceipaddress;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getDatabasepassword() {
		return databasepassword;
	}

	public void setDatabasepassword(String databasepassword) {
		this.databasepassword = databasepassword;
	}

	public int getDbconnectionnum() {
		if (dbconnectionnum == 0) {
			dbconnectionnum = 3;
		}
		return dbconnectionnum;
	}

	public void setDbconnectionnum(int dbconnectionnum) {
		this.dbconnectionnum = dbconnectionnum;
	}

	public String getHasowndbconnection() {
		return hasowndbconnection;
	}

	public void setHasowndbconnection(String hasowndbconnection) {
		this.hasowndbconnection = hasowndbconnection;
	}

	public String getLogopath() {
		return logopath;
	}

	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}

	public String getShop_score() {
		return shop_score;
	}

	public void setShop_score(String shopScore) {
		shop_score = shopScore;
	}

	public String getShop_title() {
		return shop_title;
	}

	public void setShop_title(String shopTitle) {
		shop_title = shopTitle;
	}

	public String getShop_sid() {
		return shop_sid;
	}

	public void setShop_sid(String shopSid) {
		shop_sid = shopSid;
	}

	public String getShop_cid() {
		return shop_cid;
	}

	public void setShop_cid(String shopCid) {
		shop_cid = shopCid;
	}

	public Date getShop_created() {
		return shop_created;
	}

	public void setShop_created(Date shopCreated) {
		shop_created = shopCreated;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTaoappkey() {
		return taoappkey;
	}
	public void setTaoappkey(String taoappkey) {
		this.taoappkey = taoappkey;
	}
	public String getTaosecret() {
		return taosecret;
	}
	public void setTaosecret(String taosecret) {
		this.taosecret = taosecret;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
	public String getLogisticno() {
		return logisticno;
	}
	public void setLogisticno(String logisticno) {
		this.logisticno = logisticno;
	}
	public Long getCityno() {
		return cityno;
	}
	public void setCityno(Long cityno) {
		this.cityno = cityno;
	}
	public Long getProvinceno() {
		return provinceno;
	}
	public void setProvinceno(Long provinceno) {
		this.provinceno = provinceno;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Shop[] getShops() {
		return shops;
	}
	public void setShops(Shop[] shops) {
		this.shops = shops;
	}

	public TableObject[] getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(TableObject[] warehouses) {
		this.warehouses = warehouses;
	}
	
}