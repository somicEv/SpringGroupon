package dao;

import com.common.entity.user.User;
import com.common.entity.user.UserBasicInfo;
import com.dao.UserBasicInfoDao;
import com.dao.UserDao;
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


	public User createUser(){
		User user = new User();
		user.setName("测试");
		user.setPassword("123456");
		user.setLoginTime(new Date());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		return user;
	}


	public UserBasicInfo createInfo(){
		UserBasicInfo userBasicInfo = new UserBasicInfo();
		userBasicInfo.setNickname("asdf");
		userBasicInfo.setRealName("qwer");
		userBasicInfo.setPhone("1");
		userBasicInfo.setMail("13011182178@163.com");
		userBasicInfo.setCreateTime(new Date());
		userBasicInfo.setUpdateTime(new Date());
		return userBasicInfo;
	}

	@Test
	public void testGetAll(){
		User user = new User();
		user.setName("yuhaohan");
		List<User> userList = userDao.get(user);
		for (User u : userList){
			System.out.println(u);
		}
	}

	@Test
	public void testInsert(){
		User user = createUser();
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

	@Test
	public void testUserBasisInfoAdd(){
		UserBasicInfo info = createInfo();
		Integer add = userBasicInfoDao.add(info);
		System.out.println(add);
	}

	@Test
	public void testUserBasicInfoUpdate(){
		UserBasicInfo info = createInfo();
		info.setId(2);
		info.setRealName("qwer");
		Integer update = userBasicInfoDao.update(info);
		System.out.println(update);
	}

	@Test
	public void testUserBasicInfoGet(){
		UserBasicInfo userBasicInfo = new UserBasicInfo();
		List<UserBasicInfo> userBasicInfos = userBasicInfoDao.get(userBasicInfo);
		System.out.println(userBasicInfos);
	}
	@Test
	public void testUserBasicInfoDelete(){
		UserBasicInfo userBasicInfo = new UserBasicInfo();
		userBasicInfo.setId(2);
		userBasicInfoDao.delete(userBasicInfo);
	}

}
