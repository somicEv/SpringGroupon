package com.groupon.business;


import com.common.entity.DealCategory;
import com.database.DealCategoryDao;
import com.groupon.api.DealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealCategoryBusiness implements DealCategoryService {

	@Autowired
	private DealCategoryDao dealCategoryDao;

	public List<DealCategory> getDealCategory(DealCategory dealCategory) {
		return dealCategoryDao.getDealCategoryList(dealCategory);
	}
}
