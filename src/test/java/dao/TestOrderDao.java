package dao;

import com.common.constant.OrderConstant;
import com.common.entity.Order;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestOrderDao {

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    OrderDao orderDao;

    @Test
    public void testDeleteOrderDetail() {
        Long orderId = 15L;
        Integer integer = orderDetailDao.deleteOrderDetail(orderId);
        System.out.println("删除结果为：" + integer);
    }

    @Test
    public void testDeleteOrderBasicInfo() {
        Long orderId = 15L;
        Integer integer = orderDao.deleteOrder(orderId);
        System.out.println("删除的结果为："+ integer);
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        order.setId(16L);
        order.setOrderStatus(OrderConstant.STATUS_ALREADY_PAID);
        Integer result = orderDao.updateOrder(order);
        System.out.println("更新的结果为：" + result);
    }
}
