package com.service.api;

import com.common.entity.user.UserBasicInfo;
import com.common.vo.QueryMessage;

public interface UserBasicInfoService {

    QueryMessage<UserBasicInfo> selectUserBasicInfo(Long userId);

    QueryMessage<UserBasicInfo> saveUserBasicInfo(UserBasicInfo userBasicInfo);

    QueryMessage<UserBasicInfo> updateUserBasicInfo(UserBasicInfo userBasicInfo);

}
