package com.dao;

import com.common.entity.deal.Deal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DealDao {

	/**
	 * 查询首页商品
	 * @param deal
	 * @return
	 */
	List<Deal> getDealsForIndex(Deal deal);

	/**
	 * 查询总数量
	 * @param params
	 * @return
	 */
	Long countDealCategory(Map<String,Object> params);

	/**
	 * 查询某一分类下所有的数据
	 * @param params
	 * @return
	 */
	List<Deal> selectDealsOfCategories(Map<String,Object> params);

	/**
	 * 根据Id列表查询商品信息
	 * @param idList Id列表
	 * @return
	 */
	List<Deal> selectDealList(Map<String,Object> params);

	/**
	 * 根据SkuId查询商品
	 * @param params
	 * @return
	 */
	Deal getDealBySkuId(Map<String,Object> params);


}
