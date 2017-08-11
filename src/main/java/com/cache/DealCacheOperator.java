package com.cache;

import com.common.entity.deal.DealCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealCacheOperator extends CacheOperator {

	private static final Logger logger = LoggerFactory.getLogger(CacheOperator.class);

	public void putDealCategory(List<DealCategory> dealCategoryList,String key) {
		super.putEntities(key, dealCategoryList);
		logger.info("添加缓存成功");
	}

	public List<DealCategory> getDealCategory(String key) {
		List<DealCategory> dealCategoryList = super.getEntities(key, DealCategory.class);
		logger.info("获取缓存成功");
		return dealCategoryList;
	}

}
