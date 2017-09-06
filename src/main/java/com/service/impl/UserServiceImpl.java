package com.service.impl;

import com.common.entity.user.User;
import com.dao.UserDao;
import com.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> get(User user) {
		return userDao.get(user);
	}

	@Override
	public Integer update(User user) {
		return userDao.update(user);
	}

	@Override
	public Integer add(User user) {
		return userDao.add(user);
	}

	@Override
	public Integer delete(User user) {
		return userDao.delete(user);
	}
}
