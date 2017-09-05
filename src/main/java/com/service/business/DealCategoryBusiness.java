package com.service.business;

import com.cache.DealCacheOperator;
import com.common.entity.deal.DealCategory;
import com.service.api.DealCategoryService;
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

        if (resultList != null && resultList.size() > 0) {
            return resultList;
        } else {
            DealCategory dealCategory = new DealCategory();
            dealCategory.setParent_id(0L);
            resultList = (ArrayList<DealCategory>) dealCategoryService.getDealCategory(dealCategory);
            dealCacheOperator.putDealCategory(resultList, "RootDealCategory");
            return resultList;
        }

    }

    // 获取所有非根节点
    public List<DealCategory> getNotRootNode() {
        ArrayList<DealCategory> resultList = (ArrayList<DealCategory>) dealCacheOperator.getDealCategory("SubDealCategory");
        if (resultList != null && resultList.size() > 0) {
            return resultList;
        } else {
            List<DealCategory> subDealCategory = new ArrayList<DealCategory>();
            List<DealCategory> node = dealCategoryService.getDealCategory(new DealCategory());
            for (DealCategory dc : node) {
                if (dc.getParent_id() != 0) {
                    subDealCategory.add(dc);
                }
            }

            dealCacheOperator.putDealCategory(resultList, "SubDealCategory");
            return subDealCategory;
        }

    }

    // 获取根节点和一级子节点
    public List<DealCategory> getAllChildrenNode(List<DealCategory> rootNode) {
        List<DealCategory> notRootNode = this.getNotRootNode();
        for (DealCategory dc : rootNode) {
            this.getChildrenNode(dc, notRootNode);
        }
        return rootNode;
    }

    // 获取根节点和一级子节点
    public List<DealCategory> getAllChildrenNode() {
        List<DealCategory> rootNode = this.getRootNode();
        List<DealCategory> notRootNode = this.getNotRootNode();
        for (DealCategory dc : rootNode) {
            this.getChildrenNode(dc, notRootNode);
        }
        return rootNode;
    }

    // 获取单一节点的子节点
    private void getChildrenNode(DealCategory node, List<DealCategory> notRootNode) {
        List<DealCategory> children = new ArrayList<>();
        node.setChildren(children);
        for (DealCategory cdc : notRootNode) {
            if (node.getId().equals(cdc.getParent_id())) {
                node.getChildren().add(cdc);
                this.getChildrenNode(cdc, notRootNode);
            }
        }
    }

    public List<DealCategory> getChildrenNodeSecond(DealCategory node, List<DealCategory> notRootNode){
        List<DealCategory> children = new ArrayList<>();
        for (DealCategory cdc : notRootNode) {
            if (node.getId().equals(cdc.getParent_id())) {
                children.add(cdc);
                this.getChildrenNode(cdc, notRootNode);
            }
        }
        return children;
    }

    // 根据UrlName获取相应的分类数据
    public DealCategory getByUrlName(String urlname) {
        DealCategory dealCategory = new DealCategory();
        dealCategory.setUrl_name(urlname);
        // 根据UrlName查询
        List<DealCategory> dealCategories = dealCategoryService.getDealCategory(dealCategory);
        if (dealCategories == null || dealCategories.size() == 0) {
            throw new RuntimeException("DealCateGory by urlname not found!");
        }
        // 获取子节点
        DealCategory resultDealCategory = dealCategories.get(0);
        this.getChildrenNode(resultDealCategory, this.getNotRootNode());
        return resultDealCategory;
    }

    // 获取某一节点及子分类的ID
    public List<Long> selectIdList(DealCategory dealCategory) {
        this.getChildrenNode(dealCategory, this.getNotRootNode());
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(dealCategory.getId());
        for (DealCategory dc : dealCategory.getChildren()){
            idList.add(dc.getId());
        }
        return idList;
    }
}
