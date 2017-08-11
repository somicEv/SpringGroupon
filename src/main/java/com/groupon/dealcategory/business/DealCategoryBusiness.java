package com.groupon.dealcategory.business;

import com.cache.DealCacheOperator;
import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.groupon.dealcategory.api.DealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealCategoryBusiness {

	@Autowired
	private DealCategoryService dealCategoryService;

	@Autowired
	private DealCacheOperator dealCacheOperator;

	// 获取根节点
	public List<DealCategory> getRootNode() {

		ArrayList<DealCategory> resultList = (ArrayList<DealCategory>) dealCacheOperator.getDealCategory("RootDealCategory");

		if (resultList != null && resultList.size() > 0){
			return resultList;
		}
		else{
			DealCategory dealCategory = new DealCategory();
			dealCategory.setParent_id(0);
			resultList = (ArrayList<DealCategory>)dealCategoryService.getDealCategory(dealCategory);
			dealCacheOperator.putDealCategory(resultList,"RootDealCategory");
			return resultList;
		}

	}

	// 获取所有非根节点
	public List<DealCategory> getNotRootNode() {
		ArrayList<DealCategory> resultList = (ArrayList<DealCategory>) dealCacheOperator.getDealCategory("SubDealCategory");
		if (resultList != null && resultList.size() > 0){
			return resultList;
		}else {
			List<DealCategory> subDealCategory = new ArrayList<DealCategory>();
			List<DealCategory> node = dealCategoryService.getDealCategory(new DealCategory());
			for (DealCategory dc : node) {
				if (dc.getParent_id() != 0) {
					subDealCategory.add(dc);
				}
			}
			dealCacheOperator.putDealCategory(resultList,"SubDealCategory");
			return subDealCategory;
		}

	}

	// 获取根节点和一级子节点
	public List<DealCategory> getAllChildrenNode(List<DealCategory> rootNode) {
		List<DealCategory> notRootNode = this.getNotRootNode();
		for (DealCategory dc : rootNode) {
			this.getChildrenNode(dc,notRootNode);
		}
		return rootNode;
	}

	// 获取根节点和一级子节点
	public List<DealCategory> getAllChildrenNode(){
		List<DealCategory> rootNode = this.getRootNode();
		List<DealCategory> notRootNode = this.getNotRootNode();
		for (DealCategory dc : rootNode) {
			this.getChildrenNode(dc,notRootNode);
		}
		return rootNode;
	}

	// 获取单一节点的子节点
	private void getChildrenNode(DealCategory node, List<DealCategory> notRootNode) {
		List<DealCategory> children = new ArrayList<DealCategory>();
		node.setChildren(children);
		for (DealCategory cdc : notRootNode) {
			if (node.getId().equals(cdc.getParent_id())) {
				node.getChildren().add(cdc);
				this.getChildrenNode(cdc, notRootNode);
			}
		}
	}


}
