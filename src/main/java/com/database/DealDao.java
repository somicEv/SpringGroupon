package com.database;

import com.common.entity.Deal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DealDao {

	// 查询首页显示商品
	List<Deal> getDealsForIndex(Deal deal);

}
