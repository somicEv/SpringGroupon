package com.service.impl;

import com.common.entity.Cart;
import com.dao.CartDao;
import com.service.api.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public Integer saveDealCart(Cart cart) {
        try {
            return cartDao.saveDealCart(cart);
        }catch (Exception e){
            log.error("插入数据库失败",e);
            return 0;
        }
    }

    @Override
    public Integer updateDealCart(Cart cart) {
        try{
            return cartDao.updateDealCount(cart);
        }catch (Exception e){
            log.error("更新数据库失败",e);
            return 0;
        }
    }

    @Override
    public Cart selectDealCart(Cart cart) {
        return cartDao.selectDealCart(cart);
    }

    @Override
    public List<Cart> selectDealCartList(Cart cart){
        return cartDao.selectDealCartList(cart);
    }

    @Override
    public List<Cart> selectDealCartByIdList(List<Long> idList) {
        return cartDao.selectDealCartByIdList(idList);
    }
}
