package com.groupon.dealcategory.api;


import com.common.entity.deal.DealCategory;

import java.util.List;

public interface DealCategoryService {

	List<DealCategory> getDealCategory(DealCategory dealCategory);

}
