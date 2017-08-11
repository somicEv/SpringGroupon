package com.database;


import com.common.entity.deal.DealCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealCategoryDao {

	List<DealCategory> getDealCategoryList(DealCategory dealCategory);

}
