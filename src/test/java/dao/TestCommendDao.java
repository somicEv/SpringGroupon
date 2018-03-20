package dao;

import com.common.entity.Commend;
import com.dao.CommendDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestCommendDao {
    @Autowired
    CommendDao commendDao;

    @Test
    public void testGetCommendList() {
        Map<String, Object> params = new HashMap<>();
        params.put("skuId", 2);
        List<Commend> commendList = commendDao.getCommendList(params);
        System.out.println(commendList);
    }
}
