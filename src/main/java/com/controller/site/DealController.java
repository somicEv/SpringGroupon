package com.controller.site;

import com.common.constant.DealConstant;
import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.controller.FrontendBaseController;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
import com.util.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DealController extends FrontendBaseController{

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;

    @Autowired
    DealBusiness dealBusiness;

    @RequestMapping(value = "/category/{url_name}", method = RequestMethod.GET)
    public String cateGoryDetail(@PathVariable String url_name,
                                 Model model, HttpServletRequest request) {
        return listDealsofDealCateGory(url_name,1,model,request);
    }

    @RequestMapping(value = "/category/{url_name}/{page}", method = RequestMethod.GET)
    public String listDealsofDealCateGory(@PathVariable String url_name, @PathVariable Integer page,
                                          Model model, HttpServletRequest request) {
       try{
           // 向页面添加分类信息
           DealCategory dealCategory = dealCategoryBusiness.getByUrlName(url_name);
           model.addAttribute("dealCategory",dealCategory);
           // 显示分页商品
           PagingResult<Deal> pagingDealList = dealBusiness.getDealsOfDealCates(dealCategory, 367, DealConstant.DEAL_PUBLISH_STATUS_PUBLISH, page, 3);
           model.addAttribute("pagingDealList",pagingDealList);
       }catch (Exception e){
           e.printStackTrace();
       }
       return "/deal/category";
    }

}
