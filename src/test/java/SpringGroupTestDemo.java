import com.common.entity.DealCategory;
import com.groupon.api.DealCategoryService;
import com.groupon.business.DealCategoryBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class SpringGroupTestDemo {

	@Autowired
	private DealCategoryService dealCategoryService;

	@Autowired
	private DealCategoryBusiness dealCategoryBusiness;

	@Test
	public void testDealCategoryService() {
		DealCategory dealCategory = new DealCategory();
		List<DealCategory> dealCategoryList = dealCategoryService.getDealCategory(dealCategory);
		System.out.println(dealCategoryList);
	}

	@Test
	public void testDealCategoryBussiness() {
		List<DealCategory> rootNode = dealCategoryBusiness.getRootNode();
		List<DealCategory> notRootNode = dealCategoryBusiness.getNotRootNode();
		for (DealCategory dc : rootNode) {
			dc = dealCategoryBusiness.getAllChildrenNode(dc, notRootNode);
		}
		for(DealCategory dc : rootNode){
			System.out.println("分类名称："+dc.getName());
			System.out.println("子分类：");
			for (DealCategory cdc : dc.getChildren()){

				System.out.println(cdc);
			}
		}
	}


}


