package business;

import com.common.entity.StartRemind;
import com.service.business.StartRemindBusiness;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
@Slf4j
public class TestStartRemindBusiness {

    @Autowired
    StartRemindBusiness startRemindBusiness;

    @Test
    public void testSave(){
        StartRemind startRemind = new StartRemind();
        startRemind.setDealSkuId(1L);
        startRemind.setUserId(1L);
        startRemind.setDealId(1L);
        startRemind.setDealTitle("测试");
        startRemind.setCreateTime(new Date());
        startRemind.setUpdateTime(new Date());
        startRemind.setStartTime(new Date());
        Integer integer = startRemindBusiness.save(startRemind);
        log.info("结果为："+integer);
    }

}
