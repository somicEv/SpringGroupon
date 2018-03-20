package com.dao;

import com.common.entity.Commend;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommendDao {
    List<Commend> getCommendList(Map<String, Object> params);
}
