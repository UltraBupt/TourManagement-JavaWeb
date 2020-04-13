package com.gs.tour.shxt.base.model;

import java.util.List;

public class PageBean {
	/**当前页数，默认从*/
	private Integer pageNow=1;
	/**总记录数*/
	private Integer totalCount;
	/**每页显示条数*/
	private Integer pageSize=4;
	/**总页数*/
	private Integer totalPages=1;
	/**结果集*/
	private List<?> data;
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
}
