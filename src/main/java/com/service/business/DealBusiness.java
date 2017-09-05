package com.service.business;

import com.common.constant.DealConstant;
import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.common.vo.IndexCategoryDealVo;
import com.service.api.DealService;
import com.util.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DealBusiness {

    @Autowired
    private DealService dealService;

    @Autowired
    private DealCategoryBusiness dealCategoryBusiness;

    // 构建首页显示vo
    public List<IndexCategoryDealVo> createIndexCategoryDealVo() {
        List<IndexCategoryDealVo> voList = new ArrayList<IndexCategoryDealVo>();
        for (DealCategory dc : dealCategoryBusiness.getRootNode()) {
            Map<String, List<Deal>> dealForIndex = this.getDealForIndex(dc.getId(), new Date(), 367L, DealConstant.DEAL_PUBLISH_STATUS_PUBLISH);
            // 创建所需实体类
            IndexCategoryDealVo indexCategoryDealVo = new IndexCategoryDealVo(dc, dealForIndex.get("firstGroup"), dealForIndex.get("secondGroup"));
            voList.add(indexCategoryDealVo);
        }
        return voList;
    }

    private Map<String, List<Deal>> getDealForIndex(Long rootId, Date date, Long areaId, Integer publicstatus) {
        Map<String, List<Deal>> resultMap = new HashMap<String, List<Deal>>();
        Deal deal = new Deal();
        deal.setRootId(rootId);
        deal.setEndTime(date);
        deal.setAreaId(areaId);
        deal.setPublishStatus(publicstatus);
        List<Deal> dealList = dealService.getDeal(deal);
        System.out.println("查询结果长度为：" + dealList.size());
        if (dealList.size() >= 8) {
            List<Deal> firstGroup = dealList.subList(0, 4);
            resultMap.put("firstGroup", firstGroup);
            List<Deal> secondGroup = dealList.subList(4, 8);
            resultMap.put("secondGroup", secondGroup);
        } else if (dealList.size() > 4 && dealList.size() <= 8) {
            List<Deal> firstGroup = dealList.subList(0, 4);
            resultMap.put("firstGroup", firstGroup);
            List<Deal> secondGroup = dealList.subList(5, dealList.size());
            resultMap.put("secondGroup", secondGroup);
        } else if (dealList.size() > 0 && dealList.size() <= 4) {
            List<Deal> firstGroup = dealList.subList(0, 4);
            resultMap.put("firstGroup", firstGroup);
            resultMap.put("secondGroup", new ArrayList<Deal>());
        } else {
            resultMap.put("firstGroup", new ArrayList<Deal>());
            resultMap.put("secondGroup", new ArrayList<Deal>());
        }
        return resultMap;
    }


    public PagingResult<Deal> getDealsOfDealCates(DealCategory dealCategory, Integer areaId, Integer publishStatus, Integer page, Integer pagesize) {
        // 查询当前分类及子分类的id
        List<Long> integerList = dealCategoryBusiness.selectIdList(dealCategory);
        System.out.println("查询当前分类及子分类的id  " + integerList.toString());
        // 查询当前分类下数据总数
        Long dealCount = dealService.countDealCategory(integerList, publishStatus, new Date(), areaId);
        System.out.println("查询当前分类下数据总数 " + dealCount);
        // 分页查询当前分类下数据
        List<Deal> dealList = dealService.selectDealsOfCategories(integerList, publishStatus, new Date(), areaId, page, pagesize);
        System.out.println("查询当前分类下所有数据  " + dealList);
        return new PagingResult<>(dealCount, dealList, page, pagesize);
    }

}
