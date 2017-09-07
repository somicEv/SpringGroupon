package com.controller.site;

import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.controller.common.FrontendBaseController;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
import com.util.DealUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class ItemController extends FrontendBaseController {

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;

    @RequestMapping(value = "/item/{skuId}", method = RequestMethod.GET)
    public String dealDetail(@PathVariable Long skuId, Model model, HttpServletResponse response) {
        // 判断是否为合法的skuid
        if (!DealUtil.isValidSkuId(skuId)){
            return generateError404Page(response);
        }
        // 根据skuid查询商品信息
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        log.info("查询到的Deal---"+deal.toString());
        if(deal == null){
            // 没有此商品
            return generateError404Page(response);
        }
        model.addAttribute("deal",deal);
        // 查询商品的分类名称
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(deal.getCategoryId().longValue());
        DealCategory oneDealCategory = dealCategoryBusiness.getOneDealCategory(dealCategory);
        if (oneDealCategory == null){
            // 没有查询到此分类
            return generateError404Page(response);
        }
        model.addAttribute("dealCategory",oneDealCategory);
        // 查询商品详细信息
        return "/deal/detail";
    }

}
