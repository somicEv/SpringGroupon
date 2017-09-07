package com.helper;

import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.dao.DealCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealCategoryHelper extends BaseHelper{

    @Autowired
    private DealCategoryDao dealCategoryDao;

    public String getDealCategoryNameForDealDetail(Deal deal){
        Integer categoryId = deal.getCategoryId();
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(categoryId.longValue());
        List<DealCategory> categoryList = dealCategoryDao.getDealCategoryList(dealCategory);
        DealCategory result = categoryList.get(0);
        return result.getName();
    }

}
