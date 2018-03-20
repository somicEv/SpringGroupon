package com.dao;


import com.common.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendDao {

    List<Recommend> getRecommendList();



}
