package dao;

import com.common.entity.Recommend;
import com.dao.RecommendDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestRecommendDao {

    @Autowired
    RecommendDao recommendDao;

    @Test
    public void testGetRecommendList() {
        List<Recommend> recommendList = recommendDao.getRecommendList();
        System.out.println(recommendList.toString());
    }



}
