package com.service.business;

import com.common.entity.user.User;
import com.common.entity.user.UserBasicInfo;
import com.common.entity.user.WebUser;
import com.common.vo.QueryMessage;
import com.service.api.UserBasicInfoService;
import com.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

import static org.springframework.util.DigestUtils.md5DigestAsHex;

@Component
public class UserBusiness {

    @Autowired
    UserService userService;

    @Autowired
    UserBasicInfoService userBasicInfoService;

    /**
     * 执行用户登录操作
     *
     * @param user
     * @return
     */
    public User doLogin(User user) {
        List<User> userList = userService.get(user);
        if (userList == null || userList.size() == 0) {
            return new User();
        }
        return userList.get(0);
    }

    /**
     * 执行用户注册操作
     *
     * @return
     */
    public boolean doRegister(User user) {
        // 验证数据准确性
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        // 补全数据
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setLoginTime(new Date());
        // 对密码进行加密
        String md5Password = md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        // 存入数据库
        Integer integer = userService.add(user);
        if (integer < 0) {
            return false;
        }
        return true;
    }

    /**
     * 查询用户详细信息
     *
     * @param webUser
     * @return
     */
    public QueryMessage<UserBasicInfo> selectUserBasicInfo(WebUser webUser) {
        return userBasicInfoService.selectUserBasicInfo(webUser.getUserId());
    }

    /**
     * 添加新的用户基本信息
     *
     * @param userBasicInfo
     * @return
     */
    public QueryMessage<UserBasicInfo> saveUserBasicInfo(UserBasicInfo userBasicInfo) {
        return userBasicInfoService.saveUserBasicInfo(userBasicInfo);
    }

    /**
     * 更新用户基本信息
     *
     * @param userBasicInfo
     * @return
     */
    public QueryMessage<UserBasicInfo> updateUserBasicInfo(UserBasicInfo userBasicInfo) {
        return userBasicInfoService.updateUserBasicInfo(userBasicInfo);
    }
}
