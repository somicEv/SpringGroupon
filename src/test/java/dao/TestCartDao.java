package dao;

import com.common.entity.Cart;
import com.dao.CartDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestCartDao {

    @Autowired
    CartDao cartDao;

    @Test
    public void testSaveDealCart(){
        Cart cart = new Cart();
        cart.setUserId(1L);
        cart.setUpdateTime(new Date());
        cart.setDealSkuId(1L);
        cart.setDealId(1L);
        cart.setCreateTime(new Date());
        cart.setDealCount(1);
        log.info("添加后结果为："+cartDao.saveDealCart(cart));
    }

    @Test
    public void testUpdateDealCount(){
        Cart params = new Cart();
        params.setDealId(1L);
        params.setUpdateTime(new Date());
        params.setDealCount(2);
        params.setDealSkuId(1L);
        params.setUserId(1L);
        log.info("更新后的结果为："+cartDao.updateDealCount(params));
    }

    @Test
    public void testSelectDealCart(){
        Cart cart = new Cart();
        cart.setUserId(1L);
        cart.setDealSkuId(1L);
        cart.setDealId(1L);
        log.info("查询结果为："+cartDao.selectDealCart(cart).toString());
    }

    @Test
    public void testSelectDealCartList(){
        Cart cart = new Cart();
        cart.setUserId(14L);
        List<Cart> resultList =cartDao.selectDealCartList(cart);
        log.info("查询结果为："+resultList.toString());
    }

    @Test
    public void testDeleteDealCart() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 21);
        List<Integer> idList = new ArrayList<>();
        idList.add(7);
        idList.add(8);
        params.put("idList", idList);
        Integer integer = cartDao.deleteDealFromCart(params);
        System.out.println(integer);
    }
}
