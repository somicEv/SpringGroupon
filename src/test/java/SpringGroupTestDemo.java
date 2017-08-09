import com.common.entity.Deal;
import com.common.entity.DealCategory;
import com.common.vo.IndexCategoryDealVo;
import com.groupon.deal.business.DealBusiness;
import com.groupon.dealcategory.api.DealCategoryService;
import com.groupon.dealcategory.business.DealCategoryBusiness;
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

	@Autowired
	private DealBusiness dealBusiness;

	@Test
	public void testDealCategoryService() {
		DealCategory dealCategory = new DealCategory();
		List<DealCategory> dealCategoryList = dealCategoryService.getDealCategory(dealCategory);
		System.out.println(dealCategoryList);
	}

	@Test
	public void test(){
		List<DealCategory> allChildrenNode = dealCategoryBusiness.getAllChildrenNode();
		for (DealCategory dc : allChildrenNode) {
			System.out.println(dc.toString());
			List<DealCategory> children = dc.getChildren();
			for (DealCategory cdc : children){
				System.out.println(cdc.toString());
			}
		}
	}

	@Test
	public void testDealBusiness(){
		List<IndexCategoryDealVo> dealForIndex = dealBusiness.createIndexCategoryDealVo();
		for (IndexCategoryDealVo deal : dealForIndex){

			System.out.println("第一组：");
			deal.showFirst();
			System.out.println("第二组：");
			deal.showSecond();
		}
	}
}


