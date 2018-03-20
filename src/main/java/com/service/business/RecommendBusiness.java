package com.service.business;

import com.common.entity.Recommend;
import com.common.entity.deal.Deal;
import com.common.vo.RecommendDTO;
import com.dao.RecommendDao;
import com.service.api.DealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendBusiness {

    @Autowired
    RecommendDao recommendDao;

    @Autowired
    DealService dealService;

    private Logger log = LoggerFactory.getLogger(RecommendBusiness.class);

    // 查询首页推荐位信息
    public List<RecommendDTO> getIndexRecommendInfo() {
        List<RecommendDTO> indexRecommendInfo = new ArrayList<>();
        List<Recommend> recommendList = recommendDao.getRecommendList();
        log.info("[RecommendBusiness]getIndexRecommendInfo-->recommendList{}",recommendList);
        if (recommendList.size() <= 0 || recommendList == null) {
            return indexRecommendInfo;
        }
        for (Recommend recommend : recommendList) {
            RecommendDTO recommendDTO = new RecommendDTO();
            Map<String,Object> params = new HashMap<>();
            params.put("skuId",recommend.getSkuId());
            params.put("nowTime",new Date());
            Deal deal = dealService.getDealBySkuId(params);
            if (deal == null) {
                recommendDTO.setDeal(new Deal());
            } else {
                recommendDTO.setDeal(deal);
            }
            recommendDTO.setRecommend(recommend);
            indexRecommendInfo.add(recommendDTO);
        }
        log.info("[RecommendBusiness]getIndexRecommendInfo-->indexRecommendInfo{}",indexRecommendInfo);
        return indexRecommendInfo;
    }
}
