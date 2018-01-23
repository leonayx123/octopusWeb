package com.sdyc.octopus.utils;

import java.util.List;

public class DataTablesPagination {

	
	/**
	 * 每页条数
	 */
	private int length;
	
	/**
	 *开始数 
	 */
	private int start;
	
	/**
	 *数据总数 
	 */
	private int iTotalRecords;
	
	/**
	 * 
	 */
	private int iTotalDisplayRecords;
	
	/**
	 * 数据
	 */
	private List<?> data;
	
	/**
	 * 
	 */
	private String sEcho;
	
	/**
	 * 查询参数
	 */
	private String sSearch;
	/**
	 * 查询成功
	 */
	private boolean success=true;
	



	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
