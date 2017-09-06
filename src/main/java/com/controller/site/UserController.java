package com.controller.site;

import com.common.constant.WebConstants;
import com.common.entity.user.User;
import com.common.entity.user.WebUser;
import com.controller.common.FrontendBaseController;
import com.service.business.UserBusiness;
import com.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static org.springframework.util.DigestUtils.md5DigestAsHex;

@Controller
public class UserController extends FrontendBaseController{

	@Autowired
	private UserBusiness userBusiness;

	@RequestMapping(value = "/login")
	public String login(){
		return "/user/login";
	}

	@RequestMapping(value = "/reg")
	public String register(){
		return "/user/register";
	}

	@RequestMapping(value = "/dologin")
	public String doLogin(String name,String password,HttpServletResponse response){
		// 将用户的密码进行MD5加密
		String md5DigestAsHex = md5DigestAsHex(password.getBytes());
		// 在数据库中查找
		User user = new User();
		user.setName(name);
		user.setPassword(md5DigestAsHex);
		User resultUser = userBusiness.dologin(user);
		if(resultUser == null){
			return "redirect:/login";
		}
		// 存入Cookie
		WebUser webuser = new WebUser();
		webuser.setUserId(resultUser.getId().longValue());
		webuser.setUsername(resultUser.getName());
		webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
		CookieUtil.setLoginUser(response,webuser);
		// 更新用户信息
		User userTemplate = new User();
		userTemplate.setId(resultUser.getId());
		userTemplate.setLoginTime(new Date());
		return "redirect:/index.html";
	}

	@RequestMapping(value = "/register")
	public String doRegister(User user, HttpServletResponse response){
		// 查询数据库
		boolean result = userBusiness.doRegister(user);
		if (!result){
			return "redirect:/reg";
		}
		// 存入Cookie
		WebUser webuser = new WebUser();
		webuser.setUsername(user.getName());
		webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
		CookieUtil.setLoginUser(response,webuser);
		return "redirect:/index.html";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response){
		CookieUtil.removeCookie(response,"ui","/");
		return "redirect:/index.html";
	}
}
