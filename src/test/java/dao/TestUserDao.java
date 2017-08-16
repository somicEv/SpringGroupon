package dao;

import com.common.entity.user.User;
import com.database.UserBasicInfoDao;
import com.database.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-dao.xml"})
public class TestUserDao {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserBasicInfoDao userBasicInfoDao;

	@Test
	public void testGetAll(){
		User user = new User();
		List<User> userList = userDao.get(user);
		for (User u : userList){
			System.out.println(u);
		}

		UserIn
	}

	@Test
	public void testInsert(){
		User user = new User();
		user.setName("测试");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		Integer result = userDao.add(user);
		System.out.println("插入结果---"+result);
	}

	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(4);
		user.setName("cdf");
		Integer update = userDao.update(user);
		System.out.println("更新的行数："+update);
	}

	@Test
	public void testDelete(){
		User user = new User();
		user.setId(4);
		Integer delete = userDao.delete(user);
		System.out.println("更新的行数："+delete);
	}

}
