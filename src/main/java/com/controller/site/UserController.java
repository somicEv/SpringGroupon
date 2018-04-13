package com.controller.site;

import com.common.constant.WebConstants;
import com.common.entity.user.User;
import com.common.entity.user.WebUser;
import com.controller.common.FrontendBaseController;
import com.service.business.UserBusiness;
import com.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static org.springframework.util.DigestUtils.md5DigestAsHex;

@Controller
public class UserController extends FrontendBaseController {

    @Autowired
    private UserBusiness userBusiness;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "/user/login";
    }

    /**
     * 跳转注册页面
     *
     * @return
     */
    @RequestMapping(value = "/reg")
    public String register() {
        return "/user/register";
    }

    /**
     * 执行登录操作
     *
     * @param name     用户名
     * @param password 密码
     * @param response
     * @return
     */
    @RequestMapping(value = "/dologin")
    public String doLogin(String name, String password, HttpServletResponse response, Model model) {
        try {
            // 将用户的密码进行MD5加密
            String md5DigestAsHex = md5DigestAsHex(password.getBytes());
            // 在数据库中查找
            User user = new User();
            user.setName(name);
            user.setPassword(md5DigestAsHex);
            User resultUser = userBusiness.doLogin(user);
            if (resultUser == null) {
                return "redirect:/login";
            }
            // 存入Cookie
            WebUser webuser = new WebUser();
            webuser.setUserId(resultUser.getId().longValue());
            webuser.setUsername(resultUser.getName());
            webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
            CookieUtil.setLoginUser(response, webuser);
            // 更新用户信息
            User userTemplate = new User();
            userTemplate.setId(resultUser.getId());
            userTemplate.setLoginTime(new Date());
            model.addAttribute("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result", 0);
            return "redirect:/index";
        }
        return "redirect:/index";
    }

    /**
     * 执行注册操作
     *
     * @param user     需要注册的用户
     * @param response
     * @return
     */
    @RequestMapping(value = "/register")
    public String doRegister(User user, HttpServletResponse response) {
        // 查询数据库
        try {
            boolean result = userBusiness.doRegister(user);
            if (!result) {
                return "redirect:/reg";
            }
            // 查询用户userId
            User reg_user = userBusiness.doLogin(user);
            // 存入Cookie
            WebUser webuser = new WebUser();
            webuser.setUserId(reg_user.getId().longValue());
            webuser.setUsername(user.getName());
            webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
            CookieUtil.setLoginUser(response, webuser);
        } catch (Exception e) {
            this.generateError500Page(response);
        }
        return "redirect:/index";
    }

    /**
     * 退出登录
     * TODO 待修改 目前处于失效状态
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        CookieUtil.removeCookie(response, request, "ui", "/");
        return "redirect:/index";
    }
}
