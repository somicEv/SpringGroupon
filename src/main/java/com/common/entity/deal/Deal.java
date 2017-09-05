package com.common.entity.deal;


import lombok.Data;

import java.util.Date;

/**
 * Deal即一个单品
 */
@Data
public class Deal extends PublicDeal{


	private Long areaId; // 地区ID

	private String areaName; // 地区

	private Long skuId; // skuID

	private Integer dealClass; // 是否虚拟商品

	private Long merchantId; // 商家ID

	private Integer merchantSku; // 商家SKU 编号

	private String dealTitle; // 商品标题

	private Integer dealPrice; // 商品价格

	private Integer merchantPrice; // 进货价

	private Integer marketPrice; // 市场价

	private Integer settlementPriceMax; // 最大可接受结算价格

	private Integer settlementPrice; // 结算价

	private Integer discount; // 折扣

	private Integer bonusPoints; // 积分

	private Integer dealType; // 商品类型

	private Long imageId; // 对应商品图片

	private String imageGenPath; // 对应商品图片路径

	private Integer dealLevel; // 商品优先级

	private Integer maxPurchaseCount; // 最大购买数量

	private Integer publishStatus; // 发布状态

	private Integer inventoryAmount; // 商品库存数量

	private Integer vendibilityAmount; // 商品可售数量

	private Integer oosStatus; // 是否售罄标识

	private Date startTime; // 商品销售开始时间

	private Date endTime; // 商品销售结束时间

	private Date publishTime; // 商品上架时间

	private String merchantCode; // 商品唯一编码

	private Date createTime; // 商品创建时间

	private Date updateTime; // 商品更新时间

	private DealDetail dealDetail; // 商品对应描述

	private Boolean downShelf; // 是否下架的标识

	private Integer categoryId; // 商品类别ID

	private Long rootId; // 商品根分类



	@Override
	public String toString() {
		return "Deal{" +
				"id=" + super.getId()  +
				", areaId=" + areaId +
				", areaName='" + areaName + '\'' +
				", skuId=" + skuId +
				", dealClass=" + dealClass +
				", merchantId=" + merchantId +
				", merchantSku=" + merchantSku +
				", dealTitle='" + dealTitle + '\'' +
				", dealPrice=" + dealPrice +
				", merchantPrice=" + merchantPrice +
				", marketPrice=" + marketPrice +
				", settlementPriceMax=" + settlementPriceMax +
				", settlementPrice=" + settlementPrice +
				", discount=" + discount +
				", bonusPoints=" + bonusPoints +
				", dealType=" + dealType +
				", imageId=" + imageId +
				", imageGenPath='" + imageGenPath + '\'' +
				", dealLevel=" + dealLevel +
				", maxPurchaseCount=" + maxPurchaseCount +
				", publishStatus=" + publishStatus +
				", inventoryAmount=" + inventoryAmount +
				", vendibilityAmount=" + vendibilityAmount +
				", oosStatus=" + oosStatus +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", publishTime=" + publishTime +
				", merchantCode='" + merchantCode + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", dealDetail=" + dealDetail +
				", downShelf=" + downShelf +
				", categoryId=" + categoryId +
				", rootId=" + rootId +
				'}';
	}
}