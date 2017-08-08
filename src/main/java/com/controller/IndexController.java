package com.controller;

import com.common.entity.DealCategory;
import com.groupon.business.DealCategoryBusiness;
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

	/**
	 * 首页显示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		// 获取根节点
		List<DealCategory> rootNode = dealCategoryBusiness.getRootNode();
		model.addAttribute("indexCategoryDealDTOs", rootNode);
		// 获取根分类的一级分类
		List<DealCategory> notRootNode = dealCategoryBusiness.getNotRootNode();
		List<DealCategory> firstNode = new ArrayList<DealCategory>();
		for (DealCategory dc : rootNode){
			firstNode.add(dealCategoryBusiness.getAllChildrenNode(dc,notRootNode));
		}
		model.addAttribute("categories",firstNode);
		return "index";
	}

}
