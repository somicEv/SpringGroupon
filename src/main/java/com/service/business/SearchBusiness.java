package com.service.business;

import com.common.constant.GlobalConstant;
import com.common.vo.SearchDTO;
import com.dao.SearchDao;
import com.util.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchBusiness {

    @Autowired
    SearchDao searchDao;

    public PagingResult<SearchDTO> getSearchListResult(String keyName, Integer page) {
        Map<String, Object> params = new HashMap<>();
        params.put("keyName", keyName);
        // 查询当前关键字下结果总数
        Integer total = searchDao.countSearchResult(params);
        // 分页查询当前关键字内容
        params.put("start", (page - 1) * GlobalConstant.PAGE_SIZE);
        params.put("pageSize", GlobalConstant.PAGE_SIZE);
        List<SearchDTO> searchResultList = searchDao.getSearchResultList(params);
        if (searchResultList.size() < 0 || searchResultList == null) {
            return new PagingResult<>(total, new ArrayList<SearchDTO>(), page, GlobalConstant.PAGE_SIZE);
        }
        return new PagingResult<>(total, searchResultList, page, GlobalConstant.PAGE_SIZE);
    }

    public SearchDTO getResultByKeyName(String keyName) {
        SearchDTO resultByKeyName = searchDao.getResultByKeyName(keyName);
        if (resultByKeyName == null) {
            return new SearchDTO();
        }
        return resultByKeyName;
    }

}
