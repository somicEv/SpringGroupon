package com.service.impl;

import com.common.entity.deal.Deal;
import com.dao.DealDao;
import com.service.api.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealDao dealDao;

    @Override
    public List<Deal> getDeal(Deal deal) {
        return dealDao.getDealsForIndex(deal);
    }

    @Override
    public Long countDealCategory(List<Long> idList, Integer publishStatus, Date nowTime, Integer areaId) {
        Map<String, Object> params = new HashMap<>();
        params.put("categoryIdList", idList);
        params.put("publishStatus", publishStatus);
        params.put("nowTime", nowTime);
        params.put("areaId", areaId);
        return dealDao.countDealCategory(params);
    }

    @Override
    public List<Deal> selectDealsOfCategories(List<Long> idList, Integer publishStatus, Date nowTime, Integer areaId, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("categoryIdList", idList);
        params.put("publishStatus", publishStatus);
        params.put("nowTime", nowTime);
        params.put("areaId", areaId);
        // 根据page和pageSize计算起始和结尾
        params.put("begin", (page - 1) * pageSize);
        params.put("pageSize",pageSize);
        return dealDao.selectDealsOfCategories(params);
    }

    @Override
    public Deal getDealBySkuId(Map<String, Object> params) {
       return dealDao.getDealBySkuId(params);
    }

    @Override
    public List<Deal> selectDealList(Map<String,Object> params) {
        return dealDao.selectDealList(params);
    }
}
