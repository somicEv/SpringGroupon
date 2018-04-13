package com.service.api;

import com.common.entity.deal.Deal;
import com.common.entity.deal.DealDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface DealService {

	List<Deal> getDeal(Deal deal);

	// TODO 修改 参数--Map<String,Object> params
	Long countDealCategory(List<Long> idList, Integer publishStatus, Date nowTime, Integer areaId);

	List<Deal> selectDealsOfCategories(List<Long> idList,Integer publishStatus,Date nowTime,Integer areaId,Integer page,Integer pageSize);

	List<Deal> selectDealList(Map<String,Object> params);

	Deal getDealBySkuId(Map<String,Object> params);

    List<Deal> getNewArrivalsGoods(Map<String, Object> params);

    DealDetail getDealDetailBySkuId(DealDetail dealDetail);
}
