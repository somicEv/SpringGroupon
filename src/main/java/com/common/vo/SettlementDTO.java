package com.common.vo;

import com.common.entity.Cart;
import com.common.entity.deal.Deal;
import lombok.Getter;
import lombok.Setter;

/**
 * 购物车页面数据类
 */
public class SettlementDTO {

    @Getter @Setter private Cart cart;

    @Getter @Setter private Deal deal;

    @Getter @Setter private Integer subtotal;

    public SettlementDTO(Cart cart, Deal deal){
        this.cart = cart;
        this.deal = deal;
        this.subtotal = deal.getDealPrice() * cart.getDealCount();
    }

}
