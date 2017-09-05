package com.service.api;


import com.common.entity.user.User;

import java.util.List;

public interface UserApi {

	List<User> get(User user);

	Integer update(User user);

	Integer add(User user);

	Integer delete(User user);

}
