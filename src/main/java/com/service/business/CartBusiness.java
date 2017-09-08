package com.service.business;

import com.common.entity.Cart;
import com.service.api.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartBusiness {

    @Autowired
    CartService cartService;

    /**
     * 添加购物车数据到数据库
     *
     * @param cart 购物车对象
     * @return 返回相应的状态码
     */
    public String saveDealCart(Cart cart) {
        // 查询是否存在相同的数据
        boolean exist = this.checkExist(cart);
        if (exist) {
            // 存在相同的数据 更改数量
            Integer updateResult = cartService.updateDealCart(cart);
            if (updateResult != 1) {
                // 更新出错
                return "0";
            }
            return "1";
        }
        cart.setCreateTime(new Date());
        Integer result = cartService.saveDealCart(cart);
        if (result != 1) {
            // 添加出错
            return "0";
        }
        // 正常
        return "1";
    }

    /**
     * 查询是否存在相同的数据
     *
     * @param cart 购物车对象
     * @return TODO 将其余checkExist()方法修改
     */
    private boolean checkExist(Cart cart) {
        Cart dealCart = cartService.selectDealCart(cart);
        if (dealCart != null) {
            // 说明存在
            return true;
        }
        return false;
    }


}
