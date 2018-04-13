package com.common.entity.deal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品对应描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DealDetail extends PublicDeal {

	private Long skuId;

	private String dealDetail; // 商品详细描述信息


}
