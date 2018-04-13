package dao;

import com.common.vo.NewspaperDTO;
import com.dao.NewsPaperDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestNewspaperDao {

    private Logger log = LoggerFactory.getLogger(TestNewspaperDao.class);

    @Autowired
    NewsPaperDao newsPaperDao;

    @Test
    public void testGetNewspaperList() {
        List<NewspaperDTO> result = newsPaperDao.getList();
        log.info("[TestNewspaper]testGetNewspaperList-->resultList:{}", result);
    }
}
