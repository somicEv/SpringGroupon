package com.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询类
 */
public class Search implements Serializable {

	private static final long serialVersionUID = -328270505586112262L;
	
	/**
	 * 当前页码
	 */
	private int page = 1;
	
	/**
	 * 每页记录数
	 */
	private int rows = 20;
	
	/**
	 * 查询条件组
	 */
	private List<Condition> conditionList = new ArrayList<>();

	public List<Condition> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<Condition> conditionList) {
		this.conditionList = conditionList;
	}

	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
		
		if (page < 1) {
			this.page = 1;
		}
	}

	public int getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
		
		if (rows < 1) {
			this.rows = 1;
		}
	}

	/**
	 * 得到当前页第一行数据的行号
	 * @return
	 */
	public int getFirstRowNum() {
		return ((page - 1) * rows);
	}

	public boolean containsRouterCall() {
		if (null == conditionList || null == getRouterName()
				|| null == getMethods()
				|| null == getConfirmMethods() || null == getGridId()) {
			return false;
		}
		return true;
	}
	
	public String getRouterName() {
		for (Condition cond : conditionList) {
			if ("routerName".equals(cond.getName())) {
				return (String)cond.getValue();
			}
		}
		return null;
	}
	
	public String[] getMethods() {
		for (Condition cond : conditionList) {
			if ("methods".equals(cond.getName())) {
				return ((String)cond.getValue()).split(",");
			}
		}
		return null;
	}
	
	public String[] getConfirmMethods() {
		for (Condition cond : conditionList) {
			if ("confirmMethods".equals(cond.getName())) {
				return ((String)cond.getValue()).split(",");
			}
		}
		return null;
	}
	
	public String getGridId() {
		for (Condition cond : conditionList) {
			if ("gridId".equals(cond.getName())) {
				return (String)cond.getValue();
			}
		}
		return null;
	}

}
