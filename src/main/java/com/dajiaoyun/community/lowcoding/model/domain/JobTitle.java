package com.dajiaoyun.community.lowcoding.model.domain;

public class JobTitle {
	//行政职位�?
	private String title;
	public static String Manager="10";
	public static String Director="20";
	public static String VP="30";
	public static String FinanceVP="35";
	public static String CEO="80";
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public JobTitle(){
		
	}
}
