package com.service.api;


import com.common.entity.deal.DealCategory;

import java.util.List;

public interface DealCategoryService {

	// 查询所有数据
	List<DealCategory> getDealCategory(DealCategory dealCategory);
}
