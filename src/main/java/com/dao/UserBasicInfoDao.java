package com.dao;

import com.common.entity.user.UserBasicInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBasicInfoDao {

	List<UserBasicInfo> get(UserBasicInfo userBasicInfo);

	Integer update(UserBasicInfo userBasicInfo);

	Integer delete(UserBasicInfo userBasicInfo);

	Integer add(UserBasicInfo userBasicInfo);

}
