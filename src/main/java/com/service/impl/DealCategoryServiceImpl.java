package com.service.impl;


import com.common.entity.deal.DealCategory;
import com.dao.DealCategoryDao;
import com.service.api.DealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealCategoryServiceImpl implements DealCategoryService {

	@Autowired
	private DealCategoryDao dealCategoryDao;

	// 获取节点
	public List<DealCategory> getDealCategory(DealCategory dealCategory) {
		List<DealCategory> dealCategoryList = dealCategoryDao.getDealCategoryList(dealCategory);
		return dealCategoryList;
	}
}
