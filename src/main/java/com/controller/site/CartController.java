package com.controller.site;

import com.common.entity.Cart;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.controller.common.FrontendBaseController;
import com.service.business.CartBusiness;
import com.service.business.DealBusiness;
import com.util.DealUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping(value = "/cart")
public class CartController extends FrontendBaseController {

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    CartBusiness cartBusiness;

    /**
     * 显示购物车
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "")
    public String cartDetail(Model model) {
        return "/cart/cart";
    }

    /**
     * 添加商品到购物车
     *
     * @param skuId 商品skuId
     * @return 返回相应的状态码
     */
    @ResponseBody
    @RequestMapping(value = "/default/{skuId}")
    public String addCart(@PathVariable Long skuId, Integer params, HttpServletRequest request) {
        Cart cart = new Cart();
        // 验证skuId合法性
        boolean validSkuId = DealUtil.isValidSkuId(skuId);
        if (!validSkuId){
            return "0";
        }
        cart.setDealSkuId(skuId);
        // 根据skuId查询商品信息
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        cart.setDealId(deal.getId());
        // 查询当前用户
        WebUser webUser = this.getCurrentUser(request);
        cart.setUserId(webUser.getUserId());
        if(params == null || params < 0){
            // 如果没有输入数量 设置默认值 避免出错
            cart.setDealCount(1);
            cart.setUpdateTime(new Date());
            return cartBusiness.saveDealCart(cart);
        }
        cart.setDealCount(params);
        cart.setUpdateTime(new Date());
        return cartBusiness.saveDealCart(cart);
    }

}
