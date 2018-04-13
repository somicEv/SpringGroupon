package com.dao;

import com.common.entity.deal.DealDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface DealDetailDao {

    DealDetail getDealDetailBySkuId(DealDetail dealDetail);

}
