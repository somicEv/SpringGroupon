package com.dao;

import com.common.vo.SearchDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SearchDao {

    List<SearchDTO> getSearchResultList(Map<String, Object> params);

    Integer countSearchResult(Map<String, Object> params);

    SearchDTO getResultByKeyName(String keyName);
}
