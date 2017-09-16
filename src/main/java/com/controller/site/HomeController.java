package com.controller.site;

import com.common.constant.CartConstant;
import com.common.constant.GlobalConstant;
import com.common.entity.Favorite;
import com.common.entity.Params;
import com.common.entity.StartRemind;
import com.common.entity.area.Address;
import com.common.entity.deal.Deal;
import com.common.entity.user.UserBasicInfo;
import com.common.entity.user.WebUser;
import com.common.vo.FavoriteDTO;
import com.common.vo.QueryMessage;
import com.controller.common.FrontendBaseController;
import com.service.business.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/home")
@Slf4j
public class HomeController extends FrontendBaseController {

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    FavoriteBusiness favoriteBusiness;

    @Autowired
    StartRemindBusiness startRemindBusiness;

    @Autowired
    UserBusiness userBusiness;

    @Autowired
    AreaBusiness areaBusiness;

    /**
     * 展示用户收藏
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/favorite")
    public String showFavorite(Model model, HttpServletRequest request) {
        WebUser webUser = this.getCurrentUser(request);
        List<Favorite> favoriteList = favoriteBusiness.selectFavoriteList(webUser);
        if (favoriteList == null || favoriteList.size() == 0) {
            model.addAttribute("favorites", null);
            return "/user/favorite";
        }
        List<Long> idList = favoriteBusiness.selectDealIdsFromFavoriteList(favoriteList);
        List<Deal> dealList = dealBusiness.selectDealList(idList);
        List<FavoriteDTO> favoriteDtoList = favoriteBusiness.createFavoriteDtoList(favoriteList, dealList);
        model.addAttribute("favorites", favoriteDtoList);
        return "/user/favorite";
    }

    /**
     * 加入收藏
     *
     * @param skuId
     * @param request
     * @return
     */
    @RequestMapping(value = "/favorite/{skuId}")
    @ResponseBody
    public QueryMessage addToFavorite(@PathVariable Long skuId, HttpServletRequest request) {
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
        boolean result = favoriteBusiness.checkExist(favorite);
        if (!result) {
            // 如果存在
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR_FIND_SOME);
        }
        favorite.setCreateTime(new Date());
        favorite.setUpdateTime(new Date());
        // 存入数据库
        Integer saveResult = favoriteBusiness.saveResult(favorite);
        if (saveResult != 1) {
            // 存入失败
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }

    /**
     * 添加开团提醒
     *
     * @param skuId
     * @param request
     * @return
     */
    @RequestMapping(value = "/remind/{skuId}")
    @ResponseBody
    public QueryMessage addToRemind(@PathVariable Long skuId, HttpServletRequest request) {
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
        // 查询是否已经存在
        boolean result = startRemindBusiness.checkExist(startRemind);
        if (!result) {
            // 如果存在
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR_FIND_SOME);
        }
        startRemind.setCreateTime(new Date());
        startRemind.setStartTime(new Date());
        startRemind.setUpdateTime(new Date());
        Integer saveResult = startRemindBusiness.save(startRemind);
        log.info("查询的结果为：" + saveResult);
        if (saveResult != 1) {
            // 存入失败
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }

    /**
     * 展示用户基本信息
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = {"/index", "/info"})
    public String showUserInfo(Model model, HttpServletRequest request) {
        // 查询当前用户
        WebUser webUser = this.getCurrentUser(request);
        QueryMessage<UserBasicInfo> queryMessage = userBusiness.selectUserBasicInfo(webUser);
        if (!"200".equals(queryMessage.getQueryCode())) {
            model.addAttribute("info", null);
            return "/user/info";
        }
        model.addAttribute("info", queryMessage.getQueryObject());
        return "/user/info";
    }

    /**
     * 添加用户基本信息
     *
     * @return
     */
    @RequestMapping(value = "/info/add")
    @ResponseBody
    public QueryMessage<UserBasicInfo> addUserInfo(UserBasicInfo userBasicInfo) {
        // TODO 页面转成表单提交
        System.out.println("ni");
        return null;
    }

    /**
     * 更新用户基本信息
     * @return
     */
    @RequestMapping(value = "/info/update", method = RequestMethod.POST)
    @ResponseBody
    public QueryMessage updateUserInfo(UserBasicInfo[] params) {
        // TODO 页面转成表单提交
        return null;
    }

    /**
     * 跳转到新建地址的页面
     *
     * @return 页面URL
     */
    @RequestMapping(value = "/address/new")
    public String forwardToCreateAddress() {
        return "/user/create_address";
    }

    /**
     * 保存用户新创建的收货地址
     * @param address
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/address/create", method = RequestMethod.POST)
    public String saveUserAddress(Address address, HttpServletRequest request, HttpServletResponse response) {
        WebUser webUser = this.getCurrentUser(request);
        address.setUserId(webUser.getUserId());
        address.setUpdateTime(new Date());
        address.setCreateTime(new Date());
        QueryMessage queryMessage = areaBusiness.saveUserAddress(address);
        if ("500".equals(queryMessage.getQueryCode())) {
            this.generateError500Page(response);
        }
        return "redirect:/home/address";
    }

    /**
     * 展示用户收货地址
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/address")
    public String showUserAddress(Model model, HttpServletRequest request) {
        WebUser webUser = this.getCurrentUser(request);
        List<Address> addressList = areaBusiness.selectUserAddress(webUser);
        if (addressList == null || addressList.size() == 0) {
            model.addAttribute("addresses", null);
            return "/user/address";
        }
        model.addAttribute("addresses", addressList);
        return "/user/address";
    }

    /**
     * 展示用户订单
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/order")
    public String showUserOrder(Model model, HttpServletRequest request, HttpServletResponse response) {
        // todo 展示用户订单
        return "/user/order";
    }
}
