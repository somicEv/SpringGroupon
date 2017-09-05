package business;

import com.common.entity.deal.DealCategory;
import com.service.business.DealCategoryBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestDealCateBusiness {

    @Autowired
    DealCategoryBusiness dealCategoryBusiness;

    @Test
    public void testSelectIdList(){
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(1L);
        List<Long> list = dealCategoryBusiness.selectIdList(dealCategory);
        System.out.println(list.toString());
    }

    @Test
    public void testGetChildrenNodeSecond(){
        DealCategory dealCategory = new DealCategory();
        dealCategory.setId(1L);
        List<DealCategory> notRootNode = dealCategoryBusiness.getNotRootNode();
        List<DealCategory> childrenNodeSecond = dealCategoryBusiness.getChildrenNodeSecond(dealCategory, notRootNode);
        System.out.println(notRootNode);
        System.out.println(childrenNodeSecond);
    }

    @Test
    public void testGetByUrlName(){
        DealCategory dealCategory = dealCategoryBusiness.getByUrlName("jiadian");
        System.out.println(dealCategory);
    }
}
