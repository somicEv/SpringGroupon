package com.groupon.deal.impl;

import com.common.entity.Deal;
import com.database.DealDao;
import com.groupon.deal.api.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DealServiceImpl implements DealService{

	@Autowired
	private DealDao dealDao;

	public List<Deal> getDeal(Deal deal) {
		return dealDao.getDealsForIndex(deal);
	}
}