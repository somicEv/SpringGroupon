package com.service.business;

import com.common.vo.NewspaperDTO;
import com.dao.NewsPaperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewspaperBusiness {

    @Autowired
    NewsPaperDao newsPaperDao;

    /**
     * 查询报刊列表
     * @return
     */
    public List<NewspaperDTO> getNewspaperList() {
        List<NewspaperDTO> resultList = newsPaperDao.getList();
        if (resultList == null) {
            return new ArrayList<>();
        }
        return resultList;
    }
}
