import com.common.entity.area.Area;
import com.common.entity.deal.DealCategory;
import com.common.vo.IndexCategoryDealVo;
import com.dao.AreaDao;
import com.service.business.AreaBusiness;
import com.service.business.DealBusiness;
import com.service.api.DealCategoryService;
import com.service.business.DealCategoryBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class SpringGroupTestDemo {

	@Autowired
	private DealCategoryService dealCategoryService;

	@Autowired
	private DealCategoryBusiness dealCategoryBusiness;

	@Autowired
	private DealBusiness dealBusiness;

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private AreaBusiness areaBusiness;

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

	@Test
	public void testCache(){
		List<DealCategory> rootNode = dealCategoryBusiness.getRootNode();
		for (DealCategory dc : rootNode){
			System.out.println(dc);
		}
		List<DealCategory> notRootNode = dealCategoryBusiness.getNotRootNode();
		for (DealCategory cdc : notRootNode){
			System.out.println(cdc);
		}
	}

	@Test
	public void testAreaDao(){
		Area area = new Area();
		area.setName("北京市");
		List<Area> areaList = areaDao.getArea(area);
		System.out.println(areaList);
	}

	@Test
	public void testAreaBusiness(){
		Map<String, List<Area>> areaGroup = areaBusiness.getAreaGroup();
		for (String key : areaGroup.keySet()){
			System.out.println("key:  "+ key);
			for (Area area : areaGroup.get(key)){
				System.out.println("Area: "+area);
			}
		}
	}
}


