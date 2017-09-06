package dao;

import com.common.entity.Favorite;
import com.dao.FavoriteDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestFavoriteDao {

    @Autowired
    private FavoriteDao favoriteDao;

    @Test
    public void testSave() {
        Favorite favorite = new Favorite();
        favorite.setId(1L);
        favorite.setUserId(1L);
        favorite.setDealId(1L);
        favorite.setDealSkuId(1L);
        favorite.setUpdateTime(new Date());
        favorite.setCreateTime(new Date());
        Integer save = favoriteDao.save(favorite);
        System.out.println(save);
    }

}
