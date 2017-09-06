package com.controller.common;

import com.common.entity.deal.DealCategory;
import com.common.vo.IndexCategoryDealVo;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
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

	/**
	 * 首页显示
	 * @param model
	 * @return
	 *
	 * ps:没有根据城市显示商品
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		// 获取根分类和一级分类
		ArrayList<DealCategory> firstNode = (ArrayList<DealCategory>) dealCategoryBusiness.getAllChildrenNode();
		model.addAttribute("categories",firstNode);
		// 获取根节点
		List<IndexCategoryDealVo> rootNode = dealBusiness.createIndexCategoryDealVo();
		for (IndexCategoryDealVo vo : rootNode){
			System.out.println(vo);
		}
		model.addAttribute("indexCategoryDealDTOs", rootNode);
		return "index";
	}

}
