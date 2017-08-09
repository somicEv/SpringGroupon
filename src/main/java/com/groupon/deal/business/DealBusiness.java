package com.groupon.deal.business;

import com.common.constant.DealConstant;
import com.common.entity.Deal;
import com.common.entity.DealCategory;
import com.common.vo.IndexCategoryDealVo;
import com.groupon.deal.api.DealService;
import com.groupon.dealcategory.business.DealCategoryBusiness;
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
	public List<IndexCategoryDealVo> createIndexCategoryDealVo(){
		List<IndexCategoryDealVo> voList = new ArrayList<IndexCategoryDealVo>();
		for (DealCategory dc : dealCategoryBusiness.getRootNode()){
			Map<String, List<Deal>> dealForIndex = this.getDealForIndex(dc.getId(), new Date(), 367L, DealConstant.DEAL_PUBLISH_STATUS_PUBLISH);
			// 创建所需实体类
			IndexCategoryDealVo indexCategoryDealVo = new IndexCategoryDealVo(dc,dealForIndex.get("firstGroup"),dealForIndex.get("secondGroup"));
			voList.add(indexCategoryDealVo);
		}
		return voList;
	}

	private Map<String ,List<Deal>> getDealForIndex(Integer rootId,Date date,Long areaId,Integer publicstatus){
		Map<String , List<Deal>> resultMap = new HashMap<String, List<Deal>>();
		Deal deal = new Deal();
		deal.setRootId(rootId);
		deal.setEndTime(date);
		deal.setAreaId(areaId);
		deal.setPublishStatus(publicstatus);
		List<Deal> dealList = dealService.getDeal(deal);
		System.out.println("查询结果长度为："+dealList.size());
		if(dealList.size() >= 8){
			List<Deal> firstGroup = dealList.subList(0, 4);
			resultMap.put("firstGroup",firstGroup);
			List<Deal> secondGroup = dealList.subList(4, 8);
			resultMap.put("secondGroup",secondGroup);
		}else if(dealList.size() > 4 && dealList.size() <= 8){
			List<Deal> firstGroup = dealList.subList(0, 4);
			resultMap.put("firstGroup",firstGroup);
			List<Deal> secondGroup = dealList.subList(5, dealList.size());
			resultMap.put("secondGroup",secondGroup);
		}else if(dealList.size() > 0 && dealList.size() <= 4){
			List<Deal> firstGroup = dealList.subList(0, 4);
			resultMap.put("firstGroup",firstGroup);
			resultMap.put("secondGroup",new ArrayList<Deal>());
		}else{
			resultMap.put("firstGroup",new ArrayList<Deal>());
			resultMap.put("secondGroup",new ArrayList<Deal>());
		}
		return resultMap;
	}

}
