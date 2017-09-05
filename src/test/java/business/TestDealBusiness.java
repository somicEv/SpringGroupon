package business;

import com.common.entity.deal.Deal;
import com.common.entity.deal.DealCategory;
import com.service.business.DealBusiness;
import com.service.business.DealCategoryBusiness;
import com.util.PagingResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestDealBusiness {

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;


    @Test
    public void testGetDealsOfDealCate(){
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(1L);
        PagingResult<Deal> dealsOfDealCates = dealBusiness.getDealsOfDealCates(dealCategory, 367, 3, 1, 3);
        System.out.println("当前页数：  "+dealsOfDealCates.getPage());
        System.out.println("每页显示个数   "+dealsOfDealCates.getPageSize());
        System.out.println("总记录数：   "+dealsOfDealCates.getTotal());
        System.out.println("每页显示的数据：  ");
        for (Deal deal : dealsOfDealCates.getRows()){
            System.out.println(deal.toString());
        }
    }

}
