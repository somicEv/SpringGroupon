package com.controller.site;

import com.common.entity.Favorite;
import com.common.entity.StartRemind;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.controller.common.FrontendBaseController;
import com.service.business.DealBusiness;
import com.service.business.FavoriteBusiness;
import com.service.business.StartRemindBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/home")
@Slf4j
public class HomeController extends FrontendBaseController {

    @Autowired
    private DealBusiness dealBusiness;

    @Autowired
    private FavoriteBusiness favoriteBusiness;

    @Autowired
    private StartRemindBusiness startRemindBusiness;

    /**
     * 加入收藏
     * @param skuId
     * @param request
     * @return
     */
    @RequestMapping(value = "/favorite/{skuId}")
    @ResponseBody
    public String favorite(@PathVariable Long skuId, HttpServletRequest request) {
        // 根据skuId查询商品
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        // 查询当前用户
        WebUser webUser = getCurrentUser(request);
        // 封装favorite对象
        Favorite favorite = new Favorite();
        favorite.setDealId(deal.getId());
        favorite.setDealSkuId(deal.getSkuId());
        favorite.setUserId(webUser.getUserId());
        // 检查数据库中是否存在相同的数据
        boolean result = favoriteBusiness.checkExsite(favorite);
        if (result) {
            // 如果存在
            return "2";
        }
        favorite.setCreateTime(new Date());
        favorite.setUpdateTime(new Date());
        // 存入数据库
        Integer saveResult = favoriteBusiness.saveResult(favorite);
        if (saveResult != 1) {
            // 不存在或查询结果过多
            return "0";
        }
        return "1";
    }

    @RequestMapping(value = "/remind/{skuId}")
    @ResponseBody
    public String remind(@PathVariable Long skuId,HttpServletRequest request){
        // 构造StartRemind对象
        StartRemind startRemind = new StartRemind();
        // 查询当前用户
        WebUser webUser = getCurrentUser(request);
        startRemind.setUserId(webUser.getUserId());
        // 根据skuId查询商品
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        startRemind.setDealId(deal.getId());
        startRemind.setDealSkuId(deal.getSkuId());
        startRemind.setDealTitle(deal.getDealTitle());
        startRemind.setCreateTime(new Date());
        startRemind.setStartTime(new Date());
        startRemind.setUpdateTime(new Date());
        Integer saveResult = startRemindBusiness.save(startRemind);
        log.info("查询的结果为："+saveResult);
        if (saveResult == 0){
            return "0";
        }
        return "1";
    }
}
