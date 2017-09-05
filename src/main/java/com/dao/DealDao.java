package com.dao;

import com.common.entity.deal.Deal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DealDao {

	// 查询首页显示商品
	List<Deal> getDealsForIndex(Deal deal);

	// 查询总数量
	// TODO 修改 参数--Map<String,Object> params
	Long countDealCategory(Map<String,Object> params);

	/**
	 * 查询某一分类下所有的数据
	 * @param params
	 * @return
	 */
	List<Deal> selectDealsOfCategories(Map<String,Object> params);

}
