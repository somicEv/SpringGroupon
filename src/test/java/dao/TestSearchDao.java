package dao;

import com.common.constant.GlobalConstant;
import com.common.vo.SearchDTO;
import com.dao.SearchDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestSearchDao {

    @Autowired
    SearchDao searchDao;

    @Test
    public void testGetSearchResultList() {
        Map<String, Object> params = new HashMap<>();
        params.put("keyName", "测试");
        params.put("start", 0);
        params.put("pageSize", GlobalConstant.PAGE_SIZE);
        List<SearchDTO> searchResultList = searchDao.getSearchResultList(params);
        System.out.println(searchResultList);
    }

    @Test
    public void testGetSearchResultByKeyName() {
        String keyName = "试";
        SearchDTO resultByKeyName = searchDao.getResultByKeyName(keyName);
        System.out.println("查询结果为：" + resultByKeyName);
    }

    @Test
    public void testCountSearchResult() {
        Map<String, Object> params = new HashMap<>();
        params.put("keyName", "测试");
        Integer integer = searchDao.countSearchResult(params);
        System.out.println(integer);

    }
}
