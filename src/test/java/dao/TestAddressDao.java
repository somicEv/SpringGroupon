package dao;

import com.common.entity.area.Address;
import com.dao.AddressDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestAddressDao {

    @Autowired
    AddressDao addressDao;

    @Test
    public void testSelectAddressDetail(){
        List<Address> addressList = addressDao.selectAddressDetail(1L);
        for (Address address : addressList){
            System.out.println(address);
        }
        List<Address> addressList1 = addressDao.selectAddressDetail(14L);
        for (Address address : addressList1){
            System.out.println(address);
        }
    }
}
