package com.dao;

import com.common.entity.Newspaper;
import com.common.vo.NewspaperDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsPaperDao {

    List<NewspaperDTO> getList();

}
