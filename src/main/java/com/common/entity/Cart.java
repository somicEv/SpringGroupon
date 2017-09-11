package com.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 购物车
 */
@ToString
public class Cart{

    public Cart(){

    }

    public Cart(Long userId, Long dealId, Long dealSkuId) {
        this.userId = userId;
        this.dealId = dealId;
        this.dealSkuId = dealSkuId;
    }

    @Getter @Setter private Long id;

    @Getter @Setter private Long userId;

    @Getter @Setter private Long dealId;

    @Getter @Setter private Long dealSkuId;

    @Getter @Setter private Integer dealCount;

    @Getter @Setter private Date createTime;

    @Getter @Setter private Date updateTime;



}
