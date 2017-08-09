package com.common.entity;

/**
 * 商品对应描述
 */
public class DealDetail {

	private Integer id;

	private Long dealId;

	private String dealDetail; // 商品详细描述信息

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public String getDealDetail() {
		return dealDetail;
	}

	public void setDealDetail(String dealDetail) {
		this.dealDetail = dealDetail;
	}
}
