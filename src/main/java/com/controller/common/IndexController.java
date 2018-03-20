package com.controller.common;

import com.common.entity.NewArrival;
import com.common.entity.deal.DealCategory;
import com.common.vo.IndexCategoryDealDTO;
import com.common.vo.RecommendDTO;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
import com.service.business.RecommendBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private DealCategoryBusiness dealCategoryBusiness;

    @Autowired
    private DealBusiness dealBusiness;

    @Autowired
    private RecommendBusiness recommendBusiness;

    private Logger log = LoggerFactory.getLogger(RecommendBusiness.class);

    /**
     * 首页显示
     *
     * @param model
     * @return
     *
     * ps:没有根据城市显示商品
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        // 获取根分类和一级分类
        /*ArrayList<DealCategory> firstNode = (ArrayList<DealCategory>) dealCategoryBusiness.getAllChildrenNode();
        model.addAttribute("categories", firstNode);*/
        // 获取根节点
        List<IndexCategoryDealDTO> rootNode = dealBusiness.createIndexCategoryDealVo();
        for (IndexCategoryDealDTO vo : rootNode) {
            System.out.println(vo);
        }
        model.addAttribute("indexCategoryDealDTOs", rootNode);
        // 查询首页推荐位
        List<RecommendDTO> indexRecommendInfo = recommendBusiness.getIndexRecommendInfo();
        model.addAttribute("indexRecommendInfo", indexRecommendInfo);
        // 查询新到商品
        List<NewArrival> indexNewArrival = dealBusiness.getIndexNewArrival();
        model.addAttribute("newArrivalList", indexNewArrival);
        return "index";
    }
}
