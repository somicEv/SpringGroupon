package com.common.entity.deal;

/**
 * 商品对应描述
 */
public class DealDetail extends PublicDeal {


	private Long dealId;

	private String dealDetail; // 商品详细描述信息


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
