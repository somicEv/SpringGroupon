package com.controller.site;

import com.common.constant.DealConstant;
import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.common.entity.deal.DealDetail;
import com.common.vo.CommendDTO;
import com.common.vo.RecommendDTO;
import com.controller.common.FrontendBaseController;
import com.service.business.CommendBusiness;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
import com.service.business.RecommendBusiness;
import com.util.DealUtil;
import com.util.PagingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Slf4j
public class DealController extends FrontendBaseController {

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    CommendBusiness commendBusiness;

    @Autowired
    RecommendBusiness recommendBusiness;


    @RequestMapping(value = "/category/{url_name}", method = RequestMethod.GET)
    public String cateGoryDetail(@PathVariable String url_name,
                                 Model model) {
        return listDealsOfDealCateGory(url_name, 1, model);
    }

    @RequestMapping(value = "/category/{url_name}/{page}", method = RequestMethod.GET)
    public String listDealsOfDealCateGory(@PathVariable String url_name,
                                          @PathVariable Integer page, Model model) {
        try {
            // 向页面添加分类信息
            DealCategory dealCategory = dealCategoryBusiness.getByUrlName(url_name);
            model.addAttribute("dealCategory", dealCategory);
            // 显示分页商品
            PagingResult<Deal> pagingDealList = dealBusiness.getDealsOfDealCates(dealCategory,
                    367, DealConstant.DEAL_PUBLISH_STATUS_PUBLISH, page, 6);
            model.addAttribute("pagingDealList", pagingDealList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/deal/category";
    }

    @RequestMapping(value = "/item/{skuId}", method = RequestMethod.GET)
    public String dealDetail(@PathVariable Long skuId, Model model, HttpServletResponse response) {
        // 判断是否为合法的skuId
        if (!DealUtil.isValidSkuId(skuId)) {
            return generateError404Page(response);
        }
        // 根据skuId查询商品信息
        Deal deal = dealBusiness.getDealBySkuId(skuId);
        log.info("查询到的Deal---" + deal.toString());
        if (deal == null) {
            // 没有此商品
            return generateError404Page(response);
        }
        model.addAttribute("deal", deal);
        DealDetail dealDetail = dealBusiness.getDealDetailBySkuId(skuId);
        model.addAttribute("detail", dealDetail);
        // 查询商品的分类名称
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(deal.getCategoryId().longValue());
        DealCategory oneDealCategory = dealCategoryBusiness.getOneDealCategory(dealCategory);
        if (oneDealCategory == null) {
            // 没有查询到此分类
            return generateError404Page(response);
        }
        model.addAttribute("dealCategory", oneDealCategory);
        // 查询当前商品评论
        CommendDTO commendDTO = commendBusiness.getCommendList(skuId);
        model.addAttribute("commendList", commendDTO);
        // 查询首页推荐位
        List<RecommendDTO> indexRecommendInfo = recommendBusiness.getIndexRecommendInfo();
        model.addAttribute("indexRecommendInfo", indexRecommendInfo);
        return "/deal/detail";
    }

}
