import com.common.entity.DealCategory;
import com.groupon.api.DealCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml","classpath:spring/spring-dao.xml"})
public class SpringGroupTestDemo {

	@Autowired
	private DealCategoryService dealCategoryService;

	@Test
	public void testDealCategoryService(){
		DealCategory dealCategory = new DealCategory();
		List<DealCategory> dealCategoryList = dealCategoryService.getDealCategory(dealCategory);
		System.out.println(dealCategoryList);
	}

}
