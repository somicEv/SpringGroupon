package com.groupon.dealcategory.business;

import com.common.entity.DealCategory;
import com.groupon.dealcategory.api.DealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealCategoryBusiness {

	@Autowired
	private DealCategoryService dealCategoryService;

	// 获取根节点
	public List<DealCategory> getRootNode() {
		DealCategory dealCategory = new DealCategory();
		dealCategory.setParent_id(0);
		return dealCategoryService.getDealCategory(dealCategory);
	}

	// 获取所有非根节点
	public List<DealCategory> getNotRootNode() {
		List<DealCategory> node = dealCategoryService.getDealCategory(new DealCategory());
		List<DealCategory> children = new ArrayList<DealCategory>();
		for (DealCategory dc : node) {
			if (dc.getParent_id() != 0) {
				children.add(dc);
			}
		}
		return children;
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

	//
}
