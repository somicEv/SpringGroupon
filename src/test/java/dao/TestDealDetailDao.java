package dao;

import com.common.entity.deal.DealDetail;
import com.dao.DealDetailDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestDealDetailDao {

    private Logger log = LoggerFactory.getLogger(TestDealDetailDao.class);

    @Autowired
    DealDetailDao dealDetailDao;

    @Test
    public void testGetDealDetail() {
        DealDetail dealDetail = new DealDetail();
        dealDetail.setSkuId(2L);
        DealDetail detail = dealDetailDao.getDealDetailBySkuId(dealDetail);
        log.info("[TestDealDetailDao]testGetDealDetail-->result:{}", detail);
    }
}
