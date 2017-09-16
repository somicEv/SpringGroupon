package com.service.impl;

import com.common.constant.CartConstant;
import com.common.constant.GlobalConstant;
import com.common.entity.user.UserBasicInfo;
import com.common.vo.QueryMessage;
import com.dao.UserBasicInfoDao;
import com.service.api.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBasicInfoServiceImpl implements UserBasicInfoService{

    @Autowired
    UserBasicInfoDao userBasicInfoDao;

    @Override
    public QueryMessage<UserBasicInfo> selectUserBasicInfo(String username) {
        UserBasicInfo user = new UserBasicInfo();
        user.setNickname(username);
        List<UserBasicInfo> infoList = userBasicInfoDao.get(user);
        if (infoList == null || infoList.size() != 1){
            return new QueryMessage<>(GlobalConstant.QUERY_RESULT_NOTFOUND, CartConstant.ERROR);
        }
        return new QueryMessage<>(GlobalConstant.QUERY_RESULT_OK,CartConstant.SUCCESS,infoList.get(0));
    }

    @Override
    public QueryMessage<UserBasicInfo> saveUserBasicInfo(UserBasicInfo userBasicInfo) {
        Integer result = userBasicInfoDao.add(userBasicInfo);
        if (result != 1){
            return new QueryMessage<>(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage<>(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }

    @Override
    public QueryMessage<UserBasicInfo> updateUserBasicInfo(UserBasicInfo userBasicInfo) {
        Integer result = userBasicInfoDao.update(userBasicInfo);
        if (result != 1){
            return new QueryMessage<>(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage<>(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }
}
