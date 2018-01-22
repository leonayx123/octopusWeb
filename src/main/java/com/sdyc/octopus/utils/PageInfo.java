package com.sdyc.octopus.utils;

public class
		PageInfo {

	
	private Integer rowPerPage=20;//每页多少条
	private Integer totalNum = 0;//数据总量
	private Integer currentPage=1;//当前页数
	
	/**
	 * 获取分页起始位置///
	 * @return
	 */
	public int getStart() {
		int start=(currentPage-1)*rowPerPage;
		if(start<0){
			return 0;
		}
		return start;
	}
	/**
	 * 获取总共的页数
	 * @return
	 */
	public int getPageNum(){
		int page= 	totalNum/rowPerPage;
		if(totalNum%rowPerPage>0){
			page++;
		}
		return page;
	}
	/**
	 * 获取结尾位置
	 * @return
	 */
	public int getEnd(){
		int end= getStart()+rowPerPage;
		
		return Math.min(end, totalNum);
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum.intValue();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
