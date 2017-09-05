package com.dao;

import com.common.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

	List<User> get(User user);

	Integer update(User user);

	Integer delete(User user);

	Integer add(User user);


}
