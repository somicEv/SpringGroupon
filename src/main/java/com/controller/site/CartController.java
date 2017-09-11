package com.controller.site;

import com.common.constant.CartConstant;
import com.common.constant.GlobalConstant;
import com.common.entity.Cart;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.common.vo.CartVo;
import com.common.vo.QueryMessage;
import com.controller.common.FrontendBaseController;
import com.service.business.CartBusiness;
import com.service.business.DealBusiness;
import com.util.DealUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Controller
public class CartController extends FrontendBaseController {

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    CartBusiness cartBusiness;

    /**
     * 显示购物车
     *
     * @param model 页面对象
     * @return
     */
    @RequestMapping(value = "/cart")
    public String cartDetail(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 确定相应的用户
            WebUser webUser = getCurrentUser(request);
            if (null != webUser) {
                Long userId = webUser.getUserId();
                // 获取该用户的购物车列表
                List<Cart> cartList = cartBusiness.selectCartByUserId(userId);
                if (cartList != null) {
                    List<CartVo> cartVoList = this.createCartVoList(cartList);
                    model.addAttribute("carts", cartVoList);
                    return "/cart/cart";
                }
            }
            return "redirect:/login";
        } catch (Exception e) {
            log.error("显示购物车页面失败----", e);
            return this.generateError404Page(response);
        }
    }

    /**
     * 购物车页面更改数量
     *
     * @param cartId    购物车ID
     * @param dealCount 商品数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cart/{cartId}/{dealCount}")
    public QueryMessage updateDealCartByCartId(@PathVariable Long cartId, @PathVariable Integer dealCount) {
        // 根据ID获取购物车对象
        List<Cart> cartList = cartBusiness.selectDealCartByCartId(cartId);
        if (cartList == null || cartList.size() == 0) {
            return new QueryMessage(GlobalConstant.QUERY_RESULT_NOTFOUND, CartConstant.ERROR);
        }
        Cart cart = cartList.get(0);
        cart.setDealCount(dealCount);
        // 更新购物车数据
        cart.setUpdateTime(new Date());
        QueryMessage queryMessage = cartBusiness.updateDealCart(cart);
        if (!"200".equals(queryMessage.getQueryCode())) {
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }

    /**
     * 添加商品到购物车
     *
     * @param skuId 商品skuId
     * @return 返回相应的状态码
     */
    @ResponseBody
    @RequestMapping(value = "/cart/default/{skuId}")
    public QueryMessage addCart(@PathVariable Long skuId, Integer params, HttpServletRequest request) {
        // 验证skuId合法性
        boolean validSkuId = DealUtil.isValidSkuId(skuId);
        if (!validSkuId) {
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        // 根据skuId查询商品信息
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        // 查询当前用户
        WebUser webUser = this.getCurrentUser(request);
        // 根据ID查询购物车对象
        QueryMessage queryMessage = this.updateExistDealCart(deal, webUser, skuId, params);
        if ("200".equals(queryMessage.getQueryCode())) {
            return queryMessage;
        } else if ("500".equals(queryMessage.getQueryCode())) {
            return queryMessage;
        } else {
            Cart dealCart = new Cart(webUser.getUserId(), deal.getId(), skuId);
            if (params == null || params < 0) {
                // 如果没有输入数量 设置默认值 避免出错
                dealCart.setDealCount(1);
                dealCart.setUpdateTime(new Date());
                return cartBusiness.saveDealCart(dealCart);
            }
            dealCart.setDealCount(params);
            dealCart.setUpdateTime(new Date());
            return cartBusiness.saveDealCart(dealCart);
        }
    }

    @RequestMapping(value = "/settlement")
    public String settlement(Integer totalPrice, String cartIds, Model model, HttpServletRequest request) {
        try {
            if (!StringUtils.isEmpty(cartIds) && totalPrice != 0 && totalPrice > 0) {
                WebUser webUser = this.getCurrentUser(request);
                List<Cart> cartList = cartBusiness.selectCartByUserId(webUser.getUserId());
                ArrayList<CartVo> cartVoList = this.createCartVoList(cartList);
                model.addAttribute("carts", cartVoList);
                model.addAttribute("totalPrice", totalPrice);
            }
        } catch (Exception e) {
            log.error("显示结算页面失败" + e);
            return "/cart/cart";
        }
        return "/cart/settlement";
    }

    /**
     * 封装cartVo列表
     *
     * @param cartList 购物车列表
     * @return
     */
    private ArrayList<CartVo> createCartVoList(List<Cart> cartList) {
        // 获取dealIdList
        List<Long> dealIds = cartBusiness.selectDealIdsByCart(cartList);
        // 根据ID列表获取相应的商品信息
        Map<String, Object> params = new HashMap<>();
        params.put("idList", dealIds);
        List<Deal> dealList = dealBusiness.selectDealList(params);
        Map<Long, Deal> resultMap = new HashMap<>();
        for (Deal deal : dealList) {
            resultMap.put(deal.getId(), deal);
        }
        ArrayList<CartVo> cartVoList = new ArrayList<>();
        for (Cart cart : cartList) {
            cartVoList.add(new CartVo(cart, resultMap.get(cart.getDealId())));
        }
        return cartVoList;
    }

    private QueryMessage updateExistDealCart(Deal deal, WebUser webUser, Long skuId, Integer dealCount) {
        Cart dealCartExist = cartBusiness.selectDealCart(webUser.getUserId(), skuId, deal.getId());
        if (dealCartExist != null) {
            if (dealCartExist.getDealCount().equals(deal.getMaxPurchaseCount())) {
                // 如果数据库中的商品数量已经达到当前商品的限购数量
                return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR_REACH_LIMIT);
            }
            // 更新购物车数据
            dealCartExist.setDealCount(dealCount);
            dealCartExist.setUpdateTime(new Date());
            QueryMessage queryMessage = cartBusiness.updateDealCart(dealCartExist);
            if ("200".equals(queryMessage.getQueryCode())) {
                return new QueryMessage(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
            }
        }
        return new QueryMessage(GlobalConstant.QUERY_RESULT_NOTFOUND, CartConstant.ERROR);
    }

}
