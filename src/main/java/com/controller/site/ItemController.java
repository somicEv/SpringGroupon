package com.controller.site;

import com.common.entity.deal.Deal;
import com.controller.common.FrontendBaseController;
import com.service.business.DealBusiness;
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
        // 查询商品详细信息

        model.addAttribute("deal",deal);
        return "/deal/detail";
    }

}
