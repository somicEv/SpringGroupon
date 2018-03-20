package dao;

import com.common.entity.deal.Deal;
import com.dao.DealDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestDealDao {

    @Autowired
    DealDao dealDao;

    @Test
    public void testGetNewArrivalsGoods() {
        Map<String, Object> params = new HashMap<>();
        params.put("publishStatus", 3);
        params.put("endTime", new Date());
        List<Deal> newArrivalsGoods = dealDao.getNewArrivalsGoods(params);

        System.out.println(newArrivalsGoods.subList(0,2));
    }

}
