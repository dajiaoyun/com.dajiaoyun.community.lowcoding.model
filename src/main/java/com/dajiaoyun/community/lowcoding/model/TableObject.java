package com.dajiaoyun.community.lowcoding.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class TableObject extends DBConstant implements Cloneable,Serializable{
	private String catalog;
	
	private String tableName;
	private String primaryKey;
	private String primaryValue;
	private String primaryType;
	private String parentPrimaryKey;//主子表关系时。父表primaryKey是什么
	
	private List<FieldObject> fields;
	private List<FieldObject> queryFields;
	private String queryfield;
	private HashMap<String,FieldObject> fieldObjects;
	private TableObject[] children;
	private List<TableObject> l_children;
	private HashMap<String,TableObject> tchildren;
	private String[] compoundPrimaryKeys;
	private String dBtype="MYSQL"; //Default
	private boolean autoGenerate;  //主键系统自动生成
	private boolean dbAutoGenerate; //主键数据库自动生成
	private String prefix;
	private boolean isTree;
	private boolean isSimpletable;
	private List<TableObject> multiple_children; 
	private TableObject[] linkTable;
	private String linkkey;
	private String[] childrennames;
	private List<String> sqls;
	private boolean nullupdate;
	private boolean istenant;
	private boolean generatesql;
	private boolean isSetDefaultValue;
	public long recordcount = 0; //
	public long totalpage = 0; //
	
	public TableObject(){
		fields=new ArrayList<FieldObject>();
		l_children=new ArrayList<TableObject>();
		multiple_children=new ArrayList<TableObject>();
		fieldObjects=new HashMap<String,FieldObject>() ;
		tchildren=new HashMap<String,TableObject>() ;
		nullupdate=true;
		istenant=true;
		generatesql=true;
		dbAutoGenerate=true;
		isSetDefaultValue=true;
//		String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
//		String tenant = FileUtil.readValue(path + "db.properties", "tenant");
//		if(tenant!=null&&tenant.equals("0")){
//			istenant=false;//不是SaaS版本
//		}
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public boolean isDbAutoGenerate() {
		return dbAutoGenerate;
	}

	public void setDbAutoGenerate(boolean dbAutoGenerate) {
		this.dbAutoGenerate = dbAutoGenerate;
		if(dbAutoGenerate){
			this.autoGenerate=true;
		}
	}
	public String[] getChildrennames() {
		return childrennames;
	}

	public void setChildrennames(String[] childrennames) {
		this.childrennames = childrennames;
	}
	public void setChildrennames(String childrenname) {
		this.childrennames = childrenname.split(",");
	}
	public String getLinkkey() {
		return linkkey;
	}
	public void setLinkkey(String linkkey) {
		this.linkkey = linkkey;
	}

	public TableObject[] getLinkTable() {
		return linkTable;
	}
	public void setLinkTable(TableObject[] linkTable,String linkkey) {
		this.linkTable = linkTable;
		this.linkkey=linkkey;
	}

	public String getParentPrimaryKey() {
		return parentPrimaryKey;
	}
	public void setParentPrimaryKey(String parentPrimaryKey) {
		this.parentPrimaryKey = parentPrimaryKey;
	}
	
	public boolean isSimpletable() {
		return isSimpletable;
	}
	public void setSimpletable(boolean isSimpletable) {
		this.isSimpletable = isSimpletable;
	}
	public boolean isTree() {
		return isTree;
	}
	public void setTree(boolean isTree) {
		this.isTree = isTree;
	}
	public String getPrefix() {
		if(prefix==null){
			prefix="";
		}
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public boolean isAutoGenerate() {
		return autoGenerate;
	}
	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
		if(primaryKey!=null){
			FieldObject fo=getFieldObject(primaryKey);
			if(fo==null){
				this.setAttribute(primaryKey, primaryValue);
				fo=getFieldObject(primaryKey);
			}
			fo.setAutogeneratePK(autoGenerate);
		}
	}
	public String getDBtype() {
		return dBtype;
	}
	public void setDBtype(String btype) {
		dBtype = btype;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String name) {
		this.tableName = name;
	}
	public List<FieldObject> getFields() {
		return fields;
	}
	public void setFields(List<FieldObject> fields) {
		this.fields = fields;
		fieldObjects=new HashMap<String,FieldObject>() ;
		for(int i=0;i<fields.size();i++){
			fieldObjects.put(fields.get(i).getKey().toLowerCase(),fields.get(i));
		}
	}
	public void addFields(List<FieldObject> fos) {
		if(fields==null){
			fields=new ArrayList<FieldObject>();
		}
		List<FieldObject> added=new ArrayList<FieldObject>();
		for(FieldObject fo:fos){
			boolean isExist=false;
			for(FieldObject fo2:fields){
				String key=fo2.getKey();
				if(fo.getKey().equals(key)){
					isExist=true;
					break;
				}
			}
			if(!isExist){
				added.add(fo);
			}
		}
		fields.addAll(added);
		if(fieldObjects==null){
			fieldObjects=new HashMap<String,FieldObject>() ;
		}		
		for(int i=0;i<fields.size();i++){
			fieldObjects.put(fields.get(i).getKey().toLowerCase(),fields.get(i));
		}
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		if(primaryKey!=null) {
			primaryKey=primaryKey.toLowerCase();
			this.primaryKey = primaryKey;
			FieldObject fo=getFieldObject(primaryKey);
			if(fo==null){
				this.setAttribute(primaryKey,primaryValue);
				fo=getFieldObject(primaryKey);
			}
			if(primaryType!=null){
				fo.setType(primaryType);
			}
			fo.setPrimaryKey(true);
		}
	}
	public String getPrimaryValue() {
		return primaryValue;
	}
	public void setPrimaryValue(String primaryValue) {
		this.primaryValue = primaryValue;
		//TODO 设置primaryValue 覆盖原值也有问题，如果PK不是pk_id这类，就有问题了
//		if(primaryKey!=null){
//			FieldObject fo=getFieldObject(primaryKey);
//			if(fo==null){
//				this.setAttribute(primaryKey,primaryValue);
//				fo=getFieldObject(primaryKey);
//			}
//			fo.setValue(primaryValue);
//		}
	}
	
	public String getAttribute(String attr){
		attr=attr.toLowerCase();
		String val=null;
		if(fieldObjects.get(attr)!=null){
			val=fieldObjects.get(attr).getValue();
		}
		if(isSetDefaultValue&&val==null){
			val="";
		}
		return val;
	}
	
//	public String getAttribute(int i){
//		String val=null;
//		if(fields.get(i)!=null){
//			val=fields.get(i).getValue();
//		}
//		return val;
//	}
	
	public String getFieldType(String fieldName){
		fieldName=fieldName.toLowerCase();
		String val=null;
		if(fieldObjects.get(fieldName)!=null){
			val=fieldObjects.get(fieldName).getType();
		}
		return val;
	}
	
	public void setAttribute(String attr,String val){
		attr=attr.toLowerCase();
		FieldObject fo=fieldObjects.get(attr);
		if(fo!=null){
			fo.setValue(val);
		}else{
			fo=new FieldObject();
			fo.setKey(attr);
			fo.setValue(val);
			fo.setType(STRING);//TODO Default
			
			fieldObjects.put(attr, fo);
			fields.add(fo);
		}
		fo.setGeneratesql(true);
	}
	public void setAttribute(String attr,String val,String type){
		attr=attr.toLowerCase();
		FieldObject fo=fieldObjects.get(attr);
		if(fo!=null){
			fo.setValue(val);
			fo.setType(type);
		}else{
			fo=new FieldObject();
			fo.setKey(attr);
			fo.setValue(val);
			fo.setType(type);
			
			fieldObjects.put(attr, fo);
			fields.add(fo);
			fo.setGeneratesql(true);
		}
	}
	public void removeAttribute(String attr){
		FieldObject fo=fieldObjects.get(attr);
		if(fo!=null){
			fieldObjects.remove(fo.getKey());
			fields.remove(fo);
		}
	}
	public void removeAttribute(String key,String value){
		FieldObject fo=null;
		for(int i=0;i<fieldObjects.size();i++){
			if(fieldObjects.get(key).getValue().equals(value)){
				fo=fieldObjects.get(key);
				break;
			}
		}
		if(fo!=null){
			fields.remove(fo);
			fieldObjects=new HashMap<String,FieldObject>() ;
			for(int i=0;i<fields.size();i++){
				fieldObjects.put(fields.get(i).getKey(), fields.get(i));
			}
		}
	}
	public HashMap<String, FieldObject> getFieldObjects() {
		return fieldObjects;
	}
	public void setFieldObjects(HashMap<String, FieldObject> fieldObjects) {
		this.fieldObjects = fieldObjects;
	}
	public FieldObject getFieldObject(String attr) {
		attr=attr.toLowerCase();
		FieldObject ret=null;
		if(fieldObjects.get(attr)!=null){
			ret=fieldObjects.get(attr);
		}
		return ret;
	}
	public TableObject[] getChildren() {
		return children;
	}
	public void setChildren(TableObject[] children) {
		this.children = children;
		l_children=new ArrayList<TableObject>();
		if(children!=null){
			for(int i=0;i<children.length;i++){
				l_children.add(children[i]);
			}
		}		
	}
	
	public void setChildren(List<TableObject> children) {
		l_children=new ArrayList<TableObject>();
		if(children!=null){
			for(int i=0;i<children.size();i++){
				l_children.add(children.get(i));
			}
		}
		this.children=new TableObject[l_children.size()];
		l_children.toArray(this.children);
	}
	
	public TableObject[] getChildren(String childName) {
		TableObject childs[]=new TableObject[0];
		List<TableObject> ret=new ArrayList<TableObject>();
		if(this.getAttribute(childName)!=null){
			try{
				ObjectMapper mapper = new ObjectMapper();
				JsonNode rootNode = mapper.readValue(this.getAttribute(childName), JsonNode.class);
				Iterator<JsonNode> json_childs = rootNode.iterator();
				int ii=1;
				if(json_childs.hasNext()){
					while (json_childs.hasNext()) {
						JsonNode json_child = (JsonNode) json_childs.next();
						Iterator<Entry<String, JsonNode>> json_fields = json_child.getFields();
						TableObject vo_child=new TableObject();
						vo_child.setTableName(childName);
						vo_child.setAttribute("childname", childName);
						while (json_fields.hasNext()) {
							Entry<String, JsonNode> json_field = json_fields.next();
							if (json_field.getKey().toString().startsWith(String.valueOf(ii))) {
								JsonNode goodNode = mapper.readValue(json_field.getValue().toString(), JsonNode.class);
								Iterator<JsonNode> json_children = goodNode.iterator();
								while (json_children.hasNext()) {
									JsonNode json_table = (JsonNode) json_children.next();
									Iterator<Entry<String, JsonNode>> _fields = json_table.getFields();
									//打印出每个商品对应的属性,也可以  good.get("NAME").asText() 类似直接取商品名称出来
									while (_fields.hasNext()) {
										Entry<String, JsonNode> _field = _fields.next();
										if(_field.getValue()!=null){
											String val=_field.getValue().toString();
											val=val.replace("'", "");
											vo_child.setAttribute(_field.getKey().toLowerCase(),val);
										}else{
											String val="";
											vo_child.setAttribute(_field.getKey().toLowerCase(),val);
										}
									} 
									
								}
							}
							
						}
						ii++;
						ret.add(vo_child);
					}
				}else{
					Iterator<Entry<String, JsonNode>> json_fields = rootNode.getFields();
					System.out.println(json_fields.toString());
				}
				
			}catch(Exception e){
				
			}
		}else{
			if(children!=null&&children.length>0){
				for(int i=0;i<children.length;i++){
					if(children[i].getTableName().equalsIgnoreCase(childName)){
						ret.add(children[i]);
					}
				}
			}
		}
		childs=ret.toArray(childs);
		return childs;
	}
	public void addChildren(TableObject[] vo) {
		if(vo==null||vo.length==0){
			return;
		}
		for(int i=0;i<vo.length;i++){
			l_children.add(vo[i]);
		}
		this.children=new TableObject[l_children.size()];
		l_children.toArray(this.children);
	}
	
	public void addChildren(List<TableObject> children) {
		if(children==null||children.size()==0){
			return;
		}
		for(TableObject child:children){
			l_children.add(child);
		}
		this.children=new TableObject[l_children.size()];
		l_children.toArray(this.children);
	}
	
	public void addChildren(TableObject vo) {
		l_children.add(vo);
		this.children=new TableObject[l_children.size()];
		l_children.toArray(this.children);
	}
	
	public void removeChildren(String key,String val) {
		if(children!=null){
			for(TableObject vo:children){
				if(vo.getAttribute(key)!=null&&vo.getAttribute(key).equals(val)){
					l_children.remove(vo);
				}
			}
			this.children=new TableObject[l_children.size()];
			l_children.toArray(this.children);
		}		
	}
	public void removeChildren(String val) {
		if(primaryKey!=null&&children!=null){
			for(TableObject vo:children){
				if(vo.getAttribute(primaryKey)!=null&&vo.getAttribute(primaryKey).equals(val)){
					l_children.remove(vo);
				}
			}
			this.children=new TableObject[l_children.size()];
			l_children.toArray(this.children);
		}		
	}
	public void removeAllChildren() {
		this.children=new TableObject[0];
		l_children=new ArrayList<TableObject>();
		children=null;
	}
	public void removeChildrenByName(String val) {
		if(children!=null){
			for(TableObject vo:children){
				if(vo.getTableName().equals(val)){
					l_children.remove(vo);
				}
			}
			this.children=new TableObject[l_children.size()];
			l_children.toArray(this.children);
		}		
	}
	public String getPrimaryType() {
		return primaryType;
	}
	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
		if(primaryKey!=null){
			FieldObject fo=getFieldObject(primaryKey);
			if(fo==null){
				this.setAttribute(primaryKey, "");
				fo=getFieldObject(primaryKey);
			}
			fo.setType(primaryType);
		}
	}
	
	public String[] getCompoundPrimaryKeys() {
		return compoundPrimaryKeys;
	}
	public void setCompoundPrimaryKeys(String[] compoundPrimaryKeys) {
		this.compoundPrimaryKeys = compoundPrimaryKeys;
	}

	public List<TableObject> getMultiple_children() {
		return multiple_children;
	}
	public void addMultiple_children(TableObject multiple_children) {
		this.multiple_children.add(multiple_children);
	}
	
	
	public List<String> getSqls() {
		return sqls;
	}

	public void setSqls(List<String> sql) {
		this.sqls = sql;
	}

	public boolean isNullupdate() {
		return nullupdate;
	}

	public void setNullupdate(boolean nullupdate) {
		this.nullupdate = nullupdate;
	}

	public boolean istenant() {
		return istenant;
	}

	public void settenant(boolean istenant) {
		this.istenant = istenant;
	}
	
	public void addTchildren(String key,TableObject vo) {
		tchildren.put(key, vo);
	}
	public TableObject getTchildren(String key) {
		TableObject child=tchildren.get(key);
		return child;
	}
	public TableObject[] getTchildrens() {
		TableObject[] childs=new TableObject[tchildren.values().size()];
		return tchildren.values().toArray(childs);
	}
	public void setGeneratesql(boolean generatesql) {
		this.generatesql = generatesql;
		for(int i=0;i<fields.size();i++){
			FieldObject fo=fields.get(i);
			fo.setGeneratesql(generatesql);
		}		
	}

	public boolean isSetDefaultValue() {
		return isSetDefaultValue;
	}

	public void setSetDefaultValue(boolean isSetDefaultValue) {
		this.isSetDefaultValue = isSetDefaultValue;
	}
	
	public  String buildUpdateSQL(TableObject tableObject){
		tableObject.setAutoGenerate(false);
		if(!tableObject.isNullupdate()){//null sql
			for(FieldObject fo:tableObject.getFields()){
				if(fo.getValue()==null){
					fo.setGeneratesql(false);
				}
			}
		}
		
		String sql="update "+tableObject.getTableName()+" set ";
		for(int i=0;i<tableObject.getFields().size();i++){
			FieldObject field=tableObject.getFields().get(i);
			if((field.getValue()!=null||(field.getValue()==null&&tableObject.isNullupdate()))&&field.isGeneratesql()){  
				sql=sql+field.getKey()+"=";
				if(field.getType().equals(TableObject.LONG)||field.getType().equals(TableObject.INT)
						||field.getType().equals(TableObject.DOUBLE)||field.getType().equals(TableObject.FLOAT)
						||field.getType().equals(TableObject.NUMBER)){
					if(field.getValue()!=null){
						sql=sql+field.getValue()+",";
					}else{
						sql=sql+"0"+",";
					}
					
				}else if(field.getType().equals(TableObject.STRING)){
					if(field.getValue()!=null){
						String val=field.getValue();
						val=replaceSpecialString2(val);
						sql=sql+"'"+val+"',";
					}else{
						sql=sql+"null,";
					}
					
				}else if(field.getType().equals(TableObject.DATE)){
					boolean validdate=false;
					if(field.getValue()!=null&&!field.getValue().equals("")){
						String firstletter=field.getValue().substring(0,1);
						if(firstletter.equals("1")||firstletter.equals("2")||firstletter.equals("3")
							||firstletter.equals("4")||firstletter.equals("5")){
							validdate=false;
						}else{
							validdate=true;
						}
					}
					if(!validdate){
						if(tableObject.getDBtype().equalsIgnoreCase(TableObject.ORACLE)){
							if(field.getValue()!=null&&!field.getValue().equals("")){
								if(field.getValue().length()>19){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"to_date('"+dateval+"','YYYY-MM-DD'),";
								}else if(field.getValue().length()==19){
//									String dateval=field.getValue().substring(0,10);
									String dateval=field.getValue();
									if(dateval.indexOf("/")>0) {
										sql=sql+"to_date('"+dateval+"','yyyy/MM/dd HH24:mi:ss'),";
									}else {
										sql=sql+"to_date('"+dateval+"','yyyy-MM-dd HH24:mi:ss'),";
									}
									
								}else if(field.getValue().length()<19&&field.getValue().length()>=10){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"to_date('"+dateval+"','yyyy-MM-dd'),";
								}else{
									sql=sql+"null,";
								}
								
							}else{
								sql=sql+"null,";
							}
							
						}else{
							if(field.getValue()!=null&&!field.getValue().equals("")){
								if(field.getValue().length()>19){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"'"+dateval+"',";
								}else if(field.getValue().length()==19){
//									String dateval=field.getValue().substring(0,10);
									String dateval=field.getValue();
									sql=sql+"'"+dateval+"',";
								}else if(field.getValue().length()<19&&field.getValue().length()>=10){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"'"+dateval+"',";
								}else{
									sql=sql+"null,";
								}
							}else{
								sql=sql+"null,";
							}
						}
					}else{
						sql=sql+"null,";
					}
					
				}else{
					if(field.getValue()!=null){
						String val=field.getValue();
						val=replaceSpecialString2(val);
						sql=sql+"'"+val+"',";
					}else{
						sql=sql+"null,";
					}
				}
			}			
		}
		boolean okUpdate=false;
		if(tableObject.getPrimaryValue()==null||tableObject.getPrimaryValue().equals("")) {
			tableObject.setPrimaryValue(tableObject.getAttribute(tableObject.getPrimaryKey()));
		}
		String primaryVlaue=tableObject.getAttribute("primaryvalue");
		if(primaryVlaue==null||primaryVlaue.equals("")) {
			primaryVlaue=tableObject.getPrimaryValue();
		}
		
		if(primaryVlaue!=null&primaryVlaue.trim().length()>0){
			sql=sql.substring(0, sql.length()-1)+" where "+tableObject.getPrimaryKey()+"=";
			if(tableObject.getPrimaryType().equals(TableObject.STRING)){
				sql=sql+"'"+primaryVlaue+"'";
			}else{
				sql=sql+primaryVlaue;
			}
			okUpdate=true;
		}else{
			sql=sql.substring(0, sql.length()-1)+" where 1=1 ";
			
			if(tableObject.getCompoundPrimaryKeys()!=null&&tableObject.getCompoundPrimaryKeys().length>0){
				okUpdate=true;
				for(String key:tableObject.getCompoundPrimaryKeys()){ //TODO String 类型？
					FieldObject fo=tableObject.getFieldObject(key);
					if(tableObject.getAttribute(key)!=null&&!tableObject.getAttribute(key).equals("")) {
						if(fo!=null){
							if(fo.getType().equals(TableObject.STRING)||fo.getType().equals(TableObject.DATE)){
								sql=sql+" and "+key+" = '"+tableObject.getAttribute(key)+"' ";
							}else{
								sql=sql+" and "+key+" = "+tableObject.getAttribute(key);
							}
						}else{
							sql=sql+" and "+key+" = "+tableObject.getAttribute(key);
						}
					}
					
					
				}
			}else{
				if(tableObject.getQueryFields()!=null&&tableObject.getQueryFields().size()>0){
					okUpdate=true;
					List<FieldObject> keys=tableObject.getQueryFields();
					for(FieldObject fo:keys){
						String value=this.getAttribute(fo.getKey());
						if(value!=null&&!value.equals("")) {
							if(fo.getType()!=null){
								if(fo.getType().equals(TableObject.STRING)||fo.getType().equals(TableObject.DATE)){
									sql=sql+" and "+fo.getKey()+"='"+value+"' ";
								}else if(fo.getType().equals(TableObject.INT)||fo.getType().equals(TableObject.INTEGER)
										||fo.getType().equals(TableObject.NUMBER)||fo.getType().equals(TableObject.LONG)
										||fo.getType().equals(TableObject.LNUMBERIC)){
									sql=sql+" and "+fo.getKey()+"="+value;
								}else{
									sql=sql+" and "+fo.getKey()+"='"+fo.getValue()+"' ";
								}
							}else{
								sql=sql+" and "+fo.getKey()+"='"+value+"' ";
							}
						}
						
					}
				}
			}
		}
		
		
		if(tableObject.istenant()){
			sql=sql+" and tenantno='"+tableObject.getAttribute("tenantno")+"'";
		}
		if(!okUpdate) {
			sql=null;
		}
		return sql;
	}
	
	public String buildInsertSQLs(){ 
		if(!isNullupdate()){ 
			for(FieldObject fo:getFields()){
				if(fo.getValue()==null){
					fo.setGeneratesql(false);
				}
			}
		}
		String sql="insert into "+getTableName()+" (";
		for(int i=0;i<getFields().size();i++){
			FieldObject field=getFields().get(i);
			if(field.isGeneratesql()) {
				if (!getDBtype().equalsIgnoreCase(TableObject.ORACLE)) {//mysql/Sql server/DB2
					if(field.isAutogeneratePK()&&field.isPrimaryKey()){
						if(getPrimaryType().equals(TableObject.LONG)
								||getPrimaryType().equals(TableObject.INTEGER)
								||getPrimaryType().equals(TableObject.INT)){
							if(isDbAutoGenerate()){
								
							}else{
								sql=sql+field.getKey()+",";
							}
						}else{
							sql=sql+field.getKey()+",";
						}
					}else if(field.isGeneratesql()){
						sql=sql+field.getKey()+",";
					}				
				}else {//Oracle
					sql=sql+field.getKey()+",";
				}
			}
		}
		sql=sql.substring(0,sql.length()-1)+") values(";
		for(int i=0;i<getFields().size();i++){
			FieldObject field=getFields().get(i);
			boolean isAutoincrementID=false;
			if(field.isGeneratesql()) {
				if (!getDBtype().equalsIgnoreCase(TableObject.ORACLE)) {//mysql/Sql server/DB2
					if(field.isAutogeneratePK()&&field.isPrimaryKey()){
						if(getPrimaryType().equals(TableObject.LONG)||getPrimaryType().equals(TableObject.INTEGER)
								||getPrimaryType().equals(TableObject.INT)){
							//mysql/Sql server/DB2
							isAutoincrementID=false;
							if(isDbAutoGenerate()){
								isAutoincrementID=true;
							}
						}
					}				
				}else{
					isAutoincrementID=false;
					if(isDbAutoGenerate()){
						isAutoincrementID=true;
					}
				}
				if(!isAutoincrementID&&field.isGeneratesql()){
					if(field.getType().equalsIgnoreCase(TableObject.LONG)||field.getType().equalsIgnoreCase(TableObject.INT)
							||field.getType().equalsIgnoreCase(TableObject.DOUBLE)||field.getType().equalsIgnoreCase(TableObject.FLOAT)
							||field.getType().equalsIgnoreCase(TableObject.NUMBER)||field.getType().equalsIgnoreCase(TableObject.INTEGER)){
						if(field.getValue()!=null&&!field.getValue().equals("")){
							sql=sql+field.getValue()+",";
						}else{
							sql=sql+"0"+",";
						}
						
					}else if(field.getType().equalsIgnoreCase(TableObject.STRING)){
						if(field.getValue()!=null){
							String val=field.getValue();
						//	val=replaceSpecialString2(val);
							sql=sql+"'"+val+"',";
						}else{
							sql=sql+"null,";
						}
						
					}else if(field.getType().equalsIgnoreCase(TableObject.DATE)){
						if(getDBtype().equals(TableObject.ORACLE)){
							if(field.getValue()!=null&&!field.getValue().equals("")){
								if(field.getValue().length()>19){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"to_date('"+dateval+"','YYYY-MM-DD'),";
								}else if(field.getValue().length()==19){
//									String dateval=field.getValue().substring(0,10);
									String dateval=field.getValue();
									if(dateval.indexOf("/")>0) {
										sql=sql+"to_date('"+dateval+"','yyyy/MM/dd HH24:mi:ss'),";
									}else {
										sql=sql+"to_date('"+dateval+"','yyyy-MM-dd HH24:mi:ss'),";
									}
								}else if(field.getValue().length()<19&&field.getValue().length()>=10){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"to_date('"+dateval+"','yyyy-MM-dd'),";
								}else{
									sql=sql+"null,";
								}
								
							}else{
								sql=sql+"null,";
							}
							
						}else{
							if(field.getValue()!=null&&!field.getValue().equals("")){
								if(field.getValue().length()>19){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"'"+dateval+"',";
								}else if(field.getValue().length()==19){
//									String dateval=field.getValue().substring(0,10);
									String dateval=field.getValue();
									sql=sql+"'"+dateval+"',";
								}else if(field.getValue().length()<19&&field.getValue().length()>=10){
									String dateval=field.getValue().substring(0,10);
									sql=sql+"'"+dateval+"',";
								}else{
									sql=sql+"null,";
								}
							}else{
								sql=sql+"null,";
							}
						}
					}else{
						if(field.getValue()!=null){
							String val=field.getValue();
							val=replaceSpecialString2(val);
							sql=sql+"'"+val+"',";
						}else{
							sql=sql+"null,";
						}
					}
				}else{
					if(getDBtype().equalsIgnoreCase(TableObject.ORACLE)){
						sql=sql+"SEQ_" + getTableName() + ".nextval,";
					}
				}
			}
			
		}
		sql=sql.substring(0, sql.length()-1)+")";
		return sql;
	}
	
	public String buildInsertJSONValues(){ 
		return null;
	}
	
	public List<FieldObject> getQueryFields() {
		return queryFields;
	}
	public void setQueryFields(List<FieldObject> queryFields) {
		this.queryFields = queryFields;
	}
	
	public void setQueryfield(String _queryfield) {
		this.queryfield = _queryfield;
		String[] queryfields=queryfield.split(",");
		this.queryFields=new ArrayList<FieldObject>();
		for(String key:queryfields){
			key=key.trim();
			FieldObject fo=new FieldObject();
			fo.setKey(key);
			fo.setValue(this.getAttribute(key));
			queryFields.add(fo);
		}
	}
	private static String replaceSpecialString(String s){
		s=s.replaceAll("<tr>", "");
		s=s.replaceAll("<TR>", "");
		s=s.replaceAll("<TD>", "");
		s=s.replaceAll("<td>", "");
		s=s.replaceAll("<Table>", "");
		s=s.replaceAll("<TABLE>", "");
		//s=s.replaceAll("'", "鈥�);
		return s;
	}
	private static String replaceSpecialString2(String s){
		s=replaceSpecialString(s);
		s=s.replaceAll("'", "“");
		s=s.replaceAll("'", "‘");
		return s;
	}
	
	public static String getPK(){
		String ret=String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		ret=ret+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return ret;
	}
	
	/**
	 * 返回JSON数据给前台
	 * 前台使用 var dataObj=eval("("+data.message+")");
			alert(dataObj.goodsno);
			就可以解析JSON格式数据了
	 */
	public String toString(){
		String json="{";
		for(FieldObject fo:fields){
			String val=fo.getValue();
			String key=fo.getKey();
			if(val!=null&&val.length()>=1){
				if(!val.substring(0,1).equals("'")){
					val="'"+val+"'";
				}
				json=json+key+":"+val+",";
			}else{
				json=json+key+":'"+"',";
			}
		}
		json=json.substring(0,json.length()-1)+"}";
		return json;
	}
	
	public String toJSON(){
		String json="{";
		for(FieldObject fo:fields){
			String val=fo.getValue();
			String key=fo.getKey();
			if(val!=null&&val.length()>=1){
				if(!val.substring(0,1).equals("'")){
					val="'"+val+"'";
				}
			}else{
				val="'"+"'";
			}
			if(key!=null&&key.length()>=1){
				if(!key.substring(0,1).equals("'")){
					key="'"+key+"'";
				}
			}
			json=json+key+":"+val+",";
		}
		if(this.getChildren()!=null&&getChildren().length>0){
			String tablename=this.getChildren()[0].getTableName();
			json=json+"'"+tablename+"':[";
//			json=json+tablename+":[";
			for(TableObject child:this.getChildren()){
				json=json+"{";
				for(FieldObject c_fo:child.getFields()){
					String val=c_fo.getValue();
					if(val!=null&&val.length()>=1){
						if(!val.substring(0,1).equals("'")){
							val="'"+val+"'";
						}
					}else{
						val="'"+"'";
					}
					String key=c_fo.getKey();
					if(key!=null&&key.length()>=1){
						if(!key.substring(0,1).equals("'")){
							key="'"+key+"'";
						}
					}
					json=json+key+":"+val+",";
				}
				json=json.substring(0,json.length()-1)+"},";
			}
			json=json.substring(0,json.length()-1)+"],";
		}
		
		json=json.substring(0,json.length()-1)+"}";
		return json;
	}
	
	
	//TODO
	public void toTableObject(JSONObject obj){
		
	}
	public JSONObject toJSONObject(){
		JSONObject ret=new JSONObject(true);
		for(FieldObject fo:fields){
			String val=fo.getValue();
			String key=fo.getKey();
			ret.put(key, val);
		}
		if(this.getChildren()!=null&&getChildren().length>0){
			JSONArray children=new JSONArray();
			for(TableObject child:this.getChildren()){
				String tableName="childrenTablename"; //TODO
				JSONObject obj=new JSONObject();
				for(FieldObject c_fo:child.getFields()){
					String val=c_fo.getValue();
					String key=c_fo.getKey();
					obj.put(key, val);
				}
				children.add(obj);
				ret.put(tableName, children);
			}
		}
		return ret;
	}
	public String toJSON2(){
		String json="{'tablename':"+this.tableName+",";
		for(FieldObject fo:fields){
			String val=fo.getValue();
			if(val!=null&&val.length()>1){
				if(!val.substring(0,1).equals("'")){
					val="'"+val+"'";
				}
			}
			json=json+fo.getKey()+":"+val+",";
		}
		if(this.getChildren()!=null&&getChildren().length>0){
			String tablename=this.getChildren()[0].getTableName();
			json=json+"'"+tablename+"':[";
			for(TableObject child:this.getChildren()){
				json=json+"{";
				for(FieldObject c_fo:child.getFields()){
					String val=c_fo.getValue();
					if(val!=null&&val.length()>=1){
						if(!val.substring(0,1).equals("'")){
							val="'"+val+"'";
						}
					}
					json=json+c_fo.getKey()+":"+val+",";
				}
				json=json.substring(0,json.length()-1)+"},";
			}
			json=json.substring(0,json.length()-1)+"],";
		}
		
		json=json.substring(0,json.length()-1)+"}";
		return json;
	}
}
