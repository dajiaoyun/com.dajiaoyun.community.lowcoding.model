package com.dajiaoyun.community.lowcoding.model;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class Page {
	private List<TableObject> records;
	
	private JSONArray jSONRecords;
	
	private String totalPage;
	private String totalCount;
	private String currentPage;
	private String pageSize;
	public int startRecord = 0;
	public int endRecord = 0;

	
	public List<TableObject> getRecords() {
		return records;
	}

	public void setRecords(List<TableObject> records) {
		this.records = records;
	}
	
	public void setJSONRecords(JSONArray records) {
		this.jSONRecords = records;
	}
	
	public JSONArray getJSONRecords() {
		return this.jSONRecords;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;

		totalPage = String.valueOf(Integer.parseInt(totalCount) % Integer.parseInt(pageSize) == 0 ? Integer.parseInt(totalCount) / Integer.parseInt(pageSize) : (Integer.parseInt(totalCount)
				/ Integer.parseInt(pageSize) + 1));
		// 防止超出最末页（浏览途中数据被删除的情况）
		// if ( pageNo > totalPage && totalPage!=0){
		// pageNo = totalPage;
		// }
		startRecord = (Integer.parseInt(currentPage) - 1) * Integer.parseInt(pageSize) + 1;
		endRecord = Integer.parseInt(currentPage) * Integer.parseInt(pageSize) + 1;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

}