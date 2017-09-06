package com.controller.site;

import com.common.entity.Favorite;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.controller.common.FrontendBaseController;
import com.service.api.FavoriteService;
import com.service.business.DealBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends FrontendBaseController{

    @Autowired
    private DealBusiness dealBusiness;

    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(value = "/favorite/{skuId}")
    public String favorite(@PathVariable Long skuId, HttpServletRequest request){
        // 根据skuId查询商品是否存在
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        // 查询当前用户
        WebUser webUser = getCurrentUser(request);
        // 封装favorite对象
        Favorite favorite = new Favorite();
        favorite.setDealId(deal.getId());
        favorite.setDealSkuId(deal.getSkuId());
        favorite.setUserId(webUser.getUserId());
        favorite.setCreateTime(new Date());
        favorite.setUpdateTime(new Date());
        // 存入数据库
        favoriteService.save(favorite);
        return "1";
    }

}
