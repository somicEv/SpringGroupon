package com.service.business;

import com.common.entity.Commend;
import com.common.vo.CommendDTO;
import com.dao.CommendDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommendBusiness {

    private Logger log = LoggerFactory.getLogger(CommendBusiness.class);

    @Autowired
    CommendDao commendDao;

    public CommendDTO getCommendList(Long skuId) {
        Map<String, Object> params = new HashMap<>();
        params.put("skuId", skuId);
        List<Commend> commendList = commendDao.getCommendList(params);
        log.info("[CommendBusiness]getCommendList-->{}", commendList);
        CommendDTO commendDTO = new CommendDTO();
        commendDTO.setCommends(commendList);
        return commendDTO;
    }
}
