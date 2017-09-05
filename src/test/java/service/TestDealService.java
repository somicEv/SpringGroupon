package service;

import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.service.api.DealService;
import com.service.business.DealCategoryBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestDealService {

    @Autowired
    DealService dealService;

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;

    @Test
    public void testSelectDealsOfCategories(){
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(1L);
        List<Long> idList = dealCategoryBusiness.selectIdList(dealCategory);
        List<Deal> deals = dealService.selectDealsOfCategories(idList, 3, new Date(), 367, 1, 3);
        for (Deal deal : deals){
            System.out.println(deal);
        }
    }
}
